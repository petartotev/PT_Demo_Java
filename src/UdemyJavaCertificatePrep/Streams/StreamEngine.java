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

    public void playWithSpliterator() {
        // Example 1
        List<String> list = Arrays.asList("One", "Two", "Three", "Four", "Five");
        Stream<String> stream = list.stream();

        Spliterator<String> originalSpliterator = stream.spliterator();      /* three, four, five */
        Spliterator<String> newSpliterator = originalSpliterator.trySplit(); /* one, two *.
        newSpliterator.forEachRemaining(System.out::println);
        System.out.println("---");
        originalSpliterator.forEachRemaining(System.out::println);

        /*
        Output:
            One
            Two
            ---
            Three
            Four
            Five
         */

        /*
        Once you apply forEachRemaining() method on a Spliterator, all elements are processed and Spliterator is now empty,
        so if you run this command again it will return nothing:
         */
        originalSpliterator.forEachRemaining(System.out::println);

        // Example 2
        List<String> list2 = Arrays.asList("One", "Two", "Three", "Four", "Five");
        Stream<String> stream2 = list2.stream();
        Spliterator<String> originalSpliterator2 = stream2.spliterator(); /* three, four five */
        Spliterator<String> newSpliterator2 = originalSpliterator2.trySplit(); /* one, two */
        newSpliterator2.tryAdvance(System.out::println);
        System.out.println("---");
        newSpliterator2.forEachRemaining(System.out::println);
        System.out.println("---");
        originalSpliterator2.tryAdvance(System.out::println);
        System.out.println("---");
        originalSpliterator2.forEachRemaining(System.out::println);

        /*
        Output:
            One
            ---
            Two
            ---
            Three
            ---
            Four
            Five
         */
    }

    public void playWithCollectingResults() {
        // joining() example
        var names = Stream.of("John", "George", "Luke");
        // Static Collectors method is passed as an argument in collect():
        String result = names.collect(Collectors.joining("-"));
        System.out.println(result); /* John-George-Luke */

        // averaging() example
        var names2 = Stream.of("John", "George", "Luke");
        Double result2 = names2.collect(Collectors.averagingInt(String::length));
        System.out.println(result2); /* 4.666666666666667 */

        // toCollection() example
        var names3 = Stream.of("John", "George", "Luke");
        TreeSet<String> result3 = names3
                .filter(s -> s.startsWith("J"))
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println("result3 = " + result3); /* [Joe, John] */
        
        // toMap() example #1
        var names4 = Stream.of("John", "George", "Luke");
        Map<String, Integer> result4 = names4
                .collect(Collectors.toMap(s -> s, String::length));
        System.out.println("result4 = " + result4); /* {George=6, Luke=4, John=4} */

        // toMap() example #2
        var names5 = Stream.of("John", "George", "Luke");
        //Map<Integer, String> result5 = names5
        //        .collect(Collectors.toMap(String::length, k -> k));
        //System.out.println("result5 = " + result5); /* ERROR: Exception java.lang.IllegalStatException: Duplicate key 4
        // to solve this we have to provide a merge rule, e.g.
        var names6 = Stream.of("John", "George", "Luke");
        Map<Integer, String> result6 = names6.collect(Collectors.toMap(
                String::length,
                k -> k,
                (s1, s2) -> s1 + ";" + s2));
        System.out.println("result6 = " + result6);

        /*
        If we don't specify the class, toMap can return any class which implements Map interface (usually HashMap, but not guaranteed) or we can specify the class:
         */
        // This example from the Tutorials does not compile, so it was commented out.
        //var names7 = Stream.of("John", "George", "Luke");
        //Map<Integer, String> result7 = names7.collect(Collectors.toMap(
        //        String::length,
        //        k -> k,
        //        (s1, s2) -> s1 + ";" + s2),
        //        TreeMap::new);
        //System.out.println("result7 = " + result7); /* {4=John;Luke, 6=George} */
        //System.out.println(result.getClass()); /* class java.util.TreeMap */

        // groupingBy() example #1
        var names8 = Stream.of("John", "George", "Luke");
        Map<Integer, List<String>> result8 = names8
                .collect(Collectors.groupingBy(String::length)); /* argument is Function */
        System.out.println("result8 = " + result8); /* {4=[John,Luke], 6=[George]} */

        // groupingBy() example #2
        var names9 = Stream.of("John", "George", "Luke");
        Map<Integer, Set<String>> result9 = names9
                .collect(Collectors.groupingBy(String::length, Collectors.toSet())); /* downstream collector ensures that the value will be Set */
        System.out.println("result8 = " + result8); /* {4=[John,Luke], 6=[George]} */

        // groupingBy() example #3
        var names10 = Stream.of("John", "George", "Luke");
        TreeMap<Integer, Set<String>> result10 = names10
                .collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet())); /* map supplier ensures that the Map implementation will be TreeMap */
        System.out.println("result10 = " + result10); /* {4=[John,Luke], 6=[George]} */

        // partitioningBy() has only 2 groups: true and false
        var names11 = Stream.of("John", "George", "Luke");
        Map<Boolean, List<String>> result11 = names11.collect(
                Collectors.partitioningBy(s -> s.length() <= 4));
        System.out.println("result11 = " + result11); /* {false=[George], true=[John, Luke]} */

        // partitioningBy() with Set instead of List
        var names12 = Stream.of("John", "George", "Luke");
        Map<Boolean, Set<String>> result12 = names12.collect(
                Collectors.partitioningBy(s -> s.length() <= 4, Collectors.toSet())); /* We have provided downstream collector */
        System.out.println("result12 = " + result12); /* {false=[George], true=[John, Luke]} */

        // teeing() is used for returning multiple values, e.g. sum and average
        // step 1: create a type which stores values:
        record MyData(int sum, double avg) {}
        // step 2: use stream to return the result of the type MyData
        var numbers = Stream.of(1,2,3,4,5);
        MyData result13 = numbers.collect(
                Collectors.teeing(
                        Collectors.summingInt(i -> i),
                        Collectors.averagingDouble(i -> i),
                        MyData::new
                ));
        System.out.println("Sum: " + result13.sum() + ", Average: " + result13.avg()); /* Sum: 15, Average: 3.0 */
    }
}
