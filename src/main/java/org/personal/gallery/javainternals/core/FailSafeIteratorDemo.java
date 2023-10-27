package org.personal.gallery.javainternals.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafeIteratorDemo {
    public static void main(String[] args) {
        System.out.println("Fail safe...");
        playWithFailSafe();
        System.out.println("Fail fast...");
        playWithFailFast();
    }

    private static void playWithFailFast() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        // Create a fail-fast iterator
        Iterator<String> iterator = list.iterator();

        // Iterate over the list
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);

            // Modify the list while iterating
            if (element.equals("two")) {
                list.add("four");
            }
        }

        System.out.println("List after iteration: " + list);
    }

    private static void playWithFailSafe() {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        // Create a fail-safe iterator
        Iterator<String> iterator = list.iterator();

        // Iterate over the list
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);

            // Modify the list while iterating
            if (element.equals("two")) {
                list.add("four");
            }
        }

        System.out.println("List after iteration: " + list);
    }
}
