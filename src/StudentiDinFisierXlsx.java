import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentiDinFisierXlsx implements ImportStrategy {

    @Override
    public List<Student> importStudents() {
        List<Student> studentiImportati = new ArrayList<>();
        String numeFisier = "studenti.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(numeFisier))) {
            String linie;
            boolean estePrimaLinie = true;

            while ((linie = br.readLine()) != null) {

                if (estePrimaLinie) {
                    estePrimaLinie = false;
                    continue;
                }


                if (linie.trim().isEmpty()) {
                    continue;
                }


                String[] date = linie.split(",");


                if (date.length == 5) {
                    int id = Integer.parseInt(date[0].trim());
                    String nume = date[1].trim();
                    String prenume = date[2].trim();
                    String grupa = date[3].trim();
                    double medie = Double.parseDouble(date[4].trim());


                    studentiImportati.add(new Student(id, prenume, nume, grupa, medie));
                }
            }
            System.out.println("Succes: S-au citit " + studentiImportati.size() + " studenți din formatul Excel/CSV.");

        } catch (IOException e) {
            System.out.println("Eroare la citirea fișierului tabelar: " + e.getMessage());
        }

        return studentiImportati;
    }
}