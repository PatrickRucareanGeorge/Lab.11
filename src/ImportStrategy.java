import java.util.List;

public interface ImportStrategy {
    // Orice clasă care vrea să fie o "strategie de citire/import" trebuie să implementeze această metodă
    // Ea nu primește nimic ca parametru, dar returnează o Listă plină cu obiecte de tip Student
    List<Student> importStudents();
}