# Java Theory Interview Questions & Answers

# What is JDK?
Java Development Kit (JDK) = JRE + Development Tools Includes: - javac
(compiler) - javadoc - debugger - jar tool

# What is JRE?
Java Runtime Environment (JRE) contains: - JVM - Core libraries -
Supporting files required to run Java programs

# What is JVM?
The Java Virtual Machine (JVM) executes Java bytecode. It provides
platform independence by converting bytecode into machine-specific
instructions.

Flow: Source Code (.java) → Compiler (javac) → Bytecode (.class) → JVM →
Machine Code

It cannot compile Java code.

# What are OOP principles?
## 🔹 Abstraction

Abstraction is the concept of exposing only essential behavior while hiding internal implementation details. It focuses on **what an object does**, not how it does it.

It is achieved using:

* Interfaces
* Abstract classes

Abstraction allows users to interact with objects without knowing their internal logic.

## 🔹 Encapsulation

Encapsulation is the bundling of data and methods operating on that data into a single unit while restricting direct access to internal state.

It is achieved using:

* Access modifiers (`private`, `protected`, `public`)
* Controlled access through methods

Encapsulation ensures data protection and controlled modification.

## 🔹 Inheritance

Inheritance is the mechanism by which one class acquires the properties and behavior of another class.

* Represents an **"is-a"** relationship.
* Promotes code reuse.
* Java supports single class inheritance and multiple interface implementation.
* Multiple class inheritance is not allowed to avoid ambiguity (Diamond Problem).

## 🔹 Polymorphism

Polymorphism allows one interface to represent different underlying forms.

Two types:

* **Compile-time Polymorphism (Method Overloading)**
  Same method name, different parameter lists.

* **Runtime Polymorphism (Method Overriding)**
  A subclass provides a specific implementation of a method already defined in the parent class.

# Example of Encapsulation
Encapsulation binds data and methods together and restricts direct
access using private fields.

``` java
class Person {
    private String name;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
```

Why important? - Protects data integrity - Allows validation before
setting values

# Example of Inheritance
Inheritance allows one class to acquire properties of another.

``` java
class Animal {
    void eat() { System.out.println("Eating"); }
}

class Dog extends Animal {
    void bark() { System.out.println("Barking"); }
}
```

Benefits: - Code reuse - Hierarchical classification

# What is the Diamond Problem?
The Diamond Problem occurs when multiple inheritance creates ambiguity in method resolution.

Example scenario (if multiple class inheritance were allowed):

```
      A
     / \
    B   C
     \ /
      D
```

If both B and C override a method from A, class D would not know which implementation to inherit.

Java avoids this by:

* Disallowing multiple class inheritance
* For interfaces with default methods, forcing the implementing class to override and resolve ambiguity

# Example of Polymorphism
Same method behaves differently depending on object.

Compile-time (Overloading):

``` java
int add(int a, int b) { return a+b; }
double add(double a, double b) { return a+b; }
```

Runtime (Overriding):

``` java
class Animal {
    void sound() { }
}

class Dog extends Animal {
    @Override
    void sound() { System.out.println("Bark"); }
}
```

# Example of Abstraction
Abstraction is the concept of exposing only essential behavior while hiding internal implementation details. It focuses on **what an object does**, not how it does it.

It is achieved using:

* Interfaces
```java
interface Shape {
    void draw();
}
```

* Abstract classes
``` java
abstract class Shape {
    abstract void draw();
}
```

Abstraction allows users to interact with objects without knowing their internal logic.

# Autoboxing & Unboxing
In Java, **auto-boxing** and **unboxing** are features introduced in Java 5 that help in the automatic conversion between **primitive types** and their corresponding **wrapper classes**. This improves code readability and reduces boilerplate conversion code.
## 1. Auto-boxing  
Auto-boxing is the automatic conversion of a **primitive type** to its corresponding **wrapper class** object. For example, an `int` can be automatically converted to `Integer`, `double` to `Double`, etc.
### Example:  
```java
// Java
public class AutoBoxingExample {
    public static void main(String[] args) {
        int primitiveInt = 100;
        // Auto-boxing: the primitive int is automatically converted to Integer
        Integer wrappedInt = primitiveInt;
        // We can now use wrappedInt as an object
        System.out.println("Wrapped Integer: " + wrappedInt);
        // Auto-boxing works with collections that require objects
        java.util.List<Integer> numbers = new java.util.ArrayList<>();
        numbers.add(primitiveInt); // int is auto-boxed to Integer
        System.out.println("Numbers list: " + numbers);
    }
}
```
**Output**
```
Wrapped Integer: 100
Numbers list: [100]
```
## 2. Unboxing  
Unboxing is the reverse process where a **wrapper class object** is converted back to its corresponding **primitive type** automatically.
### Example:  
```java
// Java
public class UnboxingExample {
    public static void main(String[] args) {
        Integer wrappedInt = new Integer(200);
        // Unboxing: the Integer object is automatically converted to int
        int primitiveInt = wrappedInt;
        System.out.println("Primitive int: " + primitiveInt);
        // Unboxing works in operations
        int sum = wrappedInt + 50; // wrappedInt is unboxed automatically
        System.out.println("Sum: " + sum);
    }
}
```
**Output**
```
Primitive int: 200
Sum: 250
```
## 3. Key Points  
- Java **automatically detects** when to auto-box or unbox in most contexts.  
- Auto-boxing is useful when working with **collections** (like `List`, `Set`, `Map`) that only accept objects.  
- Unboxing occurs when an **object needs to be used in a primitive context**, such as arithmetic operations, comparisons, or method calls expecting primitives.  
- **Null Safety**: Be careful, unboxing a `null` wrapper object causes `NullPointerException`.  
  
### Example with NullPointerException:  
```java
// Java
public class NullUnboxing {
    public static void main(String[] args) {
        Integer wrapped = null;
        try {
            int primitive = wrapped; // This will throw NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Error: " + e);
        }
    }
}
```
**Output**
```
Error: java.lang.NullPointerException
```
## Conclusion  
Auto-boxing and unboxing make Java code cleaner and less verbose by automatically converting between primitives and their corresponding wrapper classes. However, developers must be aware of potential **null values** to avoid runtime exceptions. This feature is particularly helpful when working with generic collections.

# Wrapper classes
**Wrapper classes in Java are object representations of Java's primitive data types, allowing primitives to be treated as objects.**

## Overview  
In Java, **primitive types** like `int`, `double`, `char`, and `boolean` are not objects, which limits their use in certain contexts, such as in collections that require objects (e.g., `ArrayList`, `HashMap`). **Wrapper classes** provide a way to encapsulate these primitive types into objects.
## List of Wrapper Classes  
Each primitive type has a corresponding wrapper class in the `java.lang` package:
- `byte` → `Byte`    
- `short` → `Short`    
- `int` → `Integer`    
- `long` → `Long`    
- `float` → `Float`    
- `double` → `Double`    
- `char` → `Character`    
- `boolean` → `Boolean`    
  
## Key Features  
1. **Object Representation**: Primitives can be wrapped into objects for usage in APIs or collections that require objects.    
  
    ```java
    Integer num = Integer.valueOf(10); // wrapping int into Integer object
    ArrayList<Integer> list = new ArrayList<>();
    list.add(20); // autoboxing converts int to Integer automatically
    ```
2. **Utility Methods**: Wrapper classes provide useful static and instance methods. For example:    
   - `Integer.parseInt("123")` converts a `String` to an `int`.    
   - `Double.toString(3.14)` converts a double value to a `String`.    
   - `Character.isDigit('5')` checks if a character is a digit.    
  
3. **Autoboxing and Unboxing**: Java automatically converts between primitives and wrapper objects:  
   - **Autoboxing**: Converting a primitive to a wrapper object automatically.    
  
    ```java
    Integer obj = 100; // int 100 is autoboxed to Integer
    ```
