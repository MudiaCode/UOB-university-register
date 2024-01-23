import java.util.List;
import java.util.Scanner;

public class UniversityRegisterTester {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student(1, "John Doe", "Computer Science", "CS101", 85),
                new Student(2, "Jane Smith", "Mathematics", "MA201", 78),
                new Student(3, "Bob Johnson", "Physics", "PH301", 92),
                new Student(4, "Alice Brown", "Computer Science", "CS101", 88)
        );

        UniversityRegister universityRegister = new UniversityRegister(students);

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    testAddStudent(universityRegister);
                    break;
                case 2:
                    testRemoveStudentById(universityRegister);
                    break;
                case 3:
                    testQueryStudentsByName(universityRegister);
                    break;
                case 4:
                    testQueryStudentsByCourse(universityRegister);
                    break;
                case 5:
                    testQueryStudentsByModule(universityRegister);
                    break;
                case 6:
                    testGetStudentsOnModuleSortedDescending(universityRegister);
                    break;
                case 7:
                    testGetStudentsOnCourseWithNameMatching(universityRegister);
                    break;
                case 8:
                    testGetStudentsWithNameStartingWith(universityRegister);
                    break;
                case 9:
                    System.exit(0); // exit the program
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("===== University Register Menu =====");
        System.out.println("1. Add Student");
        System.out.println("2. Remove Student by ID");
        System.out.println("3. Query Students by Name");
        System.out.println("4. Query Students by Course");
        System.out.println("5. Query Students by Module");
        System.out.println("6. Get Students on Module Sorted Descending");
        System.out.println("7. Get Students on Course with Name Matching");
        System.out.println("8. Get Students with Name Starting With");
        System.out.println("9. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void testAddStudent(UniversityRegister universityRegister) {
        System.out.println("Enter student details:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Course: ");
        String course = scanner.nextLine();
        System.out.print("Module: ");
        String module = scanner.nextLine();
        System.out.print("Marks: ");
        int marks = scanner.nextInt();

        Student newStudent = new Student(id, name, course, module, marks);
        UniversityRegister updatedRegister = universityRegister.addStudent(newStudent);

        System.out.println("Student added successfully!");
        System.out.println("Updated student list:");
        updatedRegister.students().forEach(System.out::println);
    }

    private static void testRemoveStudentById(UniversityRegister universityRegister) {
        System.out.print("Enter student ID to remove: ");
        int studentId = scanner.nextInt();
        UniversityRegister updatedRegister = universityRegister.removeStudentById(studentId);

        System.out.println("Student removed successfully!");
        System.out.println("Updated student list:");
        updatedRegister.students().forEach(System.out::println);
    }

    private static void testQueryStudentsByName(UniversityRegister universityRegister) {
        System.out.print("Enter student name to query: ");
        scanner.nextLine(); // consume newline
        String name = scanner.nextLine();
        List<Student> result = universityRegister.queryStudentsByName(name);

        System.out.println("Query results:");
        result.forEach(System.out::println);
    }

    private static void testQueryStudentsByCourse(UniversityRegister universityRegister) {
        System.out.print("Enter course to query: ");
        scanner.nextLine(); // consume newline
        String course = scanner.nextLine();
        List<Student> result = universityRegister.queryStudentsByCourse(course);

        System.out.println("Query results:");
        result.forEach(System.out::println);
    }

    private static void testQueryStudentsByModule(UniversityRegister universityRegister) {
        System.out.print("Enter module to query: ");
        scanner.nextLine(); // consume newline
        String module = scanner.nextLine();
        List<Student> result = universityRegister.queryStudentsByModule(module);

        System.out.println("Query results:");
        result.forEach(System.out::println);
    }

    private static void testGetStudentsOnModuleSortedDescending(UniversityRegister universityRegister) {
        System.out.print("Enter module to query: ");
        scanner.nextLine(); // consume newline
        String module = scanner.nextLine();
        List<Student> result = universityRegister.getStudentsOnModuleSortedDescending(module);

        System.out.println("Query results:");
        result.forEach(System.out::println);
    }

    private static void testGetStudentsOnCourseWithNameMatching(UniversityRegister universityRegister) {
        System.out.print("Enter course to query: ");
        scanner.nextLine(); // consume newline
        String course = scanner.nextLine();
        System.out.print("Enter name to match: ");
        String text = scanner.nextLine();
        List<Student> result = universityRegister.getStudentsOnCourseWithNameMatching(course, text);

        System.out.println("Query results:");
        result.forEach(System.out::println);
    }

    private static void testGetStudentsWithNameStartingWith(UniversityRegister universityRegister) {
        System.out.print("Enter starting letter of the name: ");
        char letter = scanner.nextLine().charAt(0);
        List<Student> result = universityRegister.getStudentsWithNameStartingWith(letter);

        System.out.println("Query results:");
        result.forEach(System.out::println);
    }
}
