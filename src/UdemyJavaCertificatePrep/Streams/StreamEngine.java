package Streams;

import java.util.*;
import java.util.stream.*;

public class StreamEngine {
    public void playWithCollectingStreams() {
        Stream<String> myStream = Stream.of("L", "u", "k", "e");
        StringBuilder myName = myStream.collect(
                StringBuilder::new,     /* supplier - creates the object that will store the results */
                StringBuilder::append,  /* accumulator - passed as BiConsumer */
                StringBuilder::append); /* combiner - passed as BiConsumer */
        System.out.println(myName);     /* Luke */

        // If parallel stream is used, order is unpredictable.

        playWithCollectingStreamsKeepingOrder();
        playWithCollectingStreamsNotKeepingOrder();
    }

    private void playWithCollectingStreamsKeepingOrder() {
        // Keeping the order in the collection (sorted).
        Stream<String> myStream = Stream.of("L", "u", "k", "e");
        TreeSet<String> mySet = myStream.collect(
                TreeSet::new,
                TreeSet::add,
                TreeSet::addAll);
        System.out.println(mySet); /* [L, e, k, u} - TreeSet automatically sorts in ascending (alphabetical) order */

        // Using Collectors class
        Stream<String> myStream2 = Stream.of("L", "u", "k", "e");
        TreeSet<String> mySet2 = myStream2.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(mySet2); /* [L, e, k, u} - TreeSet automatically sorts in ascending (alphabetical) order */
    }

    private void playWithCollectingStreamsNotKeepingOrder() {
        Stream<String> myStream = Stream.of("L", "u", "k", "e");
        Set<String> mySet = myStream.collect(Collectors.toSet());
        // You don't know which implementation of Set you will get (allegedly, HashSet).
        System.out.println(mySet);
    }

    public void playWithIntermediateOperations() {
        // filter
        Stream<String> names1 = Stream.of("John", "George", "Ben");
        names1.filter(su -> su.startsWith("G")).forEach(System.out::println);

        // removing duplicates (distinct)
        Stream<String> names2 = Stream.of("John", "John", "John", "Ben"); /* John, Ben */
        names2.distinct().forEach(System.out::println);

        // restrict by position
        Stream<Integer> numbers = Stream.iterate(1, n -> n + 1);     /* Infinite stream of numbers, starting from 1 */
        numbers.skip(3).limit(4).forEach(System.out::print);    /* 4567 */

        // mapping using map()
        Stream<String> names3 = Stream.of("John", "George", "Ben");
        names3.map(s -> s.length()).forEach(System.out::print);   /* 463 */

        // mapping using flatMap()
        List<String> zero = List.of();
        List<String> one = List.of("John");
        List<String> two = List.of("George", "Ben");
        Stream<List<String>> names4 = Stream.of(zero, one, two);
        names4.flatMap(m -> m.stream()).forEach(System.out::println); /* John, George, Ben */

        // sorting
        Stream<String> names5 = Stream.of("John", "George", "Benedict");
        names5.sorted().forEach(System.out::print); /* BenedictGeorgeJohn */

        Stream<String> names6 = Stream.of("John", "George", "Benedict");
        names6.sorted(Comparator.comparingInt(String::length));

        // peek
        Stream<String> names7 = Stream.of("John", "George", "Ben");
        long count = names7.filter(s -> s.startsWith("G")).count();
        System.out.println(count);  /* 1 */

        // if we want to see what's going on in the pipeline:
        Stream<String> names8 = Stream.of("John", "George", "Ben");
        long count2 = names8.filter(s -> s.startsWith("G")).peek(System.out::println).count(); /* George \n 1 */
    }

    public void playWithPuttingThePipelineTogether() {
        // Example: for given list of names get first 2 names which are 4 chars long, in alphabetical order.

        // Old way:
        var list = List.of("John", "George", "Paul", "Ringo");
        List<String> filtered = new ArrayList<>();
        for (String name: list) {
            if (name.length() == 4) filtered.add(name);
        }
        Collections.sort(filtered);
        var iter = filtered.iterator();
        if (iter.hasNext()) System.out.println(iter.next());    /* John\nPaul */
        if (iter.hasNext()) System.out.println(iter.next());

        // New way:
        var list2 = List.of("John", "George", "Paul", "Ringo");
        list2
                .stream()
                .filter(n -> n.length() == 4)
                .sorted()
                .limit(2)
                .forEach(System.out::println); /* John\nPaul */

        // Chain more pipelines together:
        long count = Stream.of("John", "George", "Paul", "Ringo")
                .filter(s -> s.length() > 4)
                .collect(Collectors.toList())
                .stream()   /* chaining! */
                .count();   /* 2 */
    }

    public void playWithPrimitiveStreams() {
        // Example 1
        IntStream myIntStream1 = IntStream.of(7,11,21);
        OptionalDouble avg = myIntStream1.average();
        System.out.println("avg. = " + avg.getAsDouble());  /* 13 */

        // Example 2
        DoubleStream myDoubleStream1 = DoubleStream.of(3.14, 2.72, 1.618);
        myDoubleStream1.forEach(System.out::println); /* 3.14\n2.72\n1.618 */

        // Example 3
        IntStream myIntStream2 = IntStream.range(2, 5);
        myIntStream2.forEach(System.out::print); /* 234 */

        // Example 4
        IntStream myIntStream3 = IntStream.rangeClosed(2, 5);
        myIntStream3.forEach(System.out::print); /* 2345 */
    }

    public void playWithMappingStreams() {
        // mapping example
        Stream<String> objStream = Stream.of("John", "George", "Paul", "Ringo");
        IntStream intStream = objStream.mapToInt(s -> s.length());
        intStream.forEach(System.out::print); /* 4465 */

        // flatMap() - use in the same way as before:
        List<List<Integer>> listOfLists = new ArrayList<>();
        listOfLists.add(Arrays.asList(1,2,3));
        listOfLists.add(Arrays.asList(4,5));
        listOfLists.add(Arrays.asList(6,7,8,9));
        System.out.println(listOfLists);

        IntStream intStream123 = listOfLists
                .stream()
                .flatMapToInt(list -> list.stream().mapToInt(n -> n));
        intStream123.forEach(System.out::print); /* [[1,2,3],[4,5],[6,7,8,9]] 123456789 */

        // Primitive streams use optionals
        var myIntStreamy = IntStream.rangeClosed(2,7);
        OptionalDouble myAvg = myIntStreamy.average();
        myAvg.ifPresent(System.out::println);                   /* 4.5 */
        System.out.println(myAvg.getAsDouble());                /* 4.5 */
        System.out.println(myAvg.orElseGet(() -> Double.NaN));  /* 4.5 */
    }

    public void playWithSummarizingStatistics() {
        // Example using summarizing statistics
        var intStream = IntStream.of(7, 2, -4, 11, 27);
        IntSummaryStatistics stats = intStream.summaryStatistics();
        System.out.println(stats.getCount());   /* 5 */
        System.out.println(stats.getAverage()); /* 8.6 */
        System.out.println(stats.getMin());     /* -4 */
        System.out.println(stats.getMax());     /* 27 */
    }
}
