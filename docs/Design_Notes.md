# Design Notes

---

## 1. Why did you use `ArrayList` instead of an array?

In LearnTrack, `ArrayList` is used to store collections such as **students, courses, and enrollments**.

We used `ArrayList` because the number of records can change while the application is running.

- An **array has a fixed size** once it is created.
- An `ArrayList` can **grow or shrink dynamically**.
- It provides useful methods such as `add()`, `remove()`, `get()`, and `size()`.
- It makes adding and removing students, courses, and enrollments easier.

For example:

```java
List<Student> students = new ArrayList<>();
````

This allows LearnTrack to add students without deciding the maximum number of students beforehand.

---

## 2. Where did you use `static` members and why?

In LearnTrack, `static` members are mainly used in the **`IdGenerator`** and **`InputValidator`** utility classes.

### `IdGenerator`

The ID counters for studentId, courseId and enrollmentId are static. Example:

```java
private static int studentIdCounter = 1;
````

They are `static` because the counters need to be **shared across all usages** of `IdGenerator`.

The ID generation methods are also static. Example:

```java
public static int generateStudentId();
```

They can be called directly using the class name:

```java
int id = IdGenerator.generateStudentId();
```

There is no need to create an `IdGenerator` object. The private constructor also prevents unnecessary objects from being created.

### `InputValidator`

The validation methods are static because they don't depend on any object-specific data:

```java
InputValidator.validateField("Name", name);
InputValidator.validateEmail(email);
InputValidator.validatePositiveNumber("ID", id);
```

They simply receive input, validate it, and throw `InvalidInputException` when the input is invalid.

### In Short

We use `static` when the functionality belongs to the **class itself** and does not require object-specific state.

* **`IdGenerator`** → Shared ID counters and ID generation.
* **`InputValidator`** → Reusable validation methods.

---

## 3. Where did you use inheritance and what did you gain from it?

In LearnTrack, inheritance is used with **`Person` as the parent class** and **`Student` and `Trainer` as child classes**.

```text
             Person
             /    \
        Student   Trainer
````

The `Person` class contains common information such as:

* `id`
* `firstName`
* `lastName`
* `email`

It also provides common methods such as `getFirstName()`, `getEmail()`, and `getDisplayName()`.

`Student` and `Trainer` inherit this common functionality and add their own specific properties:

```text
Student  → batch, active
Trainer  → specialization
```

### What did we gain?

* **Code reuse:** Common fields and methods are defined only once in `Person`.
* **Less duplication:** `Student` and `Trainer` don't need to redefine common person-related functionality.
* **Better organization:** Each child class contains its own specific properties.
* **Polymorphism:** Both `Student` and `Trainer` override `getDisplayName()` to provide their own implementation.

For example:

```java
Person student = new Student(...);
Person trainer = new Trainer(...);

student.getDisplayName();
trainer.getDisplayName();
```

The appropriate overridden method is called based on the actual object.

### In Short

Inheritance allows LearnTrack to **reuse common functionality through `Person`**, while `Student` and `Trainer` specialize that functionality. The overridden `getDisplayName()` also demonstrates **runtime polymorphism**.
