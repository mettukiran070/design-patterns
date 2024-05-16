# Singleton
## Reference Documents
[Singleton Design Pattern Best Practices with Examples](https://www.digitalocean.com/community/tutorials/java-singleton-design-pattern-best-practices-examples)

## Singleton Pattern Principles
1. Singleton pattern restricts the instantiation of a class and ensures that only one instance of the class exists in the Java Virtual Machine.
2. The singleton class must provide a global access point to get the instance of the class.

## Singleton Pattern Implementation
1. Private constructor to restrict instantiation of the class from other classes.
2. Private static variable of the same class that is the only instance of the class.
3. Public static method that returns the instance of the class, this is the global access point for the outer world to get the instance of the singleton class.

## Eager Initialization

In eager initialization, the instance of the singleton class is created at the time of class loading. The drawback to eager initialization is that the Object is created even though the client application might not be using it. 

Here is the implementation of the static initialization singleton class:

[Eager Initialization Implementation](./def/EagerSingleton.java)

We should avoid the instantiation unless the client calls the getInstance method. Also, this method doesn't provide any options for exception handling.

## Static Block Initialization

Static block initialization implementation is similar to eager initialization, except that instance of the class is created in the static block that provides the option for exception handling.

[Static Block Initialization Implementation](./def/StaticBlockSingleton.java)

Both eager initialization and static block initialization create the instance even before it’s being used and that is not the best practice to use.

## Lazy Initialization

Lazy initialization method to implement the singleton pattern creates the instance in the global access method.

[Lazy Initialization Implement](./def/LazySingleton.java)

The preceding implementation works fine in the case of the single-threaded environment, but when it comes to multithreading systems, it can cause issues if multiple threads are inside the if condition at the same time. It will destroy the singleton pattern and both threads will get different instances of the singleton class. In the next section, we will see different ways to create a thread-safe singleton class.

## Thread Safe Singleton Initialization

A simple way to create a thread-safe singleton class is to make the global access method synchronized so that only one thread can execute this method at a time.

[Thread Safe Singleton Initialization](./def/MultiThreadSingleton.java)

The Synchronized method implementation works fine and provides thread-safety, but it reduces the performance because of the cost associated with the synchronized method, although we need it only for the first few threads that might create separate instances. 

```
public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;
    private ThreadSafeSingleton(){}
    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}
```

To avoid this extra overhead every time, double-checked locking principle is used. In this approach, the synchronized block is used inside the if condition with an additional check to ensure that only one instance of a singleton class is created. 


