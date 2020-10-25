package lab8;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Collection<String> names = new ArrayList<>();
        names.add("Andrei");
        names.add("Matei");

        Collection<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }

        // iteratori
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            /*
                next() intoarce elementul curent din lista
                si face trecerea la urmatorul element din colectie
             */
            int elem = iterator.next();
            System.out.println(elem);
            /*
                remove() trebuie realizat dupa next()
                si acesta sterge elementul intors de catre next()
             */
            if (elem < 4) {
                iterator.remove();
            }
        }

        // for-each
        for (int elem: numbers) {
            System.out.println(elem);
        }

        // liste
        List<Integer> list = new ArrayList<>();
        list.add(52);
        list.add(12);
        list.add(90);
        list.add(10);
        System.out.println(list.get(0));

        Collections.sort(list);
        System.out.println(list);

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(list);

        // compare
        Student st1 = new Student("Moromete", "Ilie");
        Student st2 = new Student("Moromete", "Niculae");
        Student st3 = new Student("Balosu", "Tudor");
        Student st4 = new Student("Miai", "Ion");
        List<Student> students = new ArrayList<>(Arrays.asList(st1, st2, st3, st4));
        System.out.println(students);
        Collections.sort(students);
        System.out.println(students);
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getName().equals(o2.getName())) {
                    return o2.getSurname().compareTo(o1.getSurname());
                } else {
                    return o2.getName().compareTo(o1.getName());
                }
            }
        });
        System.out.println(students);

        // set
        Set<Integer> set = new HashSet<>();
        set.add(4);
        set.add(41);
        set.add(4);
        set.add(52);
        set.add(100);
        set.add(41);
        System.out.println(set);

        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(4);
        treeSet.add(41);
        treeSet.add(4);
        treeSet.add(52);
        treeSet.add(100);
        treeSet.add(41);
        System.out.println(treeSet);

        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(4);
        linkedHashSet.add(41);
        linkedHashSet.add(4);
        linkedHashSet.add(52);
        linkedHashSet.add(100);
        linkedHashSet.add(41);
        System.out.println(linkedHashSet);


        // map
        Map<Integer, String> map = new HashMap<>();
        map.put(42414, "Andreea");
        map.put(53141, "Maria");
        map.put(89358, "Andra");
        map.put(98578, "Daniela");

        for (Map.Entry<Integer, String> entry: map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println();

        Map<Integer, String> sortedMap = new TreeMap<>(map);
        for (Map.Entry<Integer, String> entry: sortedMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println();

        Map<Integer, String> linkedMap = new LinkedHashMap<>(map);
        for (Map.Entry<Integer, String> entry: linkedMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
