public class Student {
    private int id;
    private String prenume;
    private String nume;
    private String grupa;
    private double medie;


    public Student(int id, String prenume, String nume, String grupa, double medie) {
        this.id = id;
        this.prenume = prenume;
        this.nume = nume;
        this.grupa = grupa;
        this.medie = medie;
    }


    public int getId() { return id; }
    public String getPrenume() { return prenume; }
    public String getNume() { return nume; }
    public String getGrupa() { return grupa; }
    public double getMedie() { return medie; }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", grupa='" + grupa + '\'' +
                ", medie=" + medie +
                '}';
    }
}