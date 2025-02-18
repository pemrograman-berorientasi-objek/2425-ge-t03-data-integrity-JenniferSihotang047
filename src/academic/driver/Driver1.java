package academic.driver;

/**
 * @autors 12S23040 Diana Manurung
 * @autors 12S23047 Jennifer Sihotang
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
                    boolean isDuplicateCourse = courses.stream().anyMatch(c -> c.getId().equals(segments[1]));
                    if (!isDuplicateCourse) {
                        courses.add(new Course(segments[1], segments[2], Integer.parseInt(segments[3]), segments[4]));
                    }
                    break;
                case "student-add":
                    boolean isDuplicateStudent = students.stream().anyMatch(s -> s.getNim().equals(segments[1]));
                    if (!isDuplicateStudent) {
                        students.add(new Student(segments[1], segments[2], Integer.parseInt(segments[3]), segments[4]));
                    }
                    break;
                case "enrollment-add":
                    Course course = courses.stream().filter(c -> c.getId().equals(segments[1])).findFirst().orElse(null);
                    Student student = students.stream().filter(s -> s.getNim().equals(segments[2])).findFirst().orElse(null);
                    if (course != null && student != null) {
                        boolean isDuplicateEnrollment = enrollments.stream().anyMatch(e -> e.toString().equals(course.getId() + "|" + student.getNim() + "|" + segments[3] + "|" + segments[4] + "|None"));
                        if (!isDuplicateEnrollment) {
                            enrollments.add(new Enrollment(course, student, segments[3], segments[4]));
                        }
                    } else {
                        if (course == null) {
                            System.out.println("invalid course|" + segments[1]);
                        }
                        if (student == null) {
                            System.out.println("invalid student|" + segments[2]);
                        }
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