- **Unboxing**: Converting a wrapper object back to a primitive automatically.    
  
    ```java
        int value = obj; // Integer obj unboxed to int
    ```
4. **Nullability**: Wrappers can be `null`, which is not possible with primitive types. This is useful for databases or optional values.  
  
## Use Cases  
- Required in **collections** like `ArrayList<Integer>` because collections can't store primitives.    
- Useful for **generics**, **serialization**, and **utility operations**.    
- Helps in **converting between Strings and numeric/boolean types** for input parsing.  
  
In summary, **wrapper classes bridge the gap between Java's primitive types and objects**, enabling powerful features like use in collections, method calls needing objects, and utility functions for type manipulation.

# Can we override private or static methods?
In Java, **method overriding** is a mechanism that allows a subclass to provide a specific implementation for a method that is already defined in its superclass. However, **private** and **static** methods behave differently in the context of overriding:

## 1. Private Methods  
  
- **Cannot be overridden** because they are **not visible to subclasses**.  
- Private methods belong strictly to the class in which they are defined.  
- If a subclass defines a method with the same name and parameters as a private method in the superclass, it is treated as a completely **new method**, not an override.  
  
```java
class Parent {
    private void display() {
        System.out.println("Parent private display");
    }
}
class Child extends Parent {
    private void display() {
        System.out.println("Child private display");
    }
}
public class Test {
    public static void main(String[] args) {
        Parent obj = new Child();
        // obj.display(); // Compile-time error: display() has private access
    }
}
```
### Key Point: Private methods are used for encapsulation, internal logic, and maintaining class invariants. They are intentionally hidden from subclasses.

## 2. Static Methods  
  
- **Cannot be overridden**, they are **hidden**, not overridden.  
- Static methods belong to the class (compile-time binding), not to instances (runtime polymorphism).  
- Declaring a static method with the same signature in a subclass **hides** the superclass method, instead of overriding it.  
  
```java
class Parent {
    static void show() {
        System.out.println("Parent static show");
    }
}
class Child extends Parent {
    static void show() {
        System.out.println("Child static show");
    }
}
public class Test {
    public static void main(String[] args) {
        Parent obj = new Child();
        obj.show(); // Output: Parent static show
        Child.show(); // Output: Child static show
    }
}
```
### Key Point: Static methods are resolved at compile time using the **reference type**, not the object type. This is why overriding doesn’t apply to static methods.

## Summary
  
| Method Type | Can be overridden? | Notes |  
|------------|-----------------|------|  
| private    | No              | They are class-specific and hidden from subclasses. |  
| static     | No              | They can be hidden but are resolved at compile-time via class reference. |  
| normal/non-final | Yes         | Supports true overriding and runtime polymorphism. |  
| final      | No              | Cannot override to maintain consistent behavior. |  
  
  
**Conceptual Understanding:**
- **Private methods**: You can't override because they are for encapsulation and internal class logic.  
- **Static methods**: Polymorphism doesn’t apply; they are tied to the class, not the instance.  
  
By restricting overriding for private and static methods, Java ensures **encapsulation and predictable method invocation** behavior.

# What is final?
The final keyword is used to restrict modification. It can be applied to variables, methods, and classes:
* Final Variables: Once assigned, their value cannot change.
* Final Methods: Cannot be overridden by subclasses.
* Final Classes: Cannot be inherited.

```java
// Final variable
final int MAX_USERS = 100;

// Final method
class Parent {
    final void showMessage() {
        System.out.println("This is a final method.");
    }
}

// Final class
final class Constants {
    int value = 10;
}

// Attempting to inherit from a final class will cause an error
// class Child extends Constants {} // Error
```
### Key Notes:
* Final variables must be initialized once (either at declaration or constructor for instance variables).
* Final methods help to prevent changing critical behavior.
* Final classes are used to prevent inheritance.

# What is finally?
finally is used with try-catch blocks and is executed regardless of whether an exception occurs. It ensures that necessary cleanup occurs, such as closing files or releasing resources.

```java
import java.io.*;

public class FinallyDemo {
    public static void main(String[] args) {
        FileReader reader = null;
        try {
            reader = new FileReader("data.txt");
            int data = reader.read();
            System.out.println("First character: " + (char)data);
        } catch (IOException e) {
            System.out.println("Exception caught: " + e.getMessage());
        } finally {
            // Always executed
            try {
                if(reader != null)
                    reader.close();
                System.out.println("File closed in finally block.");
            } catch (IOException e) {
                System.out.println("Error closing file.");
            }
        }
    }
}
```
### Key Notes:
* finally always executes, even if a return statement is used inside try or catch.
* Typical uses include closing files, database connections, or other cleanup actions.

# What is finalize()?
finalize() is a method of the Object class. It is called by the garbage collector before an object is destroyed. It is mainly used to release resources that were not explicitly released.

```java
class Demo {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize() method called, object is being garbage collected");
        super.finalize();
    }
}

public class FinalizeDemo {
    public static void main(String[] args) {
        Demo obj = new Demo();
        obj = null; // Make eligible for garbage collection
        System.gc(); // Request garbage collection
        System.out.println("End of main");
    }
}
```
### Key Notes:
* finalize() is not guaranteed to be called immediately or at all.
* Use try-with-resources or explicit cleanup instead of relying on finalize().
* Rare resource cleanup (deprecated in modern Java).

# What is try-with-resources

In Java, **try-with-resources** is a feature introduced in **Java 7** that simplifies resource management, particularly for objects that implement the `AutoCloseable` interface (like streams, readers, writers, sockets, database connections, etc.). It ensures that resources are **automatically closed** after use, helping to prevent resource leaks, which were common in traditional try-catch-finally blocks.
## Key Features
1. **Automatic resource management:** No need to explicitly close resources in a `finally` block.
2. **Works with `AutoCloseable` objects:** Any class that implements `AutoCloseable` can be used.
3. **Handles exceptions efficiently:** Both exceptions thrown during the resource usage and exceptions thrown while closing the resource are properly handled.
  
## Syntax
  
```java
try (ResourceType resource = new ResourceType()) {
    // Use the resource
} catch (ExceptionType e) {
    // Handle exceptions
}
```
Multiple resources can also be managed together:
```java
try (ResourceType res1 = new ResourceType();
ResourceType res2 = new ResourceType()) {
    // Use resources
} catch (ExceptionType e) {
    // Handle exceptions
}
```
## Example 1: Using a FileReader
  
