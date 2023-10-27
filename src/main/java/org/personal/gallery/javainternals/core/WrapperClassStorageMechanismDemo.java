package org.personal.gallery.javainternals.core;


// similar to String, Wrapper classes in java
//Well, it’s already there. JDK-provided wrapper classes implement instance pooling.
// Each wrapper class stores a list of commonly used instances of its own type in form of cache and whenever required, we can use them in our code.
public class WrapperClassStorageMechanismDemo {
    public static void main(String[] args) {
        Integer a = 127; // Autoboxing - Reuses common value from -128 to 127
        Integer b = 127;

        Integer x = 128; // Does not reuse common value
        Integer y = 128;

        System.out.println("a and b using ==: " + (a == b)); // true
        System.out.println("a and b using .equals(): " + a.equals(b)); // true

        System.out.println("x and y using ==: " + (x == y)); // false
        System.out.println("x and y using .equals(): " + x.equals(y)); // true

    }
}

/****
 *
 * when you write `Integer a = 127;`, it is internally equivalent to calling `Integer.valueOf(127)`.
 * This behavior is part of autoboxing, which is a feature in Java that automatically converts primitive data types to their
 * corresponding wrapper objects when needed. Autoboxing simplifies the process of converting between primitives and their object representations.
 *
 * So, `Integer a = 127;` is effectively the same as `Integer a = Integer.valueOf(127);`.
 * The `Integer.valueOf(int)` method is responsible for caching commonly used values within a certain range, which includes the value `127`
 * as part of the range of cached values for `Integer`.
 * This means that `a` will reference an existing cached `Integer` object if the value falls within the cacheable range.
 * If the value is outside that range, a new `Integer` object will be created.
 *
 */
