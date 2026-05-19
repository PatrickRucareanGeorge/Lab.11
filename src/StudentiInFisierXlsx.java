import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class StudentiInFisierXlsx implements ExportStrategy {

    @Override
    public void exportStudents(List<Student> studenti) {
        // Folosim extensia .csv sau .xlsx formatat prin delimitatori
        String numeFisier = "studenti.csv";

        try (FileWriter fileWriter = new FileWriter(numeFisier);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {

            // Scrieți capul de tabel (numele coloanelor). Folosim virgulă ca separator.
            printWriter.println("ID,Nume,Prenume,Grupa,Medie");

            // Parcurgem lista și scriem datele fiecărui student pe câte o linie
            for (Student s : studenti) {
                printWriter.println(
                        s.getId() + "," +
                                s.getNume() + "," +
                                s.getPrenume() + "," +
                                s.getGrupa() + "," +
                                s.getMedie()
                );
            }

            System.out.println("Succes: Lista de studenți a fost exportată în format tabelar: " + numeFisier);

        } catch (IOException e) {
            System.out.println("Eroare la scrierea în fișierul Excel/CSV: " + e.getMessage());
        }
    }
}