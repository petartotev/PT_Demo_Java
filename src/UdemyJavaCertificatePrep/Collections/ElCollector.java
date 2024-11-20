package Collections;

import java.util.*;
import java.util.function.BiFunction;

public class ElCollector {
    public void playWithCommonCollectionMethods() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());

        List<String> names1 = new ArrayList<String>();
        List<String> names2 = new ArrayList<>();    /* ✅ SUCCESS: Can omit type on the right side */
        //List<> names2 = new ArrayList<String>();  /* 🔴 ERROR: Cannot omit type on the left side */
        var colors = new ArrayList<String>();       /* Java 17 */

        // add() - adds an element in the Collection, returns true/false
        System.out.println(colors.add("red"));  /* true */
        System.out.println(colors.add("cyan")); /* true */
        System.out.println(colors.add("blue")); /* true */
        // List allows duplicate entities!
        System.out.println(colors.add("red"));  /* true */

        // toString() method provides nice way to print the collection directly!
        System.out.println(colors);                    /* [red, cyan blue, red] */

        // remove() - removes an element in the Collection, returns true/false
        // Removes only the first match is removed!
        System.out.println(colors.remove("red"));   /* true */
        System.out.println(colors);                    /* [cyan blue, red] */
        System.out.println(colors.remove("brown")); /* false */
        System.out.println(colors);                    /* [cyan blue, red] */

        // isEmpty() - returns true or false
        System.out.println(colors.isEmpty());   /* false */

        // size()
        System.out.println(colors.size());      /* 3 */

        // clear() - returns true or false
        colors.clear();
        System.out.println(colors.size());      /* 0 */
        System.out.println(colors.isEmpty());   /* true */

        colors.add("red");
        colors.add("green");
        colors.add("blue");

        // contains() - returns true or false
        System.out.println(colors.contains("red"));     /* true */
        System.out.println(colors.contains("yellow"));  /* false */

        // removeIf()
        colors.add("brownish");
        colors.add("yellow");
        System.out.println(colors); /* [red, green, blue, brownish, yellow] */
        System.out.println(colors.removeIf(x -> x.startsWith("y") || x.length() > 6)); /* true */
        System.out.println(colors.removeIf(x -> x.length() < 2)); /* false */
        System.out.println(colors); /* [red, green, blue] */

        // forEach()
        colors.forEach(x -> System.out.println(x + " color!")); /* red color! green color! blue color! */

        // equals()
        /*
        Each Collection has equals() method - compares type and contents of Collection.
        ArrayList checks order.
        HashSet does not check order.
         */
    }

    public void playWithListsCreatedByFactoryMethods() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());

        String[] names = new String[] { "John", "Jack", "Jay" };

        List<String> namesList = Arrays.asList(names);
        //namesList.add("Amy");         /* 🔴 ERROR: java.lang.UnsupportedOperationException */

        List<String> namesOf = List.of(names);
        //namesOf.add("Amy");           /* 🔴 ERROR: java.lang.UnsupportedOperationException */

        List<String> namesCopyOf = List.copyOf(namesList);
        //namesCopyOf.add("Amy");       /* 🔴 ERROR: java.lang.UnsupportedOperationException */
        //namesCopyOf.set(0, "Paul");   /* 🔴 ERROR: java.lang.UnsupportedOperationException */

        names[1] = "Ben";
        System.out.println(Arrays.toString(names)); /* [John, Ben, Jay] */
        System.out.println(namesList);              /* [John, Ben, Jay] ⚠️ WARNING: List also changed */
        System.out.println(namesOf);                /* [John, Jack, Jay] */
        System.out.println(namesCopyOf);            /* [John, Jack, Jay] */

        namesList.set(2, "Michael");
        System.out.println(namesList);              /* [John, Ben, Michael] */
        System.out.println(Arrays.toString(names)); /* [John, Ben, Michael] ⚠️ WARNING: Array also changed */
    }

    public void playWithListsCreatedByConstructor() {
        // Recommended: Put name of interface on left side, name of class on right side.
        List<String> myList1 = new ArrayList<>();
        List<String> myList2 = new ArrayList<>(myList1);
        List<String> myList3 = new ArrayList<>(5); /* 💡 FACT: Reserves 5 slots, but if you put 6 it expands. */
    }

    public void playWithListMethods() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());

        List<String> names = new ArrayList<>();

        // add(E element)
        names.add("John");
        names.add("George");
        names.add("Paul");
        names.add("Ringo");
        System.out.println("names: " + names);  /* names: [John, George, Paul, Ringo] */

        // add(int index, E element)
        names.add(1, "Luke");
        System.out.println("names: " + names);  /* names: [John, Luke, George, Paul, Ringo] */

        // get(int index)
        System.out.println(names.get(0));       /* John */

        // set(int index, E element)
        names.set(3, "Ben");
        System.out.println("names: " + names);  /* names: [John, Luke, George, Ben, Ringo] */

        // remove(int index)
        names.remove(1);
        System.out.println("names: " + names);  /* names: [John, George, Ben, Ringo] */

        // remove(E element)
        names.remove("Ben");
        System.out.println("names: " + names);  /* names: [John, George, Ringo] */

        // replaceAll(UnaryOperator<E> op)
        names.replaceAll(s -> s + " A.");
        System.out.println("names: " + names); /* names: [John A., George A., Ringo A.] */

        // sort(Comparator<? super E> c)

        // toArray();
        playWithConvertingListToArrayUsingToArrayMethod();
    }

    public void playWithTwoWaysToUseRemoveMethodForIntegers() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());

        List<Integer> myNumbers = new ArrayList<>();
        myNumbers.add(2);
        myNumbers.add(7);
        myNumbers.add(5);
        myNumbers.add(1);

        myNumbers.remove(1);                /* 1 will be treated as index */
        myNumbers.remove(Integer.valueOf(7));   /* 7 will be treated as integer value */
    }

    private void playWithConvertingListToArrayUsingToArrayMethod() {
        List<Integer> numbers = List.of(new Integer[] { 123, 24, 36, 17 });

        Object[] objArray = numbers.toArray(); /* array of objects */
        Integer[] intArray = numbers.toArray(new Integer[0]); /* special syntax => array of integers */
    }

    public void playWithSets() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());

        Set<String> hashSetNames = new HashSet<>();
        System.out.println(hashSetNames.add("John"));           /* true */
        System.out.println(hashSetNames.add("Rex"));            /* true */
        System.out.println(hashSetNames.add("John"));           /* false */
        System.out.println(hashSetNames.add("Ben"));            /* true */
        System.out.println("hashSetNames: " + hashSetNames);    /* hashSetNames: [Rex, John, Ben] ⚠️ WARNING: DOES NOT KEEP ORDER! */

        Set<String> treeSetNames = new TreeSet<>();
        System.out.println(treeSetNames.add("John"));           /* true */
        System.out.println(treeSetNames.add("Rex"));            /* true */
        System.out.println(treeSetNames.add("John"));           /* false */
        System.out.println(treeSetNames.add("Ben"));            /* true */
        System.out.println("treeSetNames: " + treeSetNames);    /* treeSetNames: [Ben, John, Rex] ✅ SUCCESS: KEEPS ORDER - LAST ADDED IS FIRST IN THE LIST */
    }

    public void playWithQueues() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());

        Queue<String> colors = new LinkedList<>();
        // offer(E e)
        colors.offer("cyan");
        colors.offer("magenta");
        colors.offer("yellow");
        colors.offer("black");
        System.out.println(colors);         /* [cyan, magenta, yellow, black] */
        // peek()
        System.out.println(colors.peek());  /* cyan */
        // poll()
        colors.poll();
        System.out.println(colors);         /* [magenta, yellow, black] */
        System.out.println(colors.peek());  /* magenta */
    }

    public void playWithDequeuesAsStack() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());

        Deque<String> colors = new ArrayDeque<>();
        // push(E e)
        colors.push("cyan");
        colors.push("magenta");
        colors.push("yellow");
        colors.push("black");
        System.out.println(colors);         /* [black, yellow, magenta, cyan] */
        // peek()
        System.out.println(colors.peek());  /* black */
        // pop()
        colors.pop();
        System.out.println(colors);         /* [yellow, magenta, cyan] */
        System.out.println(colors.peek());  /* yellow */
        colors.pop();
        colors.pop();
        colors.pop();
        System.out.println(colors.peek());  /* null */
    }

    public void playWithDequeuesAsDoubleEndedQueues() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());

        Deque<Integer> numbers = new LinkedList<>();
        numbers.addFirst(9);                    /* [9] */
        System.out.println(numbers);
        //numbers.addFirst(-12);
        //System.out.println(numbers);             /* [-12, 9] */
        numbers.offerFirst(-11);
        System.out.println(numbers);               /* [-11, 9] */
        numbers.addLast(5);
        System.out.println(numbers);               /* [-11, 9, 5] */
        System.out.println(numbers.getFirst());    /* -11 */
        System.out.println(numbers);               /* [-11, 9, 5] */
        System.out.println(numbers.peekLast());    /* 5 */
        System.out.println(numbers);               /* [-11, 9, 5] */
        numbers.pollFirst();
        System.out.println(numbers);               /* [9, 5] */
        System.out.println(numbers.getFirst());    /* 9 */
        System.out.println(numbers);               /* [9, 5] */
        System.out.println(numbers.peekLast());    /* 5 */
        System.out.println(numbers);               /* [9, 5] */
    }

    public void playWithMaps() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());

        // Option 1
        Map<Integer, String> names1 = Map.of(1, "John", 2, "George", 3, "Luke");
        System.out.println(names1); /* {2=George, 3=Luke, 1=John} ⚠️ WARNING: DOES NOT KEEP ORDER! */

        // Option 2
        Map<Integer, String> names2 = new HashMap<>();
        names2 = Map.ofEntries(
                Map.entry(1, "John"),
                Map.entry(2, "George"),
                Map.entry(3, "Luke"));
        System.out.println(names2); /* {2=George, 3=Luke, 1=John} ⚠️ WARNING: DOES NOT KEEP ORDER! */

        // Example 1
        Map<Integer, String> names3 = new HashMap<>();
        names3.put(5, "John");
        names3.put(11, "George");
        names3.put(-2, "Luke");

        String myName = names3.get(-2);
        System.out.println(myName);

        for (Integer key : names3.keySet()) {
            System.out.println("Key: " + key + ", Value: " + names3.get(key));
        }

        playWithMapsForEachMethods();
        playWithMapsGetAndGetOrDefaultMethods();
        playWithMapsReplaceMethod();
        playWithMapsPutIfAbsentMethod();
        playWithMapsMergeMethod();
    }

    private void playWithMapsForEachMethods() {
        Map<Integer, String> names = new HashMap<>();
        names.put(5, "John");
        names.put(11, "George");
        names.put(-2, "Luke");

        names.forEach((k, v) -> {
            System.out.println("Key: " + k + ", Value: " + names.get(k));
        });

        names.values().forEach(System.out::println);

        names.entrySet().forEach(e -> System.out.println("Key: " + e.getKey() + ", Value: " + e.getValue()));
    }

    private void playWithMapsGetAndGetOrDefaultMethods() {
        Map<Integer, String> names = new HashMap<>();
        names.put(5, "John");
        names.put(11, "George");
        names.put(-2, "Luke");

        System.out.println(names.get(-2));
        System.out.println(names.get(6));  /* null */
        System.out.println(names.getOrDefault(6, "Name not found!"));
    }

    private void playWithMapsReplaceMethod() {
        Map<Integer, String> names = new HashMap<>();
        names.put(5, "John");
        names.put(11, "George");
        names.put(-2, "Luke");

        String myName = names.replace(-2, "Paul"); /* ⚠️ replaces, but returns old value! */
        System.out.println(myName);    /* Luke */
        System.out.println(names);     /* {-2=Paul, 5=John, 11=George} */
    }

    private void playWithMapsPutIfAbsentMethod() {
        Map<Integer, String> names = new HashMap<>();
        names.put(5, "John");
        names.put(11, "George");
        names.put(-2, "Luke");

        names.putIfAbsent(7, "Paul");
        names.putIfAbsent(-2, "Ringo"); /* nothing happens */
        names.putIfAbsent(11, "null");  /* nothing happens */
    }

    private void playWithMapsMergeMethod() {
        Map<Integer, String> names = new HashMap<>();
        names.put(5, "John");
        names.put(11, "George");
        names.put(-2, "Luke");

        // insert name only if longer than original name
        BiFunction<String, String, String> myLogic = (name1, name2) -> name1.length() > name2.length() ? name1 : name2;
        System.out.println(names.merge(5, "Joe", myLogic));     /* John is kept */
        System.out.println(names.merge(-2, "Lucas", myLogic));  /* Lucas is put */
        System.out.println(names.merge(7, "Paul", myLogic));    /* Pull is put */
    }

    public void playWithSorting() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());

        /*
        If elements in a Collection are primitives - sorted by natural order.
        If elements are string - numbers sort before letters, uppercase before lowercase.
        If not primitives - you have to define own criteria
        2 approaches:
        - use a class implementing Comparable<T> interface
        - pass the implementation of Comparator<T> interface in sort() method
         */

        /*
        Comparable<T> Interface
        1 abstract method: int compareTo(T object)
        if a = b => 0
        if a > b => 1
        if a < b => -1
         */

        List<Person> people = Arrays.asList(
                new Person("John", 25),
                new Person("George", 20),
                new Person("Ben", 30)
        );
        Collections.sort(people);

        System.out.println(people);
        // Before Person overrides toString():
        // [Collections.Person@2b05039f, Collections.Person@61e717c2, Collections.Person@66cd51c3]
        // After Person overrides toString():
        // [Person(Name: George, Age: 20), Person(Name: John, Age: 25), Person(Name: Ben, Age: 30)]

        // If we sometimes want to sort by name and sometimes by age:
        // Use Comparator<T> interface and pass to sort()

        List<Persona> personas = Arrays.asList(
                new Persona("John", 25),
                new Persona("George", 20),
                new Persona("Ben", 30)
        );
        Collections.sort(personas, (p1, p2) -> p1.getAge() - p2.getAge());
        System.out.println(personas);
        Collections.sort(personas, (p1, p2) -> p1.getName().compareTo(p2.getName()));
        System.out.println(personas);

        // Old syntax:
        Comparator<Persona> byAge = new Comparator<Persona>() {
            public int compare(Persona p1, Persona p2) {
                return p1.getAge() - p2.getAge();
            }
        };
        Collections.sort(personas, byAge);
        System.out.println(people);

        // Alternative:
        // Using comparing() method with method reference
        Comparator<Persona> c = Comparator.comparing(Persona::getName);
        Comparator<Persona> cc = Comparator.comparing(Persona::getName).reversed();
        // Chaining!
        Comparator<Persona> ccc = Comparator.comparing(Persona::getName).thenComparing(Persona::getAge);
    }
}
