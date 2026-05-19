import java.util.Arrays;
import java.util.List;

public class Main {

    // Referințe către interfețele de Strategy
    private ExportStrategy exportStrategy;
    private ImportStrategy importStrategy; // <-- Asigură-te că ai linia asta!

    // Metodele de tip Setter pentru a schimba strategiile din mers
    public void setExportStrategy(ExportStrategy exportStrategy) {
        this.exportStrategy = exportStrategy;
    }

    public void setImportStrategy(ImportStrategy importStrategy) { // <-- Și metoda asta!
        this.importStrategy = importStrategy;
    }

    // Metoda care execută strategia de Export
    public void executaExport(List<Student> studenti) {
        if (exportStrategy != null) {
            exportStrategy.exportStudents(studenti);
        }
    }

    // Metoda care execută strategia de Import
    // Metoda generală care execută strategia de Import curentă
    public void executaImport() {
        if (importStrategy != null) {
            List<Student> studentiCititi = importStrategy.importStudents();

            // Am scos textul fix cu "Subpunctul D" ca să nu se mai amestece la rulare!
            System.out.println("\n--- LISTA DE STUDENȚI RECONSTRUITĂ ÎN MEMORIE ---");
            for (Student s : studentiCititi) {
                System.out.println(s);
            }
            System.out.println("------------------------------------------------");
        } else {
            System.out.println("Eroare: Nu a fost selectată nicio strategie de import!");
        }
    }

    public static void main(String[] args) {
        // Lista inițială
        List<Student> studenti = Arrays.asList(
                new Student(1025, "Andrei", "Popa", "ISM14/2", 8.70),
                new Student(1024, "Ioan", "Mihalcea", "ISM14/1", 10.0)
        );

        Main aplicatie = new Main();

        // Subpunctul A
        // aplicatie.setExportStrategy(new StudentiInConsola());

        // Subpunctul B
        // aplicatie.setExportStrategy(new StudentiInFisierText());

        // Subpunctul C
        // aplicatie.setExportStrategy(new StudentiInFisierXlsx());
        // aplicatie.executaExport(studenti);

        // Subpunctul D:
        // aplicatie.setImportStrategy(new StudentiDinFisierText());

        // Subpunctul E:
        aplicatie.setImportStrategy(new StudentiDinFisierXlsx());
        aplicatie.executaImport();
    }
}