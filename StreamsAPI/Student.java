package StreamsAPI;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student {
    String name;
    int score;
    String subject;
    String city;

    public Student(String name, int score, String subject, String city) {
        this.name = name;
        this.score = score;
        this.subject = subject;
        this.city = city;
    }
    // Getters...
    public String getName() { return name; }
    public int getScore() { return score; }
    public String getSubject() { return subject; }
    public String getCity() { return city; }
    @Override public String toString() { return name; }

    //        Get a Set of all unique cities
    public static List<String> getUniqueCities(List<Student> students) {
        List<String> collect = students.stream().map(Student::getCity).distinct().collect(Collectors.toList());
        System.out.println(collect);
        return collect;
    }
    //        Get a LinkedList of student names (Specific collection).
    public static LinkedList<String> getStudentNames(List<Student> students) {
        LinkedList<String> collect = students.stream().map(Student::getName).collect(Collectors.toCollection(LinkedList::new));
        System.out.println(collect);
        return collect;
    }

    //        Separate students into "Pass" (>=50) and "Fail" (<50).
    public static Map<Boolean, List<Student>> studentsPassOrFail(List<Student> students) {
        Map<Boolean, List<Student>> collect = students.stream().collect(Collectors.partitioningBy(student -> student.getScore() >= 50));
        System.out.println(collect);
        return collect;
    }

    //        Count how many passed and how many failed.
    public static Map<Boolean, Long> countStudentsPassAndFail(List<Student> students) {
        Map<Boolean, Long> collect = students.stream().collect(Collectors.partitioningBy(student -> student.getScore() >= 50, Collectors.counting()));
        System.out.println(collect);
        return collect;
    }

    //        Find the Top Scorer in each Subject.
    public static Map<String, Student> topStudentScorerInEachSubject(List<Student> students) {
        Map<String, Student> collect = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getSubject,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Student::getScore)),
                                Optional::get
                        )
                ));

        System.out.println(collect);
        return collect;
    }

    //        Find the Top Scorer in each Subject.
    public static Map<String, String> topStudentNameScorerInEachSubject(List<Student> students) {
        Map<String, Student> collect = students.stream()
                .collect(Collectors.toMap(
                        Student::getSubject,
                        student -> student,
                        (s1, s2) -> s1.getScore() > s2.getScore() ? s1 : s2
                ));

        Map<String, String> collect1 = collect.entrySet().stream().collect(Collectors.toMap(
                map -> map.getKey(),
                entry -> entry.getValue().getName()
        ));
        System.out.println(collect1);
        return collect1;
    }
    //        Return a string: "[Alice, Bob, Charlie]" (Comma separated, with brackets).
    public static String allStudentNames(List<Student> students) {
        String collect = students.stream().map(Student::getName).collect(Collectors.joining(","));
        System.out.println(collect);
        return collect;
    }

    //        Group students by City, then by Subject. (Map<String, Map<String, List<Student>>>)
    //        Create a Map<String, Integer> (Name -> Score). If duplicate names, keep the higher score.

}
