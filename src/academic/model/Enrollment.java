package academic.model;

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

    public Course getCourse() {
        return course;
    }

    public Student getStudent() {
        return student;
    }

    public String getYear() {
        return year;
    }

    public String getSemester() {
        return semester;
    }

    @Override
    public String toString() {
        return course.getId() + "|" + student.getNim() + "|" + year + "|" + semester + "|" + grade;
    }
}