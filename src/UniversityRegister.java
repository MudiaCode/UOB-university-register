import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public record UniversityRegister(List<Student> students) {

    public UniversityRegister(List<Student> students) {
        this.students = List.copyOf(students);
    }

    @Override
    public List<Student> students() {
        return List.copyOf(students);
    }

    public UniversityRegister addStudent(Student student) {
        List<Student> newStudents = new ArrayList<>(students);
        newStudents.add(student);
        return new UniversityRegister(newStudents);
    }

    public UniversityRegister removeStudentById(int studentId) {
        List<Student> newStudents = students.stream()
                .filter(student -> student.id() != studentId)
                .collect(Collectors.toList());
        return new UniversityRegister(newStudents);
    }

    public List<Student> queryStudentsByName(String name) {
        return students.stream()
                .filter(student -> student.name().equals(name))
                .collect(Collectors.toList());
    }

    public List<Student> queryStudentsByCourse(String course) {
        return students.stream()
                .filter(student -> student.course().equals(course))
                .collect(Collectors.toList());
    }

    public List<Student> queryStudentsByModule(String module) {
        return students.stream()
                .filter(student -> student.module().equals(module))
                .collect(Collectors.toList());
    }

    public List<Student> getStudentsOnModuleSortedDescending(String module) {
        return students.stream()
                .filter(student -> student.module().equals(module))
                .sorted((s1, s2) -> Integer.compare(s2.marks(), s1.marks()))
                .collect(Collectors.toList());
    }

    public List<Student> getStudentsOnCourseWithNameMatching(String course, String text) {
        return students.stream()
                .filter(student -> student.course().equals(course) && student.name().contains(text))
                .collect(Collectors.toList());
    }

    public List<Student> getStudentsWithNameStartingWith(char letter) {
        return students.stream()
                .filter(student -> student.name().toLowerCase().startsWith(String.valueOf(letter).toLowerCase()))
                .collect(Collectors.toList());
    }
}
