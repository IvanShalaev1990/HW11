package org.task.two;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The TaskTwo class demonstrates operations on a list of names.
 * Convert names to uppercase.
 * Sort the names in reverse order.
 *
 * @author Shalaiev Ivan.
 * @version 1.0.0 23.09.2023
 */
public class TaskTwo {
    public static void main(String[] args) {
        String[] names = {"Robert", "Enrico", "Richard", "Niels", "Edward", "John", "Richard", "Robert", "Emilio", "Hans"};
        List<String> stringToUpperCaseAndSorted = Arrays.stream(names)
                .map(String::toUpperCase)// Convert names to uppercase
                .sorted(Comparator.reverseOrder())// Sort the names in reverse order
                .collect(Collectors.toList());// Collect the sorted names into a list
        System.out.println("stringToUpperCaseAndSorted = " + stringToUpperCaseAndSorted);
    }
}
