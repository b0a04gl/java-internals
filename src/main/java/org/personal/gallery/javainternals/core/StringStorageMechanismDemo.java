package org.personal.gallery.javainternals.core;

public class StringStorageMechanismDemo {

    static void compareStringObjects(){
        String s1 = new String("done");
        String s2 = new String("done");

        compareByEquals(s1,s2);
        compareByOperator(s1,s2);
    }
    static void compareStringLiterals(){
        String s1 = "done";
        String s2 = "done";

        compareByEquals(s1,s2);
        compareByOperator(s1,s2);
    }
    ///You can verify this by comparing the memory addresses (references) of the objects using the System.identityHashCode(Object) method,
    // which returns the hash code associated with the object's memory address
    private static void compareByOperator(String s1, String s2) {
        //reference matching
        if(s1 == s2){
            System.out.println("[using == ] -> s1 and s2 are equal");
            System.out.println(System.identityHashCode(s1)+","+System.identityHashCode(s2));
        }
        else{
            System.out.println("[using == ] -> s1 and s2 are not equal");
            System.out.println(System.identityHashCode(s1)+","+System.identityHashCode(s2));

            /**The reason the hash codes of `s1` and `s2` are the same is because the `hashCode` method in Java's `String` class is
             *  implemented to produce the same hash code for strings with the same content. In this case, both `s1` and `s2` have the content "done,"
             *  so their hash codes are identical.

             However, when you use the `==` operator to compare references, it checks whether the two variables, `s1` and `s2`,
             are referencing the same object in memory. In your code, you explicitly created two separate `String` objects with the `new String("done")` constructor. Even though they have the same content, they are different objects in memory, and therefore the `==` comparison correctly returns `false`.

             So, the hash codes being the same is a result of the `hashCode` method's behavior for equal strings, but the `==` operator
             is comparing object references, which are distinct in this case.
             * */
        }
    }

    private static void compareByEquals(String s1, String s2) {
        //content matching
        if(s1.equals(s2)){
            System.out.println("[using .equals() ] -> s1 and s2 are equal");
        }
        else{
            System.out.println("[using .equals() ] -> s1 and s2 are not equal");
        }
    }

    public static void main(String[] args) {
        //string literal allocated in string constant pool (SCP)
        //string object created in heap and cached in SCP by intern()


        System.out.println("Comparing literals");
        compareStringLiterals();
        System.out.println("Comparing objects");
        compareStringObjects();
        System.out.println("Comparing one literal and one object");
        compareBoth();
        System.out.println("[after interning] .. Comparing one literal and one object");
        compareBothAfterIntern();

    }

    private static void compareBoth() {
        String s1 = "done";
        String s2 = new String("done");
        compareByEquals(s1,s2);
        compareByOperator(s1,s2);
    }

    private static void compareBothAfterIntern() {
        String s1 = "done";
        String s2 = new String("done");
        String intern = s2.intern();
        compareByEquals(s1,intern);
        compareByOperator(s1,intern);
    }
}

/**
 *
 * diff btwn "==" vs "equals()"
 *
* In Java, `==` and `.equals()` are two different ways to compare objects (including strings), and they have distinct purposes and behaviors:

1. **`==` (Reference Equality):**
   - The `==` operator checks for reference equality, meaning it tests whether two variables reference the exact same object in memory.
   - When you use `==` to compare two variables, you're checking if they point to the same memory address, not whether the contents of the objects are the same.
   - This is often used to compare objects like classes and objects created with the `new` keyword.

   In your code:
   - `s1` and `s2` are not reference-equal because `s1` is a reference to a string in the String Constant Pool (SCP), and `s2` is a reference to a string object in the heap.
   - The `s1 == s2` comparison will result in `false`.

2. **`.equals()` (Content Equality):**
   - The `.equals()` method is used to compare the content or values of two objects.
   - It is overridden in the `String` class to compare the character sequences of two strings. Two strings are considered equal if their characters are the same.
   - `.equals()` is typically used when you want to determine if the contents of two objects are equivalent.

   In your code:
   - `s1` and `s2` are content-equal because their values (the character sequences) are the same.
   - The `s1.equals(s2)` comparison will result in `true`.

Here's a summary:

- Use `==` for reference equality, to check if two references point to the same object in memory.
- Use `.equals()` for content equality, to check if the content or values of two objects are the same.

In most cases, when comparing strings for equality, you should use `.equals()` because it checks the actual content of the strings. However, if you need to check whether two references point to the exact same object in memory, then you can use `==`.
**/
