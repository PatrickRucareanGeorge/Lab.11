import java.util.Arrays;
import java.util.List;

public class Main {

    // Referință către strategia de export curentă
    private ExportStrategy exportStrategy;

    // Metodă care ne permite să schimbăm strategia la rulare (Runtime)
    public void setExportStrategy(ExportStrategy exportStrategy) {
        this.exportStrategy = exportStrategy;
    }

    // Metodă care execută strategia selectată
    public void executaExport(List<Student> studenti) {
        if (exportStrategy != null) {
            exportStrategy.exportStudents(studenti);
        } else {
            System.out.println("Eroare: Nu a fost selectată nicio strategie de export!");
        }
    }

    static void main() {
        // Lista de studenți extrasă exact din cerința ta de laborator
        List<Student> studenti = Arrays.asList(
                new Student(1025, "Andrei", "Popa", "ISM14/2", 8.70),
                new Student(1024, "Ioan", "Mihalcea", "ISM14/1", 10.0),
                new Student(1026, "Anamaria", "Prodan", "TI131/1", 8.90),
                new Student(1029, "Bianca", "Popescu", "TI131/1", 10.0),
                new Student(1029, "Maria", "Pana", "TI131/2", 4.10),
                new Student(1029, "Gabriela", "Mohanu", "TI131/2", 7.33),
                new Student(1029, "Marius", "Nasta", "TI131/2", 3.20),
                new Student(1029, "Marius", "Nasta", "TI131/1", 5.12),
                new Student(1029, "Andrei", "Dobrescu", "TI131/2", 2.22)
        );

        Main aplicatie = new Main();

        // A
        /*aplicatie.setExportStrategy(new StudentiInConsola());
        aplicatie.executaExport(studenti);*/

        //B
        aplicatie.setExportStrategy(new StudentiInFIsierTxt());
        aplicatie.executaExport(studenti);
    }
}