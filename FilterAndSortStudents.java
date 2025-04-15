import java.util.*;
import java.util.stream.*;

class Student {
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() { return name; }
    public int getMarks() { return marks; }

    @Override
    public String toString() {
        return "Student{name='" + name + "', marks=" + marks + "}";
    }
}

public class FilterAndSortStudents {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("John", 80),
            new Student("Alice", 90),
            new Student("Bob", 70),
            new Student("Charlie", 85)
        );

        // Filter students with marks above 75% and sort by marks
        List<String> sortedStudents = students.stream()
            .filter(s -> s.getMarks() > 75)
            .sorted(Comparator.comparingInt(Student::getMarks))
            .map(Student::getName)
            .collect(Collectors.toList());

        // Display the sorted names
        sortedStudents.forEach(System.out::println);
    }
}
