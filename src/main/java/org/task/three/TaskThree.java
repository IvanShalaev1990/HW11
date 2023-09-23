package org.task.three;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.*;

/**
 * The TaskThree class demonstrates operations on an array of strings.
 *
 * @author Shalaiev Ivan.
 * @version 1.0.0 23.09.2023
 */
public class TaskThree {
    public static void main(String[] args) {
        String[] arrayToConvert = new String[]{"1, 2, 0", "4, 5"};
        List<Integer> sortedList = Arrays.stream(arrayToConvert)// Convert the array of strings to a stream
                .flatMap(array -> Arrays.stream(array.split(",")))// Split each string by comma and flatten the resulting arrays
                .map(String::trim)// Trim each element to remove leading/trailing spaces
                .map(Integer::parseInt)// Convert each element to an integer
                .sorted()// Sort the integers in ascending order
                .collect(toList());// Collect the sorted integers into a list
        System.out.println("sortedList = " + sortedList);
    }
}
