package org.task.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The TaskOne class demonstrates operations on a list of names.
 *
 * @author Shalaiev Ivan.
 * @version 1.0.0 23.09.2023
 */
public class TaskOne {
    public static void main(String[] args) {
        String[] names = {"Robert", "Enrico", "Richard", "Niels", "Edward", "John", "Richard", "Robert", "Emilio", "Hans"};
        List<String> listNames = new ArrayList<>(Arrays.asList(names));
        // Example usage: print array with indices
        listNames = addNumbersToNames(listNames);
        // Example usage: print array without even indices
        listNames = removeOddIndex(listNames);
    }

    /**
     * Removes elements at odd indices from the given list of names.
     *
     * @param names The list of names.
     * @return The list of names with elements at odd indices removed.
     */
    public static List<String> removeOddIndex(List<String> names) {
        List<String> filteredElements = IntStream.range(0, names.size())
                .filter(i -> i % 2 == 0)// Filter even indices
                .mapToObj(names::get)// Retrieve element at each index
                .collect(Collectors.toList()); // Collect as a new list
        System.out.println(String.join(", ", filteredElements));
        return filteredElements;
    }

    /**
     * Adds numbers to each name in the given list of names.
     *
     * @param names The list of names.
     * @return The list of names with numbers added.
     */
    public static List<String> addNumbersToNames(List<String> names) {
        AtomicInteger index = new AtomicInteger();//Index
        names = names.stream()
                .map(name -> index.incrementAndGet() + ". " + name)//Add index to the names
                .collect(Collectors.toList());// Collect as a new list
        System.out.println(String.join(", ", names));
        return names;
    }
}
