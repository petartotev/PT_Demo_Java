package Collections;

import java.util.*;
import java.util.function.BiFunction;

public class ElCollectore {
    public void playWithCommonCollectionMethods() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());

        List<String> names1 = new ArrayList<String>();
        List<String> names2 = new ArrayList<>(); /* can omit type on the right side */
        var colors = new ArrayList<String>(); /* Java 17 */

        // add() - adds an element in the Collection, returns true/false
        // allows duplicate entities!
        System.out.println(colors.add("red"));
        System.out.println(colors.add("green"));
        System.out.println(colors.add("blue"));
        System.out.println(colors.add("red"));

        // toString() method provides nice way to print the collection directly!
        System.out.println(colors); /* [red, green blue, red] */

        // remove() - removes an element in the Collection, returns true/false
        // Removes only the first match is removed!
        System.out.println(colors.remove("red"));

        System.out.println(colors); /* [green blue, red] */

        // isEmpty()
        System.out.println(colors.isEmpty());

        // size()
        System.out.println(colors.size());

        // clear()
        colors.clear();
        System.out.println(colors.size()); /* 0 */
        System.out.println(colors.isEmpty());

        colors.add("red");
        colors.add("green");
        colors.add("blue");

        // contains()
        System.out.println(colors.contains("red"));
        System.out.println(colors.contains("yellow"));

        // removeIf()
        colors.add("brownish");
        System.out.println(colors);
        colors.removeIf(x -> x.startsWith("r") || x.length() > 6);
        System.out.println(colors);

        // forEach()
        colors.forEach(x -> System.out.println(x + " color!"));

        // equals()
        // Compares type and contents of Collection.
        // ArrayList checks order.
        // HashSet does not check order.
    }

    public void playWithLists() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());

        /*
        List - an ordered collection that can contain duplicate entries.
        Unlike array, its size can change after being declared.
        2 classes that implement List: ArrayList and LinkedList
        - ArrayList - when you read more than you write
        - LinkedList - implements List and Deque
         */

        /*
        Create List using FACTORY METHOD (⚠️ size is fixed (no adding or removing)):
        1. Arrays.asList(varargs)
        2. List.of(varargs)
        3. List.copyOf(collection)
         */

        String[] names = new String[] { "John", "Jack", "Jay" };

        List<String> namesList = Arrays.asList(names);
        // namesList.add("Amy");    /* ⚠️⚠️⚠️ java.lang.UnsupportedOperationException */
        List<String> namesOf = List.of(names);
        // namesOf.add("Amy");      /* ⚠️⚠️⚠️ java.lang.UnsupportedOperationException */
        List<String> namesCopyOf = List.copyOf(namesList);
        // namesCopyOf.add("Amy");  /* ⚠️⚠️⚠️ java.lang.UnsupportedOperationException */
        // namesCopyOf.set(0, "Paul"); /* ⚠️⚠️⚠️ java.lang.UnsupportedOperationException */

        names[1] = "Ben";
        System.out.println(Arrays.toString(names)); /* [John, Ben, Jay] */
        System.out.println(namesList);              /* [John, Ben, Jay] ⚠️ List also changed */
        System.out.println(namesOf);                /* [John, Jack, Jay] */
        System.out.println(namesCopyOf);            /* [John, Jack, Jay] */

        namesList.set(2, "Michael");
        System.out.println(namesList);              /* [John, Ben, Michael] */
        System.out.println(Arrays.toString(names)); /* [John, Ben, Michael] ⚠️ Array also changed */

        /*
        Create List using Constructor
         */

        // Recommended: Put name of interface on left side, name of class on right side.
        List<String> myList1 = new ArrayList<>();
        List<String> myList2 = new ArrayList<>(myList1);
        List<String> myList3 = new ArrayList<>(5); /* reservation of slots, but if you put 6 it expands. */
    }

    public void playWithListMethods() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());

        List<String> names = new ArrayList<>();

        // add(E element)
        names.add("John");
        names.add("George");
        names.add("Paul");
        names.add("Ringo");
        System.out.println(names);

        // add(int index, E element)
        names.add(1, "Luke");
        System.out.println(names);

        // get(int index)
        System.out.println(names.get(0));

        // set(int index, E element)
        names.set(3, "Ben");
        System.out.println(names);

        // remove(int index)
        names.remove(1);
        System.out.println(names);

        // remove(E element)
        names.remove("Ben");
        System.out.println(names);

        // replaceAll(UnaryOperator<E> op)
        names.replaceAll(s -> s + " A.");
        System.out.println(names);

        // sort(Comparator<? super E> c)

        // toArray();
        Object[] objArray = names.toArray();
        String[] strArray = names.toArray(new String[0]); /* TODO */
    }

    public void playWithRemovingFromIntegersList() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());

        List<Integer> myNumbers = new ArrayList<>();
        myNumbers.add(2);
        myNumbers.add(7);
        myNumbers.add(5);
        myNumbers.add(1);

        myNumbers.remove(1); /* 1 will be treated as index */
        myNumbers.remove(Integer.valueOf(7)); /* 7 will be treated as integer value */
    }

    public void playWithSets() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());

        /*
        Set Interface - doesn't allow duplicate entries!
        2 implementations:
        HashSet - stores key-value elements in hash table
        - key is hashCode(), value is Object
        - Does not keep order!
        - takes the same time to add elements
        TreeSet - stores element in a sorted tree structure
        - Keeps order!
        - takes more time to add elements
         */

        Set<String> names = new HashSet<>();
        System.out.println(names.add("John"));  /* true */
        System.out.println(names.add("Rex"));   /* true */
        System.out.println(names.add("John"));  /* false */
        System.out.println(names.add("Ben"));   /* true */
        System.out.println(names);  /* [Rex, John, Ben] ⚠️ DOES NOT KEEP ORDER! */

        Set<String> treeNames = new TreeSet<>();
        System.out.println(treeNames.add("John"));  /* true */
        System.out.println(treeNames.add("Rex"));   /* true */
        System.out.println(treeNames.add("John"));  /* false */
        System.out.println(treeNames.add("Ben"));   /* true */
        System.out.println(treeNames);  /* [Ben, John, Rex] KEEPS ORDER - LAST ADDED IS FIRST IN THE LIST */
    }

    public void playWithQueues() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());

        /*
        Queue - first in, first out (FIFO)
        Queue Interface implemented by LinkedList class
        Proper methods: peek(), offer(E e), poll()
        Collection methods: element(), add(E e), remove()
         */

        Queue<String> colors = new LinkedList<>();
        colors.offer("cyan");
        colors.offer("magenta");
        colors.offer("yellow");
        colors.offer("black");
        System.out.println(colors);         /* [cyan, magenta, yellow, black] */
        System.out.println(colors.peek());  /* cyan */
        colors.poll();
        System.out.println(colors);         /* [magenta, yellow, black] */
        System.out.println(colors.peek());  /* magenta */
    }

    public void playWithDequeuesAsStack() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());

        /*
        Deque Interface used as Stack:
        Implemented by LinkedList and ArrayDeque
        LIFO = Last In First Out
        Proper methods: peek(), push(), poll()
        Collection methods: element(), add(E e), remove()
         */

        Deque<String> colors = new ArrayDeque<>();
        colors.push("cyan");
        colors.push("magenta");
        colors.push("yellow");
        colors.push("black");
        System.out.println(colors);         /* [black, yellow, magenta, cyan] */
        System.out.println(colors.peek());  /* black */
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

        /*
        Deque Interface used as Double-Ended Queue:
        Implemented by LinkedList and ArrayDeque
        LIFO = Last In First Out
        Proper methods:
        - peekFirst(), offerFirst(), pollFirst()
        - peekLast(), offerLast(), pollLast()
        Collection methods:
        - getFirst(), addFirst(E e), removeFirst()
        - getLast(), addLast(E e), removeLast()
         */

        Deque<Integer> nums = new LinkedList<>();
        nums.addFirst(9);
        nums.offerFirst(-11);
        nums.addLast(5);
        System.out.println(nums);               /* [-11, 9, 5] */
        System.out.println(nums.getFirst());    /* -11 */
        System.out.println(nums.peekLast());    /* 5 */
        nums.pollFirst();
        System.out.println(nums);               /* [9, 5] */
        System.out.println(nums.getFirst());    /* 9 */
        System.out.println(nums.peekLast());    /* 5 */
    }

    public void playWithMaps() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());

        /*
        Map - collection which stores key-value pairs.
        2 implementations of Map Interface:
        HashMap
        - order not kept
        - same amount of time to add/get elements
        TreeMap
        - order preserved
        - takes more time to add/get elements
         */

        // Option 1
        Map<Integer, String> names1 = Map.of(1, "John", 2, "George", 3, "Luke");
        System.out.println(names1); /* { 1 = John, 2 = George, 3 = Luke } */

        // Option 2
        Map<Integer, String> names2 = new HashMap<>();
        names2 = Map.ofEntries(
                Map.entry(1, "John"),
                Map.entry(2, "George"),
                Map.entry(3, "Luke"));
        System.out.println(names2);

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
    }
}