```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class TryWithResourcesExample {
    public static void main(String[] args) {
        // Automatically closes BufferedReader after usage
        try (BufferedReader br = new BufferedReader(new FileReader("example.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
### Explanation:
- `BufferedReader` implements `AutoCloseable`.  
- Once the try block completes, `br.close()` is automatically called, whether an exception occurs or not.  
- Reduces boilerplate code compared to traditional try-finally blocks.  
  
## Example 2: Multiple Resources
  
```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class MultiResourceExample {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("input.txt");
        FileOutputStream fos = new FileOutputStream("output.txt")) {
            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
## Benefits:  
1. **Simpler code:** Avoids explicit `finally` blocks for closing resources.  
2. **Exception safety:** Guarantees resources are closed even if exceptions occur.  
3. **Readable and maintainable:** Reduces clutter in resource management code.  
  
## Summary  
  
The `try-with-resources` construct in Java is a powerful feature that makes resource management clean, safe, and less error-prone. It allows you to focus on **using resources** rather than **closing them manually**, leading to better, more maintainable code.  
This is considered a best practice when working with IO, database connections, or any other `AutoCloseable` resources.

# What is String Pool?
In Java, the **String Pool** (also called **Interned Strings Pool**) is a special area in the **heap memory** where Java stores **unique string literals**. The main purpose of the string pool is **memory optimization** and **performance improvement** when dealing with strings.
## Key Characteristics of String Pool
  
1. **String literals are stored in the pool:** Strings declared using double quotes (`"example"`) are automatically added to the string pool.
2. **Duplicate strings are avoided:** If a string literal already exists in the pool, Java reuses the existing reference instead of creating a new object.
3. **Created using `new` keyword are not pooled by default:** Using `new String("example")` creates a new object in the heap outside the pool.
4. **`intern()` method:** You can explicitly add strings to the pool using `String.intern()`. If the pool already contains an equal string, it returns the reference to the pooled string.
  
## Example 1: String Pool with Literals
  
```java
public class StringPoolExample {
    public static void main(String[] args) {
        // String literals
        String str1 = "Hello";
        String str2 = "Hello";
        // Both references point to the same object in the string pool
        System.out.println(str1 == str2);  // Output: true
        System.out.println(str1.equals(str2)); // Output: true
    }
}
```
### Explanation:
- `str1` and `str2` are string literals.  
- Java stores "Hello" in the string pool and both `str1` and `str2` point to the same memory address.  
- `==` compares references, `equals()` compares values.  
  
## Example 2: Strings Created with `new`  
  
```java
public class StringNewExample {
    public static void main(String[] args) {
        String str3 = new String("Hello");
        String str4 = new String("Hello");
        System.out.println(str3 == str4);  // Output: false
        System.out.println(str3.equals(str4)); // Output: true
    }
}
```
### Explanation:
- `str3` and `str4` are different objects in the heap, hence `==` is `false`.  
- Their values are the same, so `equals()` returns `true`.  
  
## Example 3: Using `intern()` method  
  
```java
public class StringInternExample {
    public static void main(String[] args) {
        String str5 = new String("World");
        String str6 = str5.intern();  // This string is now in the string pool
        String str7 = "World";
        System.out.println(str5 == str6); // Output: false (str5 is still on heap)
        System.out.println(str6 == str7); // Output: true (str6 and str7 point to pool)
    }
}
```
## Summary:
- **String Pool** saves memory by storing **only one copy of each string literal**.  
- **Use string literals whenever possible** for efficiency.  
- **Explicit interning** can help avoid unnecessary memory usage.  
- It’s especially useful in scenarios with many repeated strings such as identifiers, keys, or configuration values.   
- Understanding the pool is also important for **comparing strings correctly using `==` vs `equals()`**.

# What is StringBuffer and StringBuilder
**StringBuffer is a thread-safe mutable sequence of characters, whereas StringBuilder is a non-synchronized, faster mutable sequence of characters for single-threaded operations.**

## 1. StringBuffer
### Definition and Purpose:
`StringBuffer` is a **mutable sequence of characters** in Java. Since it is **synchronized**, it is safe to use in **multi-threaded environments**, where multiple threads might modify the content simultaneously. Unlike `String`, it does not create a new object each time the content changes, improving efficiency when performing many modifications.
#### Basic Example: 
```java
public class StringBufferExample {
    public static void main(String[] args) {
        StringBuffer sbuf = new StringBuffer("Hello");
        sbuf.append(" World");   // Append method
        sbuf.insert(5, ",");     // Insert a comma
        sbuf.delete(6, 11);      // Delete characters from index 6 to 10
        sbuf.reverse();          // Reverse the sequence
        System.out.println("StringBuffer: " + sbuf);
    }
}
```
#### Output:
```
StringBuffer: ,olleH
```
### Thread Safety:
Being synchronized, `StringBuffer` ensures that even if multiple threads modify it concurrently, operations are **thread-safe**. This makes it ideal for applications where shared mutable strings are accessed across threads.
### Common Methods:
- `append(String str)` – adds text to the end    
- `insert(int index, String str)` – inserts text at a specific index    
- `delete(int start, int end)` – removes characters within a range    
- `replace(int start, int end, String str)` – replaces characters in a range    
- `reverse()` – reverses the entire character sequence    
- `length()` – returns the number of characters    
- `substring(int start, int end)` – extracts a portion of the sequence    
  
### Performance:
Slightly slower than `StringBuilder` due to synchronization overhead, but reliability in multi-threaded scenarios compensates.

## 2. StringBuilder
  
### Definition and Purpose: 
`StringBuilder` is also a **mutable sequence of characters**, but it is **not synchronized**, making it faster than `StringBuffer` for single-threaded operations. It is preferred when **thread safety is not a concern**.

#### Basic Example:
```java
public class StringBuilderExample {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Java");
        sb.append(" Programming");  // Append
        sb.insert(0, "Learn ");     // Insert at beginning
        sb.delete(5, 10);            // Delete characters 5 to 9
        sb.reverse();                // Reverse the sequence
        System.out.println("StringBuilder: " + sb);
    }
}
```
#### Output:
```
StringBuilder: gnimmargorP nraeL
```

### Thread Safety:  
Not thread-safe, therefore **faster than StringBuffer** for single-threaded scenarios. It should **not be used in multi-threaded contexts** where the object may be shared.

### Common Methods:
Methods are **identical** to those in `StringBuffer`, including `append()`, `insert()`, `delete()`, `replace()`, `reverse()`, `length()`, and `substring()`.

### Performance:  
Due to lack of synchronization overhead, `StringBuilder` is preferred for operations like **repeated concatenation or large modifications** in single-threaded code.

### Summary
| Feature              | StringBuffer                     | StringBuilder                  |  
|----------------------|----------------------------------|--------------------------------|  
| Thread Safety        | Synchronized (Thread-safe)       | Not synchronized (faster)      |  
| Mutability           | Mutable                          | Mutable                        |  
| Best Use Case        | Multi-threaded modifications     | Single-threaded modifications  |
| Common Methods       | append, insert, delete, replace, reverse, length, substring | Same methods as StringBuffer |
| Performance          | Slightly slower due to synchronization | Faster, no synchronization overhead |
  
### Conclusion: 
Use **StringBuffer** when thread safety is needed, and **StringBuilder** for single-threaded operations to maximize performance while working with mutable strings.

# Reverse a String without using inbuilt methods
```java
public class StringReverseExample {
    public static void main(String[] args) {
        String input = "Hello World";
        char[] chars = input.toCharArray();

        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        System.out.println(new String(chars));
    }
}
```

# Checked Exception
In Java, **exceptions** are events that disrupt the normal flow of a program. Exception handling allows programmers to write code to handle unexpected conditions gracefully. Exceptions in Java are classified into two main types: **checked exceptions** and **unchecked exceptions**.
## What are Checked Exceptions?  
  
**Checked exceptions** are exceptions that are checked **at compile-time**. The Java compiler ensures that these exceptions are either **caught using a try-catch block** or **declared in the method signature using `throws`**. If a checked exception is not handled, the code will not compile.
Common examples of checked exceptions include:
- `IOException`  
- `SQLException`  
- `FileNotFoundException`  
- `ClassNotFoundException`  
  
The main idea behind checked exceptions is that they represent **recoverable conditions** that a programmer should anticipate and handle explicitly.
## Key Characteristics  
1. Checked exceptions are subclasses of `Exception` but **not** subclasses of `RuntimeException`.  
2. The compiler forces handling of checked exceptions at compile-time.  
3. They are used for scenarios like file I/O, database access, or network operations where failure is probable and predictable.  
  
## Example 1: Handling Checked Exception with try-catch  
  
```java
// Example: Reading a file
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class CheckedExceptionExample {
    public static void main(String[] args) {
        try {
            File file = new File("example.txt");
            FileReader fr = new FileReader(file); // FileNotFoundException is checked
            System.out.println("File opened successfully.");
            fr.close();
        } catch (IOException e) { // IOException is superclass of FileNotFoundException
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
```
In this code:
- `FileReader` may throw a `FileNotFoundException` (a checked exception).  
- The exception is handled using a `try-catch` block.  
- If we remove the try-catch, the compiler will give an error.  
  
## Example 2: Declaring Checked Exception using `throws`  
  
```java
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class CheckedThrowsExample {
    public static void readFile() throws IOException {
        File file = new File("example.txt");
        FileReader fr = new FileReader(file); // may throw FileNotFoundException
        System.out.println("File opened successfully.");
        fr.close();
    }
    public static void main(String[] args) {
        try {
            readFile();
        } catch (IOException e) {
            System.out.println("Caught an exception: " + e.getMessage());
        }
    }
}
```
Here:
- Method `readFile()` declares `throws IOException`.  
- The caller must handle or propagate the exception.

## Summary
- Checked exceptions must be **handled or declared**, ensuring that recoverable errors are not ignored.
- They help in writing **robust and error-tolerant programs**.
- Always use checked exceptions when the error condition is something that the calling code can reasonably anticipate and respond to. 
  
By following these practices, Java enforces explicit error handling during compile-time, promoting safer and more maintainable code.

# Unchecked Exception
In Java, exceptions are divided into **checked** and **unchecked** exceptions based on whether the compiler enforces handling or not.
## Definition  
**Unchecked exceptions** are exceptions that **the compiler does not require you to handle explicitly** (i.e., you are not forced to use `try-catch` blocks or declare them using `throws`). They are subclasses of **`RuntimeException`** or **`Error`**.
```java
// Example: Unchecked exception
int divide(int a, int b) {
    return a / b; // ArithmeticException may occur if b is 0
}
```
## Key Characteristics  
1. **RuntimeException subclasses**: All unchecked exceptions inherit from `RuntimeException`. Examples include:  
   - `NullPointerException`  
   - `ArrayIndexOutOfBoundsException`  
   - `ArithmeticException`  
   - `IllegalArgumentException`  
2. **No compulsory handling**: Developers are not forced to catch or declare them.  
3. **Often a result of programming errors**: Typical causes include invalid logic, null references, or incorrect indexing.  
  
## Examples of Unchecked Exceptions  
```java
public class UncheckedExample {
    public static void main(String[] args) {
        // Null pointer exception
        String str = null;
        System.out.println(str.length()); // Throws NullPointerException
        // Array index out of bounds
        int[] arr = new int[3];
        System.out.println(arr[5]); // Throws ArrayIndexOutOfBoundsException
        // Arithmetic exception
        int result = 10 / 0; // Throws ArithmeticException
    }
}
```
## Difference Between Checked and Unchecked Exceptions  
  
| Feature | Checked Exception | Unchecked Exception |  
|---------|-----------------|------------------|  
| Compilation check | Must be handled or declared | Compiler does not enforce handling |  
| Subclass of | `Exception` (not RuntimeException) | `RuntimeException` or `Error` |  
| Examples | `IOException`, `SQLException` | `NullPointerException`, `ArithmeticException` |  
  
  
## Best Practices  
- While unchecked exceptions do not need to be handled, it is a good practice to **write code that avoids them** by using proper validation and null checks.  
- They are suitable for situations where the program cannot reasonably recover, such as programming errors.  
  
## Summary:
Unchecked exceptions occur at runtime and are generally caused by programming mistakes. Java does not require you to handle them explicitly, unlike checked exceptions which must be either caught or declared. Proper preventive coding helps reduce runtime crashes caused by unchecked exceptions.

# What is static?
In Java, the `static` keyword is used to indicate that a particular member (variable, method, nested class, or block) belongs to the **class itself** rather than to instances (objects) of the class. This means you can access static members **without creating an object** of the class.

## Key Points About `static`  
1. **Static Variables (Class Variables):**    
   - Declared with the `static` keyword.    
   - Shared among all instances of the class. If one instance changes the value, it reflects across all objects.

   ```java
    class Counter {
        static int count = 0; // shared among all objects
        void increment() {
            count++;
        }
    }
    public class Main {
        public static void main(String[] args) {
            Counter c1 = new Counter();
            Counter c2 = new Counter();
            c1.increment();
            c2.increment();
            System.out.println(Counter.count); // Output: 2
        }
    }
    ```
2. **Static Methods:**    
   - Can be called **without creating an object**.    
   - Cannot access non-static (instance) variables or methods directly because they belong to objects, not the class.    

   ```java
    class MathUtil {
        static int square(int number) {
            return number * number;
        }
    }
    public class Main {
        public static void main(String[] args) {
            int result = MathUtil.square(5); // No object needed
            System.out.println(result); // Output: 25
        }
    }
    ```
3. **Static Blocks:**    
   - Used for static initialization, executed only once when the class is loaded.    
  
   ```java
    class Example {
        static int value;
        static {
            value = 10;
            System.out.println("Static block executed");
        }
    }
    public class Main {
        public static void main(String[] args) {
            System.out.println(Example.value); // Static block runs once
        }
    }
    ```
4. **Static Nested Classes:**    
   - A nested class declared static can be instantiated without an outer class object.    
  
   ```java
    class Outer {
        static class Nested {
            void display() {
                System.out.println("Static nested class");
            }
        }
    }
    public class Main {
        public static void main(String[] args) {
            Outer.Nested nested = new Outer.Nested();
            nested.display();
        }
    }
    ```
## Summary  
- `static` is used to create **class-level** members.    
- Static members can be accessed without creating an object.
- Static methods cannot directly access non-static members.    
- Useful for shared resources, utility methods, and class-wide constants.    
  
Understanding `static` helps write efficient and well-structured Java code, especially for utility classes and managing shared data.

# What is this keyword?
In Java, the `this` keyword is a **reference variable** that refers to the **current object** of the class in which it is used. It is primarily used within instance methods, constructors, or blocks to indicate the current object and distinguish between instance variables and parameters with the same names.

## Key Uses of `this`
### 1. Referencing Instance Variables
When method parameters have the same names as instance variables, you can use `this` to differentiate them:
```java
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name; // 'this.name' refers to the instance variable
        this.age = age;   // 'age' parameter is distinguished from instance variable
    }
    void display() {
        System.out.println("Name: " + this.name + ", Age: " + this.age);
    }
}
public class Main {
    public static void main(String[] args) {
        Person p = new Person("Alice", 25);
        p.display(); // Output: Name: Alice, Age: 25
    }
}
```
### 2. Invoking Another Constructor in the Same Class
You can call one constructor from another using `this()`. This is known as **constructor chaining**:
```java
class Rectangle {
    int length, width;

    Rectangle() {
        this(10, 5); // Calls the parameterized constructor
    }
    Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }
    void area() {
    System.out.println("Area: " + (length * width));
    }
}
public class Main {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle();
        rect.area(); // Output: Area: 50
    }
}
```
### 3. Passing the Current Object
You can pass `this` from one method or object to another:
```java
class Display {
    void show(Person p) {
        System.out.println("Displaying: " + p.name);
    }
}
class Person {
    String name;

    Person(String name) {
        this.name = name;
    }
    void send(Display display) {
        display.show(this); // Passes the current object to the method
    }
}
public class Main {
    public static void main(String[] args) {
        Display display = new Display();
        Person p = new Person("Bob");
        p.send(display); // Output: Displaying: Bob
    }
}
```
### 4. Returning the Current Object
`this` can be returned from a method to enable **method chaining**:
```java
class Calculator {
    int value = 0;

    Calculator add(int x) {
        this.value += x;
        return this;
    }
    Calculator multiply(int x) {
        this.value *= x;
        return this;
    }
    void show() {
        System.out.println("Value: " + value);
    }
}
public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.add(5).multiply(2).show(); // Output: Value: 10
    }
}
```
## Summary  
- `this` refers to the **current object**.  
- It is used to access instance variables when shadowed by parameters.  
- Enables **constructor chaining** using `this()`.  
- Can pass the current object to other methods or return it for chaining.  
- Improves readability and reduces ambiguity in object-oriented programs.  
  
Understanding `this` is essential for writing clean, maintainable Java code, especially when working with constructors, object references, and method chaining.

# List vs Set
In Java, **List** and **Set** are both interfaces in the **java.util** package, and they are part of the Collections framework. While both store collections of objects, they have different behavior, purpose, and implementation characteristics. Here's a detailed comparison:

## 1. List  
- **Ordered Collection:** Maintains the insertion order of elements. You can access elements by their **index**.    
- **Allows Duplicates:** A list can contain duplicate elements.    
- **Common Implementations:** `ArrayList`, `LinkedList`, `Vector`.    
- **Access by Index:** You can retrieve elements directly via `get(index)`.    
- **Use Case:** When order matters or you need to access elements by position.    
  
### Example:  
```java
import java.util.ArrayList;
import java.util.List;
public class ListExample {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Apple"); // duplicate allowed
        System.out.println(fruits); // Output: [Apple, Banana, Apple]
        System.out.println(fruits.get(1)); // Access by index: Banana
    }
}
```
## 2. Set  
- **Unordered Collection:** Does not maintain insertion order (except specific implementations like `LinkedHashSet` or `TreeSet`).    
- **No Duplicates:** Ensures that each element is unique. Adding duplicates will be ignored.    
- **Common Implementations:** `HashSet`, `LinkedHashSet`, `TreeSet`.    
- **No Index-Based Access:** You cannot retrieve elements by index. You iterate using loops or iterators.    
- **Use Case:** When uniqueness of elements is important or you need fast lookup.    
  
### Example:  
```java
import java.util.HashSet;
import java.util.Set;
public class SetExample {
    public static void main(String[] args) {
        Set<String> fruits = new HashSet<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Apple"); // duplicate ignored
        System.out.println(fruits); // Output: [Apple, Banana] (order may vary)
        // Iterate over Set
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
```
## Key Differences  
  
| Feature               | List                  | Set                  |  
|----------------------|----------------------|--------------------|  
| Order                 | Maintains insertion order | Usually unordered |  
| Duplicates            | Allowed              | Not allowed        |  
| Access by Index       | Yes                  | No                 |  
| Common Implementations| ArrayList, LinkedList, Vector | HashSet, LinkedHashSet, TreeSet |  
| Use Case              | Positional access, duplicates needed | Unique elements, fast lookup |  

## Summary  
- **Use a `List`** when you need **ordered collections** and **duplicates are allowed**.    
- **Use a `Set`** when you need a **unique collection** and **order is not critical** (unless `LinkedHashSet` is used for order preservation).    
  
Understanding these differences helps you choose the right collection based on performance, order requirements, and whether duplicates are acceptable.

# ArrayList Example
The **ArrayList** in Java is a resizable array, part of the `java.util` package. It allows dynamic memory allocation, meaning the size of the ArrayList can grow or shrink as needed. Here's a complete example demonstrating its basic usage.
```java
// Java program to demonstrate ArrayList usage
import java.util.ArrayList;
import java.util.Collections; // For sorting
public class ArrayListExample {
    public static void main(String[] args) {
        // Creating an ArrayList of Strings
        ArrayList<String> fruits = new ArrayList<>();
        // Adding elements to the ArrayList
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Mango");
        // Display the ArrayList
        System.out.println("Fruits ArrayList: " + fruits);
        // Accessing elements by index
        System.out.println("First fruit: " + fruits.get(0));
        // Updating an element
        fruits.set(1, "Grapes");
        System.out.println("After update: " + fruits);
        // Removing an element by index
        fruits.remove(2);
        System.out.println("After removing 3rd element: " + fruits);
        // Checking if an element exists
        if(fruits.contains("Apple")) {
        System.out.println("Apple is in the list");
        }
        // Iterating using for-each loop
        System.out.println("Iterating elements:");
        for(String fruit : fruits) {
        System.out.println(fruit);
        }
        // Sorting ArrayList
        Collections.sort(fruits);
        System.out.println("Sorted Fruits: " + fruits);
        // Size of ArrayList
        System.out.println("Total fruits: " + fruits.size());
        // Clearing all elements
        fruits.clear();
        System.out.println("After clearing: " + fruits);
    }
}
```
### Key Points:  
1. **Adding elements**: `add()` method is used to add items dynamically.  
2. **Accessing elements**: `get(index)` retrieves an element at the specified index.  
3. **Updating elements**: `set(index, newValue)` replaces the element at the specified index.  
4. **Removing elements**: `remove(index)` deletes the element at a particular index.  
5. **Iteration**: You can use enhanced for-loops, `forEach`, or iterators to traverse ArrayList.  
6. **Sorting**: `Collections.sort()` sorts the ArrayList in natural order.  
7. **Dynamic resizing**: The ArrayList automatically grows when new elements are added.  
  
This example covers most fundamental operations, helping you get started with **ArrayList** in Java effectively.

# LinkedList Example
In Java, the `LinkedList` class is part of the `java.util` package and implements the `List` and `Deque` interfaces. It allows for dynamic storage and efficient insertion and deletion. Below is a complete example of how to create, manipulate, and traverse a LinkedList in Java.

```java
// Java Program to demonstrate LinkedList usage
import java.util.LinkedList;
import java.util.Iterator;
public class LinkedListExample {
    public static void main(String[] args) {
        // Create a LinkedList of Strings
        LinkedList<String> fruits = new LinkedList<>();
        // Adding elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.addLast("Mango"); // Add element at the end
        fruits.addFirst("Strawberry"); // Add element at the beginning
        // Display the LinkedList
        System.out.println("LinkedList: " + fruits);
        // Access elements
        System.out.println("First Element: " + fruits.getFirst());
        System.out.println("Last Element: " + fruits.getLast());
        // Remove elements
        fruits.remove("Banana"); // Remove specific element
        fruits.removeFirst(); // Remove first element
        fruits.removeLast(); // Remove last element
        System.out.println("LinkedList after removals: " + fruits);
        // Iterate over the LinkedList using Iterator
        System.out.println("Iterating over LinkedList:");
        Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()) {
        System.out.println(iterator.next());
        }
        // Check if list contains an element
        if (fruits.contains("Cherry")) {
        System.out.println("Cherry is in the list");
        } else {
        System.out.println("Cherry is not in the list");
        }
        // Size of the LinkedList
        System.out.println("Size of LinkedList: " + fruits.size());
    }
}
```
### Explanation in Comments:  
- `add()`, `addFirst()`, `addLast()`: Methods to insert elements.  
- `getFirst()`, `getLast()`: Methods to access first and last elements.  
- `remove()`, `removeFirst()`, `removeLast()`: Remove elements from the list.  
- `iterator()`: Used to traverse elements efficiently.  
- `contains()`: Checks if a specific element exists in the list.  
- `size()`: Returns the number of elements in the list.  
  
### Sample Output:  
```
LinkedList: [Strawberry, Apple, Banana, Cherry, Mango]
First Element: Strawberry
Last Element: Mango
LinkedList after removals: [Apple, Cherry]
Iterating over LinkedList:
Apple
Cherry
Cherry is in the list
Size of LinkedList: 2
```
This example covers creation, insertion, removal, traversal, and querying operations on a Java `LinkedList`, making it a comprehensive reference for beginners.

# HashSet Example
The `HashSet` class in Java implements the `Set` interface, which means it **does not allow duplicate elements** and does **not maintain any particular order**. It is widely used when you want to store unique elements efficiently.
Below is a complete example demonstrating the most common operations with `HashSet`: adding elements, checking existence, removing elements, and iteration.

```java
// Java
import java.util.HashSet;
import java.util.Iterator;
public class HashSetExample {
    public static void main(String[] args) {
        // Create a HashSet of Strings
        HashSet<String> fruits = new HashSet<>();
        // Adding elements to the HashSet
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Mango");
        fruits.add("Banana"); // Duplicate element, will not be added
        // Display the HashSet
        System.out.println("HashSet contents: " + fruits);
        // Check if an element exists
        if (fruits.contains("Apple")) {
        System.out.println("Apple is present in the HashSet.");
        } else {
        System.out.println("Apple is not present.");
        }
        // Removing an element
        fruits.remove("Mango");
        System.out.println("After removing Mango: " + fruits);
        // Iterate using Iterator
        System.out.println("Iterating over HashSet:");
        Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()) {
        System.out.println(iterator.next());
        }
        // Get the size of the HashSet
        System.out.println("Size of HashSet: " + fruits.size());
        // Clear all elements
        fruits.clear();
        System.out.println("HashSet after clear(): " + fruits);
    }
}
```
### Key Points:  
  
1. **No Duplicates**: `HashSet` automatically ignores duplicate elements.  
2. **No Order Guarantee**: Elements are not stored in insertion order.  
3. **Efficient Operations**: Lookups, additions, and removals are generally `O(1)`.  
4. **Iterator Support**: You can iterate through elements using an `Iterator` or enhanced `for` loop.  
  
### Usage Example:  
  
When running the above code, expected output may look like:
```
HashSet contents: [Apple, Banana, Orange, Mango]
Apple is present in the HashSet.
After removing Mango: [Apple, Banana, Orange]
Iterating over HashSet:
Apple
Banana
Orange
Size of HashSet: 3
HashSet after clear(): []
```
This example covers most common operations and shows how `HashSet` enforces uniqueness while providing fast access.

# TreeSet Example
`TreeSet` is a part of Java's **Collection Framework** and implements the `Set` interface. It **stores elements in a sorted order** and **does not allow duplicate elements**. `TreeSet` internally uses a **Red-Black tree** to maintain order.
## Java TreeSet Example  
  
```java
// Java
import java.util.TreeSet;
public class TreeSetExample {
    public static void main(String[] args) {
        // Create a TreeSet of integers
        TreeSet<Integer> numbers = new TreeSet<>();
        // Adding elements
        numbers.add(50);
        numbers.add(20);
        numbers.add(70);
        numbers.add(10);
        numbers.add(30);
        // Attempting to add a duplicate element
        numbers.add(20); // This will be ignored
        // Display TreeSet (automatically sorted in ascending order)
        System.out.println("TreeSet elements: " + numbers);
        // Remove an element
        numbers.remove(10);
        System.out.println("After removing 10: " + numbers);
        // Access first and last elements
        System.out.println("First element: " + numbers.first());
        System.out.println("Last element: " + numbers.last());
        // Iterate using for-each loop
        System.out.println("Iterating elements:");
        for (Integer num : numbers) {
        System.out.println(num);
        }
        // Get subset of elements less than 50
        System.out.println("Subset less than 50: " + numbers.headSet(50));
        // Get subset of elements greater than or equal to 30
        System.out.println("Subset from 30 onwards: " + numbers.tailSet(30));
    }
}
```
## Key Points:  
- `TreeSet` **does not allow duplicates**.  
- Elements are **sorted in natural order** (ascending by default). Custom sorting can be used with a `Comparator`.  
- Commonly used methods include:  
  - `add(E e)`, `remove(Object o)`, `first()`, `last()`, `headSet(E toElement)`, `tailSet(E fromElement)`.  
- Iteration is naturally in **ascending sorted order**.  
  
## Sample Output
```
TreeSet elements: [10, 20, 30, 50, 70]
After removing 10: [20, 30, 50, 70]
First element: 20
Last element: 70
Iterating elements:
20
30
50
70
Subset less than 50: [20, 30]
Subset from 30 onwards: [30, 50, 70]
```
This example demonstrates **basic operations**, **iteration**, and **subset retrieval** using `TreeSet`. It’s ideal when you need a **sorted set without duplicates**.

# HashMap Example
A `HashMap` in Java is a part of the `java.util` package and is used to store key-value pairs. It allows `null` values and `null` keys (only one), and does not maintain any order of elements. Below is a comprehensive example showing basic operations such as adding, accessing, removing elements, and iterating over a `HashMap`.
```java
// Java
import java.util.HashMap;
import java.util.Map;
public class HashMapExample {
    public static void main(String[] args) {
        // Creating a HashMap
        HashMap<Integer, String> studentMap = new HashMap<>();
        // Adding entries to the HashMap
        studentMap.put(101, "Alice");
        studentMap.put(102, "Bob");
        studentMap.put(103, "Charlie");
        studentMap.put(104, "David");
        // Accessing a value by key
        System.out.println("Student with ID 102: " + studentMap.get(102));
        // Checking if a key exists
        if(studentMap.containsKey(105)) {
        System.out.println("Student with ID 105 exists.");
        } else {
        System.out.println("Student with ID 105 does not exist.");
        }
        // Removing an entry by key
        studentMap.remove(104);
        System.out.println("After removing key 104: " + studentMap);
        // Iterating over the HashMap using entrySet()
        System.out.println("Iterating over HashMap:");
        for(Map.Entry<Integer, String> entry : studentMap.entrySet()) {
        System.out.println("ID: " + entry.getKey() + ", Name: " + entry.getValue());
        }
        // Size of the HashMap
        System.out.println("Total students: " + studentMap.size());
        // Clearing all entries
        studentMap.clear();
        System.out.println("After clearing, HashMap: " + studentMap);
    }
}
```
### Key Points:  
- `put(key, value)` adds entries to the map.  
- `get(key)` retrieves the value associated with a key.  
- `containsKey(key)` checks if a key exists in the map.  
- `remove(key)` deletes a key-value pair.  
- Iterating can be done via `entrySet()` or `keySet()` methods.  
- `HashMap` does not guarantee insertion order; for ordered maps, use `LinkedHashMap`.  
  
### Sample Output:  
```
Student with ID 102: Bob
Student with ID 105 does not exist.
After removing key 104: {101=Alice, 102=Bob, 103=Charlie}
Iterating over HashMap:
ID: 101, Name: Alice
ID: 102, Name: Bob
ID: 103, Name: Charlie
Total students: 3
After clearing, HashMap: {}
```
This example demonstrates all the core operations of a `HashMap` and provides a fully functional, executable Java program.

# TreeMap Example
`TreeMap` in Java is a part of the `java.util` package. It implements the `NavigableMap` interface and stores key-value pairs in a **sorted order** based on the keys. It uses a **Red-Black tree** internally for sorting and searching efficiently.
Here is a complete Java example demonstrating the usage of `TreeMap`:

```java
// Java
import java.util.Map;
import java.util.TreeMap;
public class TreeMapExample {
    public static void main(String[] args) {
        // Creating a TreeMap with Integer keys and String values
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        // Adding key-value pairs
        treeMap.put(3, "Three");
        treeMap.put(1, "One");
        treeMap.put(4, "Four");
        treeMap.put(2, "Two");
        // Displaying the TreeMap (Keys will be sorted automatically)
        System.out.println("TreeMap (Sorted by keys): " + treeMap);
        // Iterating over entries
        System.out.println("
        Iterating over TreeMap:");
        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
        System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        // Accessing first and last keys
        System.out.println("
        First Key: " + treeMap.firstKey());
        System.out.println("Last Key: " + treeMap.lastKey());
        // Removing an entry by key
        treeMap.remove(2);
        System.out.println("
        After removing key 2: " + treeMap);
        // Checking if a key or value exists
        System.out.println("Contains key 3? " + treeMap.containsKey(3));
        System.out.println("Contains value 'Two'? " + treeMap.containsValue("Two"));
        // Getting a subMap (from key 1 to key 3, exclusive of 3)
        System.out.println("SubMap (1 to 3): " + treeMap.subMap(1, 3));
    }
}
```
### Key Points:  
  
- `TreeMap` automatically sorts entries by keys in **natural order** or using a **custom comparator**.  
- Null keys are **not allowed**, but null **values** are allowed.  
- Common methods include `put()`, `get()`, `remove()`, `firstKey()`, `lastKey()`, `subMap()`, and `containsKey()`/`containsValue()`.  
- Iteration over a `TreeMap` is faster than a `HashMap` if you need sorted order, but slower for just lookups.  
  
### Output Example:  
  
```
TreeMap (Sorted by keys): {1=One, 2=Two, 3=Three, 4=Four}
Iterating over TreeMap:
Key: 1, Value: One
Key: 2, Value: Two
Key: 3, Value: Three
Key: 4, Value: Four
First Key: 1
Last Key: 4
After removing key 2: {1=One, 3=Three, 4=Four}
Contains key 3? true
Contains value 'Two'? false
SubMap (1 to 3): {1=One}
```
This example covers **creation, insertion, iteration, removal, searching, and subMap operations**, providing a comprehensive demonstration of how to use `TreeMap` in Java efficiently.

# Comparable
* Natural ordering
* Implemented inside class
* Method:

  ```java
  int compareTo(T o);
  ```
* Only one sorting logic possible

```java
import java.util.*;

class Student implements Comparable<Student> {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Defining natural order by age
    @Override
    public int compareTo(Student other) {
        return this.age - other.age; // ascending order
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 23));
        students.add(new Student("Bob", 20));
        students.add(new Student("Charlie", 22));

        Collections.sort(students); // Uses compareTo automatically
        System.out.println(students);
    }
}
```

# Comparator
* External sorting logic
* Separate class or lambda
* Method:

  ```java
  int compare(T o1, T o2);
  ```
* Multiple sorting logics possible

```java
import java.util.*;

class StudentByName implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.name.compareTo(s2.name); // ascending order by name
    }
}

public class MainComparator {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 23));
        students.add(new Student("Bob", 20));
        students.add(new Student("Charlie", 22));

        // Custom sort by name
        Collections.sort(students, new StudentByName());
        System.out.println(students);
    }
}
```

# Iterate Map
In Java, a `Map` is a data structure that stores key-value pairs. Common implementations include `HashMap`, `TreeMap`, and `LinkedHashMap`. Iterating over a `Map` means accessing each key-value pair, often for processing or printing data.
There are multiple ways to iterate through a `Map` in Java, each suitable for different use cases.
## 1. Using `entrySet()`  
  
`entrySet()` returns a set of `Map.Entry<K, V>` objects, which contain both the key and value. This is one of the most common and efficient ways to iterate.
```java
// Java
import java.util.HashMap;
import java.util.Map;
public class IterateMapExample {
public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 22);
        // Iterating using entrySet
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
```
## 2. Using `keySet()`  
  
`keySet()` allows iteration over keys, and values can be retrieved by `map.get(key)`. Less efficient if used heavily on large maps because it repeatedly looks up values.
```java
import java.util.HashMap;
import java.util.Map;
public class KeySetIteration {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 25);
        map.put("Bob", 30);
        for (String key : map.keySet()) {
            Integer value = map.get(key);
            System.out.println("Key: " + key + ", Value: " + value);
        }
    }
}
```
## 3. Using `values()`  
  
If only values are needed, not keys, you can iterate directly through `map.values()`.
```java
import java.util.HashMap;
import java.util.Map;
public class ValuesIteration {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 25);
        map.put("Bob", 30);
        for (Integer value : map.values()) {
            System.out.println("Value: " + value);
        }
    }
}
```
## 4. Using Java 8 `forEach()` and Lambda Expressions  
  
Java 8 made map iteration more concise with the `forEach` method.
```java
import java.util.HashMap;
import java.util.Map;
public class LambdaIteration {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));
    }
}
```
## Summary  
  
- **`entrySet()`**: Efficient, gives both key and value directly.  
- **`keySet()`**: Useful when you need keys and occasional values; less efficient for large maps.  
- **`values()`**: Only iterate values.  
- **`forEach()`**: Concise, preferred in Java 8+ for modern code.  
  
Using these methods, you can effectively iterate and manipulate maps in Java depending on whether you need keys, values, or both. This versatility is crucial in real-world applications such as counting occurrences, caching, or organizing data.

# What is load factor?
In hash-based collections like `HashMap`, **load factor** defines how full the hash table can get before it is resized.

- Default load factor in `HashMap` is **0.75**.
- Threshold = `capacity * loadFactor`.
- Higher load factor saves memory but may increase collisions.

# What is capacity?
**Capacity** is the number of buckets available in a hash table internally.

- Initial capacity of `HashMap` is typically **16**.
- When size crosses threshold, capacity is usually doubled.
- Capacity affects performance because it influences collision rate.

# ConcurrentHashMap
`ConcurrentHashMap` is a thread-safe map designed for high concurrency.

- Allows concurrent reads and many concurrent updates.
- Faster than synchronizing a normal `HashMap` in multithreaded code.
- Does not allow `null` keys or values.
- Common in caching, shared registries, counters.

# Stack Example
`Stack` follows **LIFO (Last In, First Out)**.

```java
import java.util.Stack;

Stack<Integer> stack = new Stack<>();
stack.push(10);
stack.push(20);
System.out.println(stack.pop()); // 20
```

# Queue Example
`Queue` follows **FIFO (First In, First Out)**.

```java
import java.util.LinkedList;
import java.util.Queue;

Queue<String> q = new LinkedList<>();
q.offer("A");
q.offer("B");
System.out.println(q.poll()); // A
```

# PriorityQueue
`PriorityQueue` orders elements by natural order (or comparator), not insertion order.

- Head is the smallest element by default (min-heap behavior).
- `offer()` inserts, `poll()` removes highest-priority element.
- Useful in scheduling, top-k, shortest path algorithms.

# Immutable Collection
An immutable collection cannot be modified after creation.

```java
import java.util.List;
List<String> list = List.of("A", "B"); // Java 9+
// list.add("C"); // UnsupportedOperationException
```

Benefits: thread safety, predictable behavior, defensive programming.

# Create Thread
Two common ways:

1. Extend `Thread` and override `run()`.
2. Implement `Runnable` (preferred for separation of task and thread).

# Runnable
`Runnable` is a functional interface with a single `run()` method.

```java
Runnable task = () -> System.out.println("Task running");
new Thread(task).start();
```

# Lambda Thread
Since `Runnable` is functional, lambda syntax is concise:

```java
new Thread(() -> System.out.println("Running in lambda thread")).start();
```

# synchronized method
A synchronized instance method locks on the current object (`this`).

```java
synchronized void increment() { count++; }
```

Only one thread can execute synchronized code on that same object at a time.

# synchronized block
Locks only a specific critical section, improving concurrency.

```java
synchronized (lockObject) {
    // critical section
}
```

More flexible than synchronizing the whole method.

# volatile
`volatile` ensures visibility of variable updates across threads.

- Writes by one thread become visible to others immediately.
- Does **not** provide atomicity for compound operations like `count++`.

# Callable
`Callable<V>` is like `Runnable` but:

- Returns a value.
- Can throw checked exceptions.

Used with `ExecutorService`.

# Future
`Future` represents result of an asynchronous computation.

- `get()` waits for result.
- `isDone()` checks completion.
- `cancel()` attempts cancellation.

# ExecutorService
`ExecutorService` manages thread pools and task execution.

```java
ExecutorService ex = java.util.concurrent.Executors.newFixedThreadPool(4);
ex.submit(() -> System.out.println("Task"));
ex.shutdown();
```

Prefer it over manual thread creation for scalability.

# Deadlock Example
Deadlock happens when two threads wait forever for each other’s locks.

Example pattern:
- Thread 1 locks A then waits for B.
- Thread 2 locks B then waits for A.

Prevention: consistent lock order, timeout locks, reduce nested locking.

# wait()
`wait()` releases monitor lock and puts the thread in waiting state until notified.

- Must be called inside synchronized context.
- Belongs to `Object` class.

# notify()
`notify()` wakes one waiting thread on the same monitor.

- Called inside synchronized block/method.
- `notifyAll()` wakes all waiting threads.

# join()
`join()` makes current thread wait for another thread to finish.

```java
t1.start();
t1.join(); // wait for t1
```

# sleep()
`Thread.sleep(ms)` pauses current thread for a specified time.

- Does not release locks.
- Throws `InterruptedException`.

# Thread lifecycle
Typical states:

- **NEW**: thread created
- **RUNNABLE**: ready/running
- **BLOCKED/WAITING/TIMED_WAITING**: waiting for lock/signal/time
- **TERMINATED**: finished execution

# ThreadPool
A thread pool reuses a fixed/dynamic set of threads to execute tasks.

Benefits: lower thread-creation overhead, better resource control, improved throughput.

# AtomicInteger
`AtomicInteger` provides lock-free thread-safe integer operations.

```java
AtomicInteger c = new AtomicInteger(0);
c.incrementAndGet();
```

Useful for counters in concurrent code.

# ReentrantLock
`ReentrantLock` is an explicit lock with advanced features over `synchronized`:

- `tryLock()`
- fair lock option
- interruptible locking
- multiple `Condition`s

# ForkJoinPool
`ForkJoinPool` supports divide-and-conquer parallelism.

- Large task is split (forked) into subtasks.
- Results are merged (joined).
- Used by parallel streams internally.

# Producer-Consumer
Classic concurrency pattern:

- Producer generates data.
- Consumer processes data.
- Shared bounded buffer coordinates both.

Java implementations: `BlockingQueue`, `wait/notify`, or reactive pipelines.

# Functional Interface
A functional interface has exactly one abstract method.

Examples: `Runnable`, `Callable`, `Predicate`, `Function`.
Can include default/static methods.

# Lambda
Lambda is a concise way to represent anonymous functions.

```java
(a, b) -> a + b
```

Common with streams and functional interfaces.

# Stream Example
```java
List<Integer> nums = List.of(1,2,3,4);
nums.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
```

Streams process collections declaratively.

# map()
`map()` transforms each element into another value.

```java
names.stream().map(String::toUpperCase)
```

# filter()
`filter()` keeps only elements matching a condition.

```java
nums.stream().filter(n -> n > 10)
```

# reduce()
`reduce()` combines stream elements into a single result.

```java
int sum = nums.stream().reduce(0, Integer::sum);
```

# Optional
`Optional<T>` represents presence/absence of a value to avoid null checks.

Common methods: `of`, `ofNullable`, `isPresent`, `orElse`, `map`.

# Method Reference
Method reference is shorthand for lambda calling an existing method.

Examples:
- `System.out::println`
- `String::length`
- `Integer::parseInt`

# Parallel Stream
`parallelStream()` enables parallel processing using ForkJoinPool.

Use when data is large and operations are stateless and CPU-intensive.
Avoid for small data or operations with shared mutable state.

# Collectors
`Collectors` provides terminal utilities for streams.

Examples:
- `toList()`
- `toSet()`
- `groupingBy()`
- `joining()`
- `counting()`

# Default methods
Default methods in interfaces (Java 8+) provide method bodies.

Purpose: evolve interfaces without breaking existing implementations.

# Date API
Java 8 Date-Time API (`java.time`) is immutable and thread-safe.

Core classes:
- `LocalDate`
- `LocalTime`
- `LocalDateTime`
- `ZonedDateTime`
- `Instant`

# Predicate
`Predicate<T>`: takes input, returns boolean (`test`).

```java
Predicate<Integer> isEven = n -> n % 2 == 0;
```

# Function
`Function<T, R>`: converts type T to R (`apply`).

```java
Function<String, Integer> len = String::length;
```

# Consumer
`Consumer<T>`: takes input and returns nothing (`accept`).

```java
Consumer<String> print = System.out::println;
```

# Supplier
`Supplier<T>`: provides a value with no input (`get`).

```java
Supplier<Double> rand = Math::random;
```

# BiFunction
`BiFunction<T, U, R>` takes two inputs and returns one output.

```java
BiFunction<Integer, Integer, Integer> add = Integer::sum;
```

# forEach
`forEach` performs an action for each element.

```java
list.forEach(System.out::println);
```

# flatMap
`flatMap` maps each element to a stream and flattens nested streams.

Useful for nested lists.

```java
listOfLists.stream().flatMap(List::stream)
```

# Stream vs Collection
- **Collection** stores data in memory.
- **Stream** processes data pipeline-style.

Streams are single-use and lazy; collections are reusable and eager.

# Singleton
Singleton ensures only one instance of a class exists.

Common approach:
- private constructor
- static instance
- public getter

Thread-safe best practice: enum singleton.

# Serialization
Serialization converts object state into byte stream for storage/transfer.

- Class implements `Serializable`.
- Deserialization reconstructs object.

# serialVersionUID
`serialVersionUID` is a version identifier for serialized classes.

Helps verify sender/receiver class compatibility during deserialization.

# Reflection
Reflection inspects/classes/methods/fields at runtime and can invoke/access them dynamically.

Used in frameworks, dependency injection, testing tools.

# Annotations
Annotations add metadata to code.

Examples: `@Override`, `@Deprecated`, `@SuppressWarnings`.
Custom annotations can be processed at compile/runtime.

# Generics
Generics enable type-safe reusable code.

```java
List<String> names = new ArrayList<>();
```

Benefits: compile-time type checking, no explicit casts.

# Wildcards
Wildcards in generics:

- `?` unknown type
- `? extends T` upper bound (read mostly)
- `? super T` lower bound (write mostly)

# Type Erasure
Java implements generics via type erasure.

Generic type info is removed at runtime, replaced by bounds/Object.
Therefore `List<String>` and `List<Integer>` share same runtime class.

# Shallow Copy
Shallow copy duplicates object but not nested referenced objects.

Changes in shared referenced objects affect both copies.

# Deep Copy
Deep copy duplicates object and all nested referenced objects recursively.

Changes in one copy do not affect the other.

# Memory Leak Cause
In Java, leaks occur when objects are no longer needed but still referenced.

Common causes:
- static collections growing forever
- unclosed resources/listeners
- caches without eviction
- accidental object retention

# GC Types
Common garbage collectors (varies by JDK version):

- Serial GC
- Parallel GC
- G1 GC (default in modern Java)
- ZGC
- Shenandoah

Each balances throughput, pause time, and memory footprint differently.

# Heap vs Stack
- **Stack**: method frames, local variables, thread-specific, fast.
- **Heap**: objects/arrays, shared across threads, managed by GC.

# JIT
JIT (Just-In-Time) compiler compiles frequently used bytecode to native machine code at runtime for faster execution.

Part of JVM performance optimization.

# Abstract Class
Abstract class can have abstract and concrete methods.

- Cannot be instantiated.
- Supports state (instance variables), constructors, and method implementations.
- Used when classes share common base behavior.

# Interface
Interface defines a contract that classes implement.

- Supports abstract methods, default/static methods, constants.
- Enables multiple inheritance of type.

# HashCode contract
If two objects are equal according to `equals()`, they **must** return same `hashCode()`.

Unequal objects may still share hash code (collision allowed).
Violating this breaks hash-based collections behavior.

# equals() override
When overriding `equals()`, also override `hashCode()`.

General rules for `equals()`:
- reflexive
- symmetric
- transitive
- consistent
- `x.equals(null)` is false

# Comparator chaining
Comparator chaining combines multiple sort criteria.

```java
people.sort(
    Comparator.comparing(Person::getLastName)
              .thenComparing(Person::getFirstName)
              .thenComparingInt(Person::getAge)
);
```

# Java 17 features
Important Java 17 (LTS) highlights:

- Sealed classes (finalized)
- Pattern matching for `instanceof`
- Records (from Java 16, widely used with 17)
- New macOS rendering pipeline
- Strong encapsulation of JDK internals
- Improved GCs and performance updates
