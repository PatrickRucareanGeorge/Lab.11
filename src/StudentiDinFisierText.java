import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class StudentiDinFisierText implements ImportStrategy {

    @Override
    public List<Student> importStudents() {
        List<Student> studentiImportati = new ArrayList<>();
        String numeFisier = "studenti.txt";


        try (BufferedReader br = new BufferedReader(new FileReader(numeFisier))) {
            String linie;

            while ((linie = br.readLine()) != null) {

                if (linie.startsWith("==") || linie.trim().isEmpty() || linie.contains("EXPORT")) {
                    continue;
                }


                try {

                    String dateCurate = linie.substring(linie.indexOf("{") + 1, linie.indexOf("}"));

                    String[] atribute = dateCurate.split(", ");

                    int id = Integer.parseInt(atribute[0].split("=")[1]);
                    String nume = atribute[1].split("=")[1].replace("'", "");
                    String prenume = atribute[2].split("=")[1].replace("'", "");
                    String grupa = atribute[3].split("=")[1].replace("'", "");
                    double medie = Double.parseDouble(atribute[4].split("=")[1]);

                    studentiImportati.add(new Student(id, prenume, nume, grupa, medie));
                } catch (Exception e) {
                    System.out.println("Linie ignorată (format invalid): " + linie);
                }
            }
            System.out.println("Succes: S-au citit " + studentiImportati.size() + " studenți din " + numeFisier);

        } catch (IOException e) {
            System.out.println("Eroare la deschiderea/citirea fișierului text: " + e.getMessage());
        }

        return ArrayToReturnOrPrint(studentiImportati);
    }

    private List<Student> ArrayToReturnOrPrint(List<Student> lista) {
        return lista;
    }
}