package academic.model;

/**
 * @autors 12S23040 Diana Manurung
 * @autors 12S23047 Jennifer Sihotang
 */

public class Enrollment {
    private Course course;
    private Student student;
    private String year;
    private String semester;
    private String grade;

    public Enrollment(Course course, Student student, String year, String semester) {
        this.course = course;
        this.student = student;
        this.year = year;
        this.semester = semester;
        this.grade = "None"; 
    }

    public String getGrade() {
        return this.grade;
    }

    @Override
    public String toString() {
        return course.getId() + "|" + student.getNim() + "|" + year + "|" + semester + "|" + grade;
    }
}