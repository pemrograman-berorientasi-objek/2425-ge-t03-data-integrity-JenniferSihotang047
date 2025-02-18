package academic.model;

/**
 * @autors 12S23040 Diana Manurung
 * @autors 12S23047 Jennifer Sihotang
 */

public class Student {
    private String nim;
    private String name;
    private int akt;
    private String prodi;

    public Student(String _nim, String _name, int _akt, String _prodi) {
        this.nim = _nim;
        this.name = _name;
        this.akt = _akt;
        this.prodi = _prodi;
    }

    public String getNim() {
        return this.nim;
    }

    public String getName() {
        return this.name;
    }

    public int getAkt() {
        return this.akt;
    }

    public String getProdi() {
        return this.prodi;
    }

    @Override
    public String toString() {
        return this.nim + "|" + this.name + "|" + this.akt + "|" + this.prodi;
    }
}