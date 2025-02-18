package academic.model;

public class Student {
    private String nim;
    private String name;
    private int akt;
    private String prodi;

    public Student(String nim, String name, int akt, String prodi) {
        this.nim = nim;
        this.name = name;
        this.akt = akt;
        this.prodi = prodi;
    }

    public String getNim() {
        return nim;
    }

    @Override
    public String toString() {
        return nim + "|" + name + "|" + akt + "|" + prodi;
    }
}