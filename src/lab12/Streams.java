package lab12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {
    public void testStreams() {
        Arrays.asList("a1", "a2", "a3")
                .stream()
                .findFirst()
                .ifPresent(System.out::println);

        Stream.of("a1", "a2", "a3")
                .findFirst()
                .ifPresent(System.out::println);

        IntStream.range(1, 4)
                .forEach(System.out::println);

        Arrays.stream(new int[] {1, 2, 3})
                .map(n -> 2 * n + 1)
                .average()
                .ifPresent(System.out::println);
    }

    public static void whenNamesPresentConsumeAll(){
        Consumer<String> printConsumer = System.out::println;
        Stream<String> cities = Stream.of("Sydney", "Dhaka", "New York", "London");
        cities.forEach(printConsumer);
    }

    public static void whenNamesPresentUseBothConsumer(){
        List<String> cities = Arrays.asList("Sydney", "Dhaka", "New York", "London");

        Consumer<List<String>> upperCaseConsumer = list -> {
            for(int i=0; i< list.size(); i++){
                list.set(i, list.get(i).toUpperCase());
            }
        };
        Consumer<List<String>> printConsumer = list -> list.forEach(System.out::println);

        upperCaseConsumer.andThen(printConsumer).accept(cities);
    }

    public static void testPredicate(){
        List<String> names = Arrays.asList("John", "Smith", "Samueal", "Catley", "Sie");
        Predicate<String> nameStartsWithS = str -> str.startsWith("S");
        names.stream().filter(nameStartsWithS).forEach(System.out::println);
    }

    public static void testPredicateAndComposition(){
        List<String> names = Arrays.asList("John", "Smith", "Samueal", "Catley", "Sie");
        Predicate<String> startPredicate = str -> str.startsWith("S");
        Predicate<String> lengthPredicate = str -> str.length() >= 5;
        names.stream().filter(startPredicate.and(lengthPredicate)).forEach(System.out::println);
    }

    public static void testFunctions(){
        List<String> names = Arrays.asList("Smith", "Gourav", "Heather", "John", "Catania");
        Function<String, Integer> nameMappingFunction = String::length;
        List<Integer> nameLength = names.stream().map(nameMappingFunction).collect(Collectors.toList());
        System.out.println(nameLength);
    }

    public static void supplier(){
        Supplier<Double> doubleSupplier1 = () -> Math.random();
        DoubleSupplier doubleSupplier2 = Math::random;

        System.out.println(doubleSupplier1.get());
        System.out.println(doubleSupplier2.getAsDouble());
    }

    public static void testMap() {
        String[] myArray = new String[]{"bob", "alice", "paul", "ellie"};
        Stream<String> myStream = Arrays.stream(myArray);
        Stream<String> resultStream1 = myStream.map(s -> s.toUpperCase());
        System.out.println(resultStream1.collect(Collectors.toList()));

        Stream<Integer> resultStream2 = myStream.map(s -> s.length());
        System.out.println(resultStream2.collect(Collectors.toList()));

        class Student{
            final String name;
            final Integer age;

            Student(String name, Integer age) {
                this.name = name;
                this.age = age;
            }
        }
        Stream<Student> myStream1 = Arrays.stream(new Student[] {
                new Student("Moromete", 69),
                new Student("Petrini", 42)
        });
        Stream<Student> resultStream3 = myStream1.map(s -> new Student(s.name, s.name.length()));
        System.out.println(resultStream3.collect(Collectors.toList()));
    }

    public static void testFilter() {
        ArrayList<String> myArray = (ArrayList<String>) Arrays.asList("dog", "cat", "monkey", "elephant", "rat", "lion", "zebra");
        String[] myNewArray =  Arrays.stream((String[])myArray.toArray())
                .filter(x -> x.length() > 4)
                .toArray(String[]::new);
        System.out.println(myNewArray);
    }

    public static void testReduce() {
        String[] myArray = { "this", "is", "a", "sentence" };
        String result = Arrays.stream(myArray)
                .reduce("", (a,b) -> a + b);
        System.out.println(result);
    }

    public static void testFlatMap() {
        class Subject {
            double grade;
            String name;

            public Subject(double grade, String name) {
                this.grade = grade;
                this.name = name;
            }

            @Override
            public String toString() {
                return "Subject{" +
                        "grade=" + grade +
                        ", name='" + name + '\'' +
                        '}';
            }
        }

        class Student {
            String name;
            List<Subject> subjects;

            public Student(String name, List<Subject> subjects) {
                this.name = name;
                this.subjects = subjects;
            }

            public List<Subject> getSubjects() {
                return subjects;
            }
        }

        var subjects = new ArrayList<>(Arrays.asList(
                new Subject(5, "SO"),
                new Subject(10, "PP"),
                new Subject(9, "POO"),
                new Subject(8, "TS")
        ));

        var students = new ArrayList<>(Arrays.asList(
                new Student("Moromete", subjects),
                new Student("Adi", subjects),
                new Student("Celentano", subjects)
        ));

        var totalSubjects = students.stream()
                .map(Student::getSubjects)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        System.out.println(totalSubjects);

        var groupGrades = students.stream()
                .map(Student::getSubjects)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(subject -> subject.grade, Collectors.toList()));
        System.out.println(groupGrades);


        var mapStudentGrades = students.stream()
                .collect(Collectors.toMap(x -> x,
                        student -> student.getSubjects().stream().map(s -> s.grade).collect(Collectors.toList())));
        System.out.println(mapStudentGrades);

    }
}
