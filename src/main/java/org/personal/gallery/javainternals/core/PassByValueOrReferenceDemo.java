package org.personal.gallery.javainternals.core;


import org.personal.gallery.javainternals.common.Car;

public class PassByValueOrReferenceDemo {

    static void changeReference(Car refCar){
        Car newCar = new Car("m4");
        refCar = newCar;
    }

    public static void main(String[] args) {
       Car Car = new Car("s90");
        /**
         *  case1: when we pass complex data types other than primitives as parameters to functions,
         *  it just creates reference variable pointing to same object's memory location..
         *  like
         *          Car --> aaa89
         *          refCar ---> aaa89
         *
         *  in changeReference() we just reassign newCar ref variable to new object.. which means now Car still points to original object's memory
         *      but referCar simply now pointing to another object 'newCar' which doesn't affect 'Car' object anyways
         *          Car --> aaa89
         *          newCar ---> aab19
         *          refCar ---> aab19
         */

        System.out.println("\n\n#### case1");

        System.out.println("Before changing object reference : "+ Car);
       changeReference(Car);
        System.out.println("After changing object reference : "+ Car);

        /**
         * but when we update or modify state of the object using reference variable.. then it will be modified
         *   Car --> aaa89
         *   refCar ---> aaa89
         *   as both are pointing to same memory address, if we update state of the object using any reference it will be updated in object's memory aaa89
         *   so whomsover reads next will seee updated state only
         * */


        System.out.println("\n\n#### case2");

        System.out.println("Before modifying state of object by using reference object: "+ Car);
        modifyReference(Car);
        System.out.println("After  modifying state of object by using reference object: "+ Car);

    }

    private static void modifyReference(Car refCar) {
        refCar.setModel("m4");
    }
}
