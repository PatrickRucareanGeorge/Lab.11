import java.util.List;


public class StudentiInConsola implements ExportStrategy {

    @Override
    public void exportStudents(List<Student> studenti) {
        System.out.println("=======================================================");
        System.out.println("       LISTA DE STUDENȚI (AFIȘARE ÎN CONSOLĂ)        ");
        System.out.println("=======================================================");


        for (Student s : studenti) {

            System.out.println(s);
        }

        System.out.println("=======================================================");
    }
}