import java.util.List;

// "implements ExportStrategy" înseamnă că această clasă respectă contractul interfeței noastre
public class StudentiInConsola implements ExportStrategy {

    @Override
    public void exportStudents(List<Student> studenti) {
        System.out.println("=======================================================");
        System.out.println("       LISTA DE STUDENȚI (AFIȘARE ÎN CONSOLĂ)        ");
        System.out.println("=======================================================");

        // Parcurgem lista de studenți folosind un for-each
        for (Student s : studenti) {
            // Folosim metoda s.toString() pe care am definit-o deja în clasa Student
            System.out.println(s);
        }

        System.out.println("=======================================================");
    }
}