package org.personal.gallery.javainternals.core;

public class PSVMUsageDemo {
    /***
     *
     * public -> access modifier needed to make it accessible by JVM.. if  not provided it violates lang access rules.. that JNI things is still possible but not circummvent
     * static -> as we're accessing class instance not the object
     * void --> no return values to JVM needed
     **/
    public static void main(String[] args) {
        System.out.println("hello main()");
    }
}
