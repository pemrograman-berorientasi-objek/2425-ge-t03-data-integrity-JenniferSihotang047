package academic.driver;

import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver2 {

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
                    if (course == null) {
                        System.out.println("invalid course|" + segments[1]);
                    }
                    if (student == null) {
                        System.out.println("invalid student|" + segments[2]);
                    }
                    if (course != null && student != null) {
                        boolean isDuplicateEnrollment = enrollments.stream().anyMatch(e -> 
                            e.getCourse().getId().equals(course.getId()) && 
                            e.getStudent().getNim().equals(student.getNim()) && 
                            e.getYear().equals(segments[3]) && 
                            e.getSemester().equals(segments[4])
                        );
                        if (!isDuplicateEnrollment) {
                            enrollments.add(new Enrollment(course, student, segments[3], segments[4]));
                        }
                    }
                    break;
            }
        }

        courses.stream().sorted((c1, c2) -> c1.getId().compareTo(c2.getId())).forEach(System.out::println);
        students.stream().sorted((s1, s2) -> s1.getNim().compareTo(s2.getNim())).forEach(System.out::println);
        enrollments.stream().sorted((e1, e2) -> {
            int courseCompare = e1.getCourse().getId().compareTo(e2.getCourse().getId());
            if (courseCompare != 0) return courseCompare;
            int studentCompare = e1.getStudent().getNim().compareTo(e2.getStudent().getNim());
            if (studentCompare != 0) return studentCompare;
            int yearCompare = e1.getYear().compareTo(e2.getYear());
            if (yearCompare != 0) return yearCompare;
            return e1.getSemester().compareTo(e2.getSemester());
        }).forEach(System.out::println);

        scanner.close();
    }
}