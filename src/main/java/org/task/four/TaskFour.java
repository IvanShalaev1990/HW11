package org.task.four;

import java.util.stream.Stream;

/**
 * The TaskFour class demonstrates a random number generator using a linear congruential formula.
 *
 * @author Shalaiev Ivan.
 * @version 1.0.0 23.09.2023
 */
public class TaskFour {
    public static void main(String[] args) {
        long a = 25214903917l; // Multiplier
        long c = 11l; // Increment
        long m = (long) (Math.pow(2, 48) * Math.pow(2, 48)); // Modulus

        // Example usage: Print the first 10 random numbers
        randomGenerator(a, c, m).limit(10).forEach(System.out::println);
    }

    /**
     * Generates a stream of random numbers using the linear congruential formula.
     *
     * @param a The multiplier.
     * @param c The increment.
     * @param m The modulus.
     * @return A stream of random numbers.
     */
    public static Stream<Long> randomGenerator(Long a, Long c, Long m) {
        return Stream.iterate(
                System.currentTimeMillis(),//Seed value
                (x) -> (a * x + c) % m //Generate the next random number based on the formula
        );
    }
}
