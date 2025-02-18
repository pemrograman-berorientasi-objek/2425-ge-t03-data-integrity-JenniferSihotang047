package academic.driver;

/**
 * @author 12S23040 Diana Manurung
 * @author 12S23047 Jennifer Sihotang
 */

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver1 {

    public static void main(String[] _args) {
        Scanner scanner = new Scanner(System.in);
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<Enrollment> enrollments = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("---")) {
                break;
            }

            String[] segments = input.split("#");
            String command = segments[0];

            switch (command) {
                case "course-add":
                    boolean isDuplicateCourse = courses.stream().anyMatch(c -> c.toString().equals(input));
                    if (!isDuplicateCourse) {
                        courses.add(new Course(segments[1], segments[2], Integer.parseInt(segments[3]), segments[4]));
                    }
                    break;
                case "student-add":
                    boolean isDuplicateStudent = students.stream().anyMatch(s -> s.toString().equals(input));
                    if (!isDuplicateStudent) {
                        students.add(new Student(segments[1], segments[2], Integer.parseInt(segments[3]), segments[4]));
                    }
                    break;
                case "enrollment-add":
                    boolean isDuplicateEnrollment = enrollments.stream().anyMatch(e -> e.toString().equals(input));
                    if (!isDuplicateEnrollment) {
                        enrollments.add(new Enrollment(segments[1], segments[2], segments[3], segments[4]));
                    }
                    break;
            }
        }

        for (Course course : courses) {
            System.out.println(course);
        }
        for (Student student : students) {
            System.out.println(student);
        }
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }

        scanner.close();
    }
}
