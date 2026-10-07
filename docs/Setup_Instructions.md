# Setup and Run Instructions

## Prerequisites

- **JDK 17** is required to run the LearnTrack project.
- A code editor/IDE is optional. The project can be compiled and run directly from the terminal.

## 1. Verify Java Installation

Open a terminal and run:

```bash
java -version
javac -version
```

Both commands should display JDK 17 (or a compatible Java 17 version) or later.
If both commands work, Java is installed and configured correctly.

---

## Development Setup Used

- **IDE:** IntelliJ IDEA
- **JDK:** OpenJDK 21 (LTS)
- **Java Compiler:** `javac 21.0.12.1`
- **Java Runtime:** OpenJDK 21.0.12.1
- **Architecture:** 64-bit

---

## 2. Run LearnTrack

1. Open a terminal in the LearnTrack project directory.
2. Navigate to the `src` directory.
3. Compile the Java source files.
4. Run the `Main` class.

The application will start with the LearnTrack console menu, allowing you to manage students, courses, and enrollments.

---

## 3. Verify Java with Hello World

Create a file named `HelloWorld.java`:

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
````

Compile the program:

```bash
javac HelloWorld.java
```

Run the program:

```bash
java HelloWorld
```

Expected output:

```text
Hello, World!
```

This confirms that the JDK compiler (`javac`) and Java runtime (`java`) are installed and working correctly.


