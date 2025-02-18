package academic.model;

/**
 * @author 12S23040 Diana Manurung
 * @author 12S23047 Jennifer Sihotang
 */

public class Enrollment {
    private String id;
    private String nim;
    private String akt;
    private String semester;
    private String grade;

    public Enrollment(String id, String nim, String akt, String semester) {
        this.id = id;
        this.nim = nim;
        this.akt = akt;
        this.semester = semester;
        this.grade = "None"; 
    }

    public String getGrade() {
        return this.grade;
    }

    @Override
    public String toString() {
        return id + "|" + nim + "|" + akt + "|" + semester + "|" + grade;
    }
}
