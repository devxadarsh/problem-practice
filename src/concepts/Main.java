package concepts;

class MyClass {
    // Instance variable (belongs to object)
    int instanceVariable = 10;

    // Static variable (belongs to class)
    static int staticVariable = 20;

    // Instance method (can access both instance and static variables)
    void instanceMethod() {
        System.out.println("Instance method called.");
        System.out.println("Instance Variable: " + instanceVariable);  // OK
        System.out.println("Static Variable: " + staticVariable);      // OK
    }

    // Static method (cannot access instance variable directly)
    static void staticMethod() {
        System.out.println("Static method called.");

        // Uncommenting the next line would cause a compile-time error
        // System.out.println("Instance Variable: " + instanceVariable);  // ERROR!

        // But static methods can access static variables directly
        System.out.println("Static Variable: " + staticVariable);      // OK
    }
}

public class Main {
    public static void main(String[] args) {
        // Calling static method without creating an object
        MyClass.staticMethod();  // This works because staticMethod belongs to the class

        // Uncommenting the next line would cause a compile-time error
        // MyClass.instanceMethod();  // ERROR! Can't call instance method without an object

        // Now, let's create an object to call instance methods
        MyClass obj = new MyClass();
        obj.instanceMethod();  // This works because instanceMethod belongs to an object
    }
}


/*
Key Points to Remember:

    Static methods can:
        Access static variables.
        Call other static methods.
        Be called without creating an instance of the class.

    Static methods cannot:
        Access instance variables.
        Call instance methods directly, because instance methods may require instance variables that are tied to a specific object.

    Instance methods can:
        Access both instance variables and static variables.
        Call other instance methods and static methods.
 */
