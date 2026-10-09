# JVM Basics

## Java Development Kit (JDK)

**JDK (Java Development Kit)** is a software package used to develop and run Java applications. It provides the necessary tools for writing, compiling, debugging, and executing Java programs.

### Key Points

- Includes **JRE (Java Runtime Environment)** and development tools such as the Java compiler (`javac`).
- Helps developers **compile, run, and debug** Java programs.
- Available for major platforms such as **Windows, Linux, and macOS**.

---

## Java Runtime Environment (JRE)

**Java Runtime Environment (JRE)** is a software package that provides the environment required to run Java applications. It contains the **Java Virtual Machine (JVM)**, core class libraries, and supporting files needed to execute Java bytecode.

JRE is responsible for running Java programs across different platforms.

### Key Points

- Executes **platform-independent Java bytecode**.
- Handles **class loading, memory management, and security checks**.
- Enables Java's **Write Once, Run Anywhere (WORA)** capability.

---

## Java Virtual Machine (JVM)

**Java Virtual Machine (JVM)**  provides the runtime environment for executing Java bytecode. It is a part of the **Java Runtime Environment (JRE)** and is responsible for loading, verifying, and executing Java class files.

The JVM also manages runtime memory and provides services such as **garbage collection**.

### How JVM Works

- Java source code (`.java`) is compiled by `javac` into **bytecode** (`.class`).
- The JVM **loads and links** the required classes before executing them.
- Bytecode can be **interpreted** or compiled into native machine code by the **JIT (Just-In-Time) compiler**.

---

## Java Bytecode and "Write Once and Run Anywhere"

**Bytecode** is an intermediate, platform-independent code generated when a `.java` file is compiled into a `.class` file. This bytecode is executed by the **Java Virtual Machine (JVM)**, enabling Java's **Write Once, Run Anywhere (WORA)** principle.

### Key Points

- Bytecode consists of instructions meant for the **JVM**, not for any specific hardware or operating system.
- It ensures **platform independence**, allowing the same program to run on different systems.
- Bytecode is **verified by the JVM** for security before execution.
- It supports efficient execution through **interpretation and JIT (Just-In-Time) compilation**.

### How is Bytecode Generated?

The execution of a Java program happens in the following steps:

1. **Source Code:** The programmer writes code in a high-level language such as Java.
2. **Compilation:** The Java compiler (`javac`) converts the source code into bytecode (`.class` file).
3. **Execution by JVM:** The JVM loads and executes the bytecode using an interpreter and **Just-In-Time (JIT) compiler**.

Bytecode acts as a **bridge between the compiler and the JVM**, making Java platform-independent.

