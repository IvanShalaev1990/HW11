package org.task.five;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * The TaskFive class demonstrates the zip operation on two streams.
 *
 * @author Shalaiev Ivan.
 * @version 1.0.0 23.09.2023
 */
public class TaskFive {
    public static void main(String[] args) {
        String[] namesTen = {"Robert", "Enrico", "Richard", "Niels", "Edward", "John", "Richard", "Robert", "Emilio", "Hans"};
        String[] namesFive = {"Robert", "Enrico", "Richard", "Niels", "Edward"};
        Stream<String> first = Arrays.stream(namesTen);
        Stream<String> second = Arrays.stream(namesFive);
        // Example usage:
        zip(first, second).forEach(System.out::println);
    }

    /**
     * Zips two streams together by alternating elements from each stream.
     *
     * @param first  The first stream.
     * @param second The second stream.
     * @param <T>    The type of elements in the streams.
     * @return A stream with elements alternated from the input streams.
     */
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> firstIterator = first.iterator();// Create iterators for the input streams
        Iterator<T> secondIterator = second.iterator();
        // Create an interleaved iterator that alternates between the two streams
        Iterator<T> interleavedIterator = new Iterator<T>() {
            boolean useFirstStream = true;

            @Override
            public boolean hasNext() {
                return firstIterator.hasNext() && secondIterator.hasNext();
            }

            @Override
            public T next() {
                if (useFirstStream) {
                    useFirstStream = false;
                    return firstIterator.hasNext() ? firstIterator.next() : null;
                } else {
                    useFirstStream = true;
                    return secondIterator.hasNext() ? secondIterator.next() : null;
                }
            }
        };
        // Generate a stream by repeatedly calling the next element from the interleaved iterator
        return Stream.generate(interleavedIterator::next)
                // Take elements from the generated stream until a null element is encountered
                .takeWhile(Objects::nonNull);

    }
}
