import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class StudentiInFIsierTxt implements ExportStrategy {

    @Override
    public void exportStudents(List<Student> studenti) {
        String numeFisier = "studenti.txt";

        // Folosim try-with-resources pentru a închide automat fișierul după scriere
        try (FileWriter fileWriter = new FileWriter(numeFisier);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {

            printWriter.println("=======================================================");
            printWriter.println("       LISTA DE STUDENȚI (EXPORT FIȘIER TEXT)        ");
            printWriter.println("=======================================================");

            for (Student s : studenti) {
                printWriter.println(s);
            }

            printWriter.println("=======================================================");
            System.out.println("Succes: Lista de studenți a fost exportată în " + numeFisier);

        } catch (IOException e) {
            System.out.println("Eroare la scrierea în fișierul text: " + e.getMessage());
        }
    }
}