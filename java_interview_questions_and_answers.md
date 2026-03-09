# Java Theory Interview Questions & Answers

- [What is JDK?](#what-is-jdk)
- [What is JRE?](#what-is-jre)
- [What is JVM?](#what-is-jvm)
- [What are OOP principles?](#what-are-oop-principles)
- [Example of Encapsulation](#example-of-encapsulation)
- [Example of Inheritance](#example-of-inheritance)
- [What is the Diamond Problem?](#what-is-the-diamond-problem)
- [Example of Polymorphism](#example-of-polymorphism)
- [Example of Abstraction](#example-of-abstraction)
- [Autoboxing & Unboxing](#autoboxing--unboxing)
- [Wrapper classes](#wrapper-classes)
- [Can we override private or static methods?](#can-we-override-private-or-static-methods)
- [What is final?](#what-is-final)
- [What is finally?](#what-is-finally)
- [What is finalize()?](#what-is-finalize)
- [What is try-with-resources](#what-is-try-with-resources)
- [What is String Pool?](#what-is-string-pool)
- [What is StringBuffer and StringBuilder](#what-is-stringbuffer-and-stringbuilder)
- [Why is String immutable?](#why-is-string-immutable)
- [Difference between == and .equals()](#difference-between--and-equals)
- [.equals and hashCode() contract](#equals-and-hashcode-contract)
- [Reverse a String without using inbuilt methods](#reverse-a-string-without-using-inbuilt-methods)
- [Checked Exception](#checked-exception)
- [Unchecked Exception](#unchecked-exception)
- [Difference between throw and throws](#difference-between-throw-and-throws-in-java)
- [What happens if exception is not caught?](#what-happens-if-an-exception-is-not-caught)
- [Custom exception example](#custom-exception-example)
- [What is static?](#what-is-static)
- [What is this keyword?](#what-is-this-keyword)
- [List vs Set](#list-vs-set)
- [ArrayList Example](#arraylist-example)
- [LinkedList Example](#linkedlist-example)
- [How does HashMap work internally?](#how-does-hashmap-work-internally)
- [What is hashing?](#what-is-hashing)
- [What is a hash collision?](#what-is-a-hash-collision)
- [HashSet Example](#hashset-example)
- [TreeSet Example](#treeset-example)
- [HashMap Example](#hashmap-example)
- [TreeMap Example](#treemap-example)
- [Comparable](#comparable)
- [Comparator](#comparator)
- [Iterate Map](#iterate-map)
- [What is a Thread?](#what-is-a-thread)
- [Difference between Thread and Runnable](#difference-between-thread-and-runnable)
- [What is synchronization?](#what-is-synchronization)
- [What is race condition?](#what-is-race-condition)
- [What is thread safety?](#what-is-thread-safety)
- [What is a Singleton pattern?](#what-is-a-singleton-pattern)
- [What is Deadlock?](#what-is-deadlock)

---

# What is JDK?

Java Development Kit (JDK) = JRE + Development Tools Includes: - javac
(compiler) - javadoc - debugger - jar tool

---

# What is JRE?

Java Runtime Environment (JRE) contains: - JVM - Core libraries -
Supporting files required to run Java programs

---

# What is JVM?

The Java Virtual Machine (JVM) executes Java bytecode. It provides
platform independence by converting bytecode into machine-specific
instructions.

Flow: Source Code (.java) → Compiler (javac) → Bytecode (.class) → JVM →
Machine Code

It cannot compile Java code.

---

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

---

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

---

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

---

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

---

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

---

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

---

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

---

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

---

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

---

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

---

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

---

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

---

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

---

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

---

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

---

# Why is String Immutable?

In Java, a **String is immutable**, which means **once a String object is created, its value cannot be changed**. Any operation that appears to modify a string actually creates a **new String object** instead of changing the existing one.

### Example

```java
String str = "Hello";
str.concat(" World");

System.out.println(str);
```

Output:

```
Hello
```

The original string did not change because `concat()` creates a **new String object**. To modify the value, you must assign it:

```java
String str = "Hello";
str = str.concat(" World");

System.out.println(str);
```

Output:

```
Hello World
```

## Reasons Why String is Immutable

### 1. Security

Strings are used in sensitive areas like:

* File paths
* Network connections
* Database URLs
* Class loading

If strings were mutable, their values could be changed after security checks, which could lead to security vulnerabilities.

### 2. String Pool Optimization

Java stores string literals in a **String Pool** to save memory.

Example:

```java
String a = "hello";
String b = "hello";
```

Both `a` and `b` point to the **same object** in the string pool.

If strings were mutable, changing one reference would affect others, which could cause unexpected behavior.

### 3. HashMap Key Stability

Strings are commonly used as keys in collections like `HashMap`.

Example:

```java
HashMap<String, Integer> map = new HashMap<>();
map.put("apple", 1);
```

If strings were mutable, their **hash code could change**, making it impossible for the HashMap to locate the correct bucket.

Immutability ensures the hash code remains constant.

### 4. Thread Safety

Since strings cannot be modified, they are **automatically thread-safe**. Multiple threads can safely share the same string object without synchronization.

## Summary

String is immutable in Java to provide:

* Better **security**
* Efficient **memory usage through the String Pool**
* Reliable **hashing for collections**
* **Thread safety**

If mutable strings are needed, Java provides alternatives like **StringBuilder** and **StringBuffer**.

---

# Difference between == and .equals()

In Java, both `==` and `.equals()` are used to compare values, but they behave differently depending on whether you are comparing **primitive types** or **objects**.

The key difference is:

* `==` compares **memory addresses (references)** for objects.
* `.equals()` compares the **actual content or value** of objects (if the class overrides it).

## Using `==` Operator

The `==` operator checks whether two references **point to the same object in memory**.

### Example

```java
String a = new String("hello");
String b = new String("hello");

System.out.println(a == b);
```

Output:

```
false
```

Even though both strings contain `"hello"`, they are **two different objects in memory**, so `==` returns `false`.

## Using `.equals()` Method

The `.equals()` method compares the **content of the objects** rather than their memory addresses.

### Example

```java
String a = new String("hello");
String b = new String("hello");

System.out.println(a.equals(b));
```

Output:

```
true
```

This returns `true` because the **values inside the strings are the same**.

---

## Example with String Pool

```java
String a = "hello";
String b = "hello";

System.out.println(a == b);
```

Output:

```
true
```

Here, both variables refer to the **same string in the String Pool**, so `==` returns `true`.

## Key Differences

| Feature               | `==`                 | `.equals()`                  |
| --------------------- | -------------------- | ---------------------------- |
| Comparison type       | Reference comparison | Value/content comparison     |
| Works with primitives | Yes                  | No                           |
| Works with objects    | Yes (reference only) | Yes (content if implemented) |
| Can be overridden     | No                   | Yes                          |

## Important Note

The `.equals()` method is defined in the `Object` class. Many Java classes such as `String`, `Integer`, and `List` **override it to compare values instead of references**.

## Summary

* Use `==` when you want to check **if two references point to the same object**.
* Use `.equals()` when you want to check **if two objects contain the same value**.

---

# `.equals()` and `hashCode()` contract

In Java, `equals()` and `hashCode()` are methods defined in the `Object` class. They are commonly overridden when creating custom classes, especially when objects are used in **hash-based collections** like `HashMap`, `HashSet`, or `Hashtable`.

The **contract** between these two methods ensures that objects behave correctly when stored in these collections.

## The Contract Rules

### Rule 1

If two objects are **equal according to `equals()`**, they **must return the same `hashCode()`**.

```java
a.equals(b) == true
```

then

```java
a.hashCode() == b.hashCode()
```

If this rule is violated, collections like `HashMap` may fail to find objects correctly.

### Rule 2

If two objects have the **same hashCode**, they are **not necessarily equal**.

```java
a.hashCode() == b.hashCode()
```

does **not guarantee**

```java
a.equals(b) == true
```

This situation is called a **hash collision**.

## Why This Contract Exists

Hash-based collections use **hashCode first** to determine where to store objects.

Example with `HashMap`:

1. `hashCode()` determines the **bucket location**
2. `equals()` checks if the key already exists in that bucket

If `equals()` returns true but the `hashCode()` values are different, the map will look in the **wrong bucket**, and the object may not be found.

## Example Without Overriding `hashCode()`

```java
class Student {
    int id;

    Student(int id) {
        this.id = id;
    }

    public boolean equals(Object obj) {
        Student s = (Student) obj;
        return this.id == s.id;
    }
}
```

If we use this class in a `HashSet`, problems may occur because `hashCode()` was not overridden.

## Correct Implementation

Whenever you override `equals()`, you should also override `hashCode()`.

```java
class Student {
    int id;

    Student(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;

        Student s = (Student) obj;
        return this.id == s.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
```

Now objects with the same `id` will produce the **same hashCode**.

## Example with HashSet

```java
Set<Student> set = new HashSet<>();

set.add(new Student(1));
set.add(new Student(1));

System.out.println(set.size());
```

Output:

```
1
```

Because both objects are considered equal.

## Summary

The contract between `equals()` and `hashCode()` ensures correct behavior in hash-based collections.

Key rules:

* If `equals()` returns **true**, `hashCode()` must be the **same**.
* If `hashCode()` is the same, `equals()` **may or may not** be true.
* Always override **both methods together** when defining equality for objects.

---

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

---

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

---

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

---

# Difference Between `throw` and `throws` in Java

In Java exception handling, both `throw` and `throws` are related to exceptions, but they serve **different purposes**.

* `throw` is used to **explicitly throw an exception**.
* `throws` is used to **declare that a method may throw an exception**.

## `throw` Keyword

The `throw` keyword is used **inside a method** to manually throw an exception.

### Example

```java
public void checkAge(int age) {
    if (age < 18) {
        throw new IllegalArgumentException("Age must be 18 or above");
    }
}
```

Explanation:

* If the condition is met, the method **throws an exception immediately**.
* The remaining code will not execute.

---

## `throws` Keyword

The `throws` keyword is used in a **method declaration** to indicate that the method **might throw an exception**, and the caller must handle it.

### Example

```java
public void readFile() throws IOException {
    FileReader file = new FileReader("test.txt");
}
```

Explanation:

* This method declares that it **may throw `IOException`**.
* The method that calls `readFile()` must either:

  * handle the exception using `try-catch`, or
  * declare it using `throws`.

Example:

```java
try {
    readFile();
} catch (IOException e) {
    e.printStackTrace();
}
```

## Key Differences

| Feature              | `throw`                               | `throws`                                      |
| -------------------- | ------------------------------------- | --------------------------------------------- |
| Purpose              | Used to explicitly throw an exception | Used to declare exceptions a method may throw |
| Location             | Inside method body                    | In method signature                           |
| Number of exceptions | Throws one exception at a time        | Can declare multiple exceptions               |
| Usage                | `throw new Exception()`               | `method() throws Exception`                   |

## Example Using Both

```java
public void checkNumber(int num) throws Exception {
    if (num < 0) {
        throw new Exception("Number cannot be negative");
    }
}
```

Explanation:

* `throws Exception` → declares that the method may throw an exception.
* `throw new Exception` → actually throws the exception when the condition occurs.

## Summary

* `throw` is used to **create and throw an exception explicitly**.
* `throws` is used in a **method declaration to indicate possible exceptions** that must be handled by the caller.

---

# What Happens if an Exception is Not Caught?

If an exception occurs in a Java program and it is **not caught using a `try-catch` block**, the exception is passed to the **calling method**. This process is called **exception propagation**.

If no method in the call stack handles the exception, it eventually reaches the **JVM**, which then:

1. **Terminates the program**
2. **Prints the exception type**
3. **Displays the stack trace**

## Example

```java
public class Test {
    public static void main(String[] args) {
        int result = 10 / 0;
        System.out.println("Program continues");
    }
}
```

### Output

```
Exception in thread "main" java.lang.ArithmeticException: / by zero
	at Test.main(Test.java:4)
```

Explanation:

* The division by zero throws an `ArithmeticException`.
* Since there is **no try-catch block**, the exception is not handled.
* The JVM prints the **stack trace** and stops the program.

The line `"Program continues"` will **never execute**.

## Exception Propagation Example

```java
public class Test {

    static void method1() {
        method2();
    }

    static void method2() {
        int x = 10 / 0;
    }

    public static void main(String[] args) {
        method1();
    }
}
```

Execution flow:

```
main() → method1() → method2()
```

* `method2()` throws an exception
* `method1()` does not handle it
* `main()` does not handle it
* The exception reaches the **JVM**

The JVM then prints the stack trace and **terminates the program**.

## Summary

If an exception is not caught:

* It **propagates up the call stack**
* If no method handles it, the **JVM handles it**
* The JVM **prints the stack trace and stops the program**

---

## Custom Exception Example

In Java, a **custom exception** is a user-defined exception created by extending the `Exception` class or `RuntimeException`. Custom exceptions are used when built-in exceptions do not adequately describe a specific error condition in an application.

They help make code **more readable and meaningful**, especially when handling application-specific errors.

---

## Creating a Custom Exception

To create a custom exception, define a class that **extends `Exception`**.

### Example

```java
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
```

Explanation:

* `InvalidAgeException` is a custom exception.
* It extends the `Exception` class.
* The constructor passes a message to the parent `Exception` class.

---

# Using the Custom Exception

Now we can **throw the custom exception** in our code.

```java
public class Test {

    static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above");
        } else {
            System.out.println("Access granted");
        }
    }

    public static void main(String[] args) {
        try {
            checkAge(16);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }
}
```

### Output

```
Age must be 18 or above
```

---

## Checked vs Unchecked Custom Exceptions

Custom exceptions can be created in two ways.

### Checked Exception

Extend `Exception`.

```java
class MyException extends Exception {}
```

These **must be handled using try-catch or declared with `throws`**.

---

### Unchecked Exception

Extend `RuntimeException`.

```java
class MyException extends RuntimeException {}
```

These **do not require mandatory handling**.

---

## Summary

A custom exception:

* Is a **user-defined exception**
* Extends `Exception` or `RuntimeException`
* Is used to represent **application-specific errors**
* Improves **code clarity and error handling**

---

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

---

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

---

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

---

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

---

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

---

# How Does HashMap Work Internally?

`HashMap` is a data structure in Java that stores **key–value pairs** and allows **fast insertion, deletion, and lookup** operations. It is part of the **Java Collections Framework** and is implemented using **hashing**.

The average time complexity for `put()` and `get()` operations is **O(1)**.

## Basic Structure of HashMap

Internally, a `HashMap` uses an **array of buckets**. Each bucket stores entries in the form of a **Node (key, value, hash, next)**.

Each entry in the map looks conceptually like this:

```java
class Node<K,V> {
    final int hash;
    final K key;
    V value;
    Node<K,V> next;
}
```

This means a bucket can store **multiple entries using a linked list** if collisions occur.

## How `put()` Works

When you insert a key-value pair into a `HashMap`, the following steps occur:

### 1. Hash Code Calculation

The `hashCode()` method of the key is called.

```java
map.put("apple", 10);
```

Java calculates:

```
"apple".hashCode()
```

### 2. Determine Bucket Index

The hash value is converted into a bucket index using a formula similar to:

```
index = hash % array_length
```

This determines where in the internal array the entry should be stored.

### 3. Insert Entry

There are two possibilities:

### Case 1: Bucket is Empty

The entry is placed directly in that bucket.

```
Bucket[5] → (apple, 10)
```

### Case 2: Bucket Already Has Data (Collision)

If another key already maps to the same bucket, a **collision occurs**.

Example:

```
Bucket[5]
   ↓
(apple,10) → (banana,20)
```

The entries are stored using a **linked list**.

Java 8 introduced an improvement:

If the number of nodes in a bucket becomes large (≥ 8), the linked list is converted into a **Red-Black Tree** to improve performance.

## How `get()` Works

When retrieving a value:

```java
map.get("apple");
```

Java performs the following steps:

### 1. Compute Hash Code

```
"apple".hashCode()
```

### 2. Find Bucket Index

```
index = hash % array_length
```

### 3. Search Bucket

If multiple entries exist in the bucket, Java compares keys using:

```
equals()
```

Example:

```
Bucket[5]
   ↓
(apple,10) → (banana,20)
```

Java checks:

```
"apple".equals(existingKey)
```

Once a match is found, the value is returned.

## Handling Hash Collisions

A **hash collision** occurs when two different keys produce the same bucket index.

Example:

```java
map.put("apple", 10);
map.put("banana", 20);
```

Both keys might map to the same bucket.

To resolve this, `HashMap` uses:

* **Linked List (before Java 8)**
* **Linked List → Red-Black Tree (Java 8+)**

Tree conversion improves worst-case performance from:

```
O(n) → O(log n)
```

## Load Factor and Resizing

`HashMap` has two important parameters:

### Initial Capacity

Default: **16**

### Load Factor

Default: **0.75**

Resize happens when:

```
size > capacity × load_factor
```

Example:

```
16 × 0.75 = 12
```

When the 13th element is inserted, the `HashMap` **resizes (doubles its capacity)**.

During resizing:

* A new array is created
* Existing entries are **rehash**ed into the new buckets

## Important Characteristics of HashMap

* Stores **key-value pairs**
* **Keys must be unique**
* Allows **one null key**
* Allows **multiple null values**
* **Not thread-safe**

## Simple Example

```java
import java.util.HashMap;

public class Example {
    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();

        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Mango", 30);

        System.out.println(map.get("Apple"));
    }
}
```

Output:

```
10
```

## Summary

Internally, `HashMap` works using **hashing and buckets**:

1. `hashCode()` determines the hash value.
2. The hash determines the **bucket index**.
3. Entries are stored in that bucket.
4. Collisions are handled using **linked lists or trees**.
5. `equals()` is used to find the correct key in a bucket.

Because of this design, `HashMap` provides **very fast average performance for data retrieval and insertion**.

---

# What is Hashing?

## Definition

Hashing is a technique used to **convert data (keys) into a fixed-size numerical value called a hash code**. This hash code is then used to determine where the data should be stored in a data structure such as a **HashMap or HashSet**.

The main goal of hashing is to enable **fast data retrieval**, typically in **O(1) average time complexity**.

## How Hashing Works

Hashing works by using a **hash function**. A hash function takes a key as input and produces a numeric value called a **hash code**.

Example:

```java
String key = "apple";
int hash = key.hashCode();
```

The generated hash code is then used to determine the **index (bucket)** in the underlying array where the data will be stored.

Example formula used internally:

```
index = hashCode % arraySize
```

This index tells the data structure **where to store the key-value pair**.

## Example in HashMap

When you insert a value into a `HashMap`:

```java
HashMap<String, Integer> map = new HashMap<>();

map.put("apple", 10);
map.put("banana", 20);
```

Steps performed internally:

1. Java calls `hashCode()` on the key (`"apple"`).
2. The hash code is converted into an **array index**.
3. The key-value pair is stored in that **bucket**.

Later when retrieving:

```java
map.get("apple");
```

The same hashing process is used to find the correct bucket quickly.

## Hash Collision

Sometimes **different keys produce the same hash index**. This is called a **hash collision**.

Example:

```
Key1 → index 5
Key2 → index 5
```

When this happens, Java stores both entries in the same bucket using:

* **Linked List (before Java 8)**
* **Linked List → Red-Black Tree (Java 8 and later if many collisions occur)**

## Simple Conceptual Example

Imagine a locker system:

* Each locker number is determined by a **hash function**
* The key determines which locker the item goes into

```
Key → Hash Function → Locker Number
```

This allows quick access to the stored item.

## Key Points

* Hashing converts data into a **numeric hash value**
* Used for **fast storage and retrieval**
* Commonly used in **HashMap, HashSet, and HashTable**
* Collisions can occur and must be handled by the data structure
* Provides **O(1) average time complexity** for lookups

---

# What is a Hash Collision?

## Definition

A **hash collision** occurs when **two different keys produce the same hash value or map to the same bucket** in a hash-based data structure such as a `HashMap`.

Since a hash table has a **limited number of buckets**, it is possible for different keys to end up at the same index.

## Example

Suppose we insert two keys into a `HashMap`:

```java
HashMap<String, Integer> map = new HashMap<>();

map.put("apple", 10);
map.put("banana", 20);
```

The steps internally are:

1. Java calculates the **hashCode()** for `"apple"` and `"banana"`.
2. The hash codes are converted into a **bucket index**.
3. If both keys map to the same index, a **collision occurs**.

Example bucket layout:

```
Bucket[5]
   ↓
(apple,10)
(banana,20)
```

Both keys are stored in the **same bucket**.

## How Java Handles Hash Collisions

Java resolves collisions using **chaining**.

Before Java 8:

* Colliding elements were stored in a **Linked List**.

Example:

```
Bucket[5]
   ↓
(apple,10) → (banana,20) → (grape,30)
```

From Java 8 onward:

* If many elements collide (≥ 8 nodes), the linked list is converted into a **Red-Black Tree**.
* This improves worst-case lookup time.

Time complexity improvement:

```
Linked List: O(n)
Tree: O(log n)
```

## Why Collisions Happen

Collisions happen because:

* The number of possible keys is **much larger** than the number of buckets.
* Hash functions compress large data into **fixed-size hash values**.

Therefore collisions are **inevitable** in hashing systems.

## Key Points

* A hash collision occurs when **multiple keys map to the same bucket**.
* Common in **HashMap, HashSet, and other hash-based structures**.
* Java handles collisions using **linked lists and red-black trees**.
* Collisions can affect performance if not managed properly.

---

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

---

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

---

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

---

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

---

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

---

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

---

# What is a Thread?

## Definition

A **thread** is the smallest unit of execution within a process. It represents a **single flow of execution** in a program. Java allows multiple threads to run concurrently, which enables a program to perform multiple tasks at the same time.

A program that uses multiple threads is called a **multithreaded program**.

For example, in a browser:

* One thread loads the webpage
* Another thread downloads images
* Another thread handles user input

## Creating a Thread in Java

There are two common ways to create a thread in Java.

### Extending the Thread Class

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running");
    }
}

public class Test {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
}
```

`start()` creates a new thread and internally calls the `run()` method.

### Using Runnable Interface

```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread is running");
    }
}

public class Test {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start();
    }
}
```

## Key Points

* A thread represents an independent path of execution
* Multiple threads can run within the same program
* Threads help improve performance and responsiveness
* Java supports multithreading through `Thread` and `Runnable`

# Difference between Thread and Runnable

## Overview

In Java, threads can be created using either the **Thread class** or the **Runnable interface**. Both approaches achieve the same goal but differ in design and flexibility.

## Thread Class

When extending the `Thread` class, the class itself becomes a thread.

Example:

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running");
    }
}
```

Usage:

```java
MyThread t = new MyThread();
t.start();
```

### Limitation

Java does **not support multiple inheritance**, so if a class extends `Thread`, it cannot extend any other class.

## Runnable Interface

`Runnable` is an interface that defines a `run()` method.

Example:

```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread running");
    }
}
```

Usage:

```java
Thread t = new Thread(new MyRunnable());
t.start();
```

## Key Differences

| Feature     | Thread             | Runnable                                        |
| ----------- | ------------------ | ----------------------------------------------- |
| Type        | Class              | Interface                                       |
| Inheritance | Must extend Thread | Can implement Runnable and extend another class |
| Flexibility | Less flexible      | More flexible                                   |
| Recommended | Less commonly used | Preferred approach                              |

## Summary

Using `Runnable` is generally **preferred** because it allows better design flexibility and separation between the **task and the thread**.

# What is synchronization?

## Definition

**Synchronization** is a mechanism used in Java to control access to shared resources when multiple threads are running concurrently.

It ensures that **only one thread can access a critical section of code at a time**, preventing inconsistent data and thread interference.

## Why Synchronization is Needed

When multiple threads access the same resource at the same time, it can lead to incorrect results.

Example scenario:

Two threads trying to update the same bank account balance.

Without synchronization, both threads may read and modify the value at the same time, leading to incorrect results.

## Example of Synchronization

```java
class Counter {
    int count = 0;

    synchronized void increment() {
        count++;
    }
}
```

In this example, the `synchronized` keyword ensures that only **one thread can execute the `increment()` method at a time**.

## Synchronized Block Example

```java
synchronized(this) {
    count++;
}
```

This allows synchronization for only a **specific block of code** instead of the entire method.

## Key Points

* Synchronization prevents multiple threads from accessing shared data simultaneously
* It ensures **data consistency**
* Achieved using the `synchronized` keyword
* Used to protect **critical sections of code**

# What is race condition?

## Definition

A **race condition** occurs when **multiple threads access and modify shared data at the same time**, and the final result depends on the order in which the threads execute.

This can lead to **unexpected or incorrect results**.

## Example of Race Condition

```java
class Counter {
    int count = 0;

    void increment() {
        count++;
    }
}
```

If two threads execute `increment()` at the same time:

1. Thread A reads `count`
2. Thread B reads `count`
3. Both increment it
4. Both write the value back

Instead of increasing by 2, the value might increase by **only 1**.

## How to Prevent Race Conditions

Race conditions can be prevented using:

* `synchronized` methods
* `synchronized` blocks
* Locks
* Atomic variables

Example using synchronization:

```java
synchronized void increment() {
    count++;
}
```

## Key Points

* Race conditions occur when multiple threads modify shared data simultaneously
* The final result becomes unpredictable
* Synchronization is used to prevent race conditions

# What is thread safety?

## Definition

A program or method is **thread-safe** if it works correctly when accessed by **multiple threads at the same time** without causing data corruption or inconsistent results.

Thread safety ensures that shared data remains **consistent and reliable**.

## Example of Non-Thread-Safe Code

```java
class Counter {
    int count = 0;

    void increment() {
        count++;
    }
}
```

If multiple threads call `increment()` simultaneously, the value of `count` may become incorrect.

## Making Code Thread-Safe

One way to ensure thread safety is by using synchronization.

```java
class Counter {
    int count = 0;

    synchronized void increment() {
        count++;
    }
}
```

Now only one thread can execute the method at a time.

## Other Ways to Achieve Thread Safety

* Using **immutable objects**
* Using **synchronized blocks**
* Using **atomic classes**
* Using **concurrent collections**

## Key Points

* Thread safety ensures correct behavior in multithreaded environments
* Prevents data inconsistency
* Often implemented using synchronization or thread-safe data structures

# What is a Singleton pattern?

## Definition

The **Singleton pattern** is a design pattern that ensures **only one instance of a class is created during the lifetime of an application**.

It also provides a **global access point** to that instance.

Singletons are commonly used for:

* Configuration objects
* Logging
* Database connections
* Shared resources

## Basic Singleton Implementation

```java
class Singleton {

    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

Usage:

```java
Singleton obj = Singleton.getInstance();
```

## Key Characteristics

* The constructor is **private**, preventing object creation using `new`
* A **static instance variable** holds the single object
* A **public static method** provides access to that instance

## Thread-Safe Singleton Example

In multithreaded environments, the singleton must be thread-safe.

```java
class Singleton {

    private static Singleton instance;

    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

## Key Points

* Ensures only **one instance of a class exists**
* Provides **global access** to that instance
* Commonly used for **shared resources in applications**

---

# What is deadlock?

## Definition

A **deadlock** is a situation in multithreading where **two or more threads are permanently blocked**, each waiting for a resource that is held by another thread. Because each thread is waiting for the other to release a lock, **none of them can proceed**, and the program gets stuck.

In simple terms:
Threads are **waiting on each other forever**.

## Example Scenario

Imagine two threads and two resources.

* **Thread 1** locks **Resource A**
* **Thread 2** locks **Resource B**

Now:

* Thread 1 tries to lock **Resource B** (but Thread 2 already holds it)
* Thread 2 tries to lock **Resource A** (but Thread 1 already holds it)

Both threads are waiting for each other → **deadlock occurs**.

### Code Example

```java
class DeadlockExample {

    static final Object resource1 = new Object();
    static final Object resource2 = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread1 locked resource1");

                try { Thread.sleep(100); } catch (Exception e) {}

                synchronized (resource2) {
                    System.out.println("Thread1 locked resource2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread2 locked resource2");

                try { Thread.sleep(100); } catch (Exception e) {}

                synchronized (resource1) {
                    System.out.println("Thread2 locked resource1");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
```

### What Happens

* Thread1 locks **resource1**
* Thread2 locks **resource2**
* Thread1 waits for **resource2**
* Thread2 waits for **resource1**

Both threads wait forever → **Deadlock**

## Conditions Required for Deadlock

Four conditions usually cause deadlock:

### Mutual Exclusion

Only **one thread can use a resource at a time**.

### Hold and Wait

A thread **holds one resource while waiting for another**.

### No Preemption

A resource **cannot be forcibly taken away** from a thread.

### Circular Wait

A **cycle of threads** exists where each thread waits for a resource held by another.

Example:
Thread1 → Thread2 → Thread3 → Thread1

## How to Prevent Deadlock

### Lock Ordering

Always **acquire locks in the same order**.

Example:
Always lock `resource1` before `resource2`.

### Use TryLock

Using `ReentrantLock.tryLock()` avoids waiting forever.

### Avoid Nested Locks

Try to **minimize multiple synchronized blocks**.

## Simple Interview One-Line Answer

A **deadlock** occurs when two or more threads are permanently blocked because each thread is waiting for a resource held by another thread, causing the program to stop progressing.

---