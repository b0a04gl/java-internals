package org.personal.gallery.javainternals.core;


import org.personal.gallery.javainternals.common.ImmutableCar;

/**
 * steps that made ImmutableCar class immutables
 * 1. now state of final class can't be altered once object is instantiated as no setters available + state is made private final
 * 2. no other class can extend or override behaviour of class as it is final
 * 3.
 *
 * basically immutable class is what java records in j17
 *
 */
public class ImmutableClassDemo {
    public static void main(String[] args) {
        //making instance of final class also final so that it's not mutated
        final ImmutableCar immutableCar = new ImmutableCar("320li","BMW");
        System.out.println(immutableCar);
        //below is violation
//        immutableCar = new ImmutableCar("xf","jaguar");

        //Identify them and return new objects with copied content for all mutable objects (object references)
        ImmutableCar immutableCar2 = immutableCar; //but still you can't alter the state of object
        System.out.println(immutableCar2);

    }
}
