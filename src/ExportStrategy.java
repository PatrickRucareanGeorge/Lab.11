import java.util.List;

public interface ExportStrategy {
    // Orice clasă care vrea să fie o "strategie de export" trebuie să implementeze această metodă
    void exportStudents(List<Student> studenti);
}