package academic.model;

public class Course {
    private String id;
    private String courseName;
    private int sks;
    private String grade;

    public Course(String id, String courseName, int sks, String grade) {
        this.id = id;
        this.courseName = courseName;
        this.sks = sks;
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + "|" + courseName + "|" + sks + "|" + grade;
    }
}