import java.util.List;
import java.util.Scanner;

public class UniversityRegisterTester {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student(1, "John Doe", "Computer Science", "CS101", 85),
                new Student(2, "Jane Smith", "Mathematics", "MA201", 78),
                new Student(3, "Bob Johnson", "Physics", "PH301", 92)
        );

        UniversityRegister universityRegister = new UniversityRegister(students);

        while (true) {
            displayMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    addStudent(universityRegister);
                    break;
                case 2:
                    removeStudentById(universityRegister);
                    break;
                case 3:
                    queryStudentsByName(universityRegister);
                    break;
                case 4:
                    queryStudentsByCourse(universityRegister);
                    break;
                case 5:
                    queryStudentsByModule(universityRegister);
                    break;
                case 6:
                    getStudentsOnModuleSortedDescending(universityRegister);
                    break;
                case 7:
                    getStudentsOnCourseWithNameMatching(universityRegister);
                    break;
                case 8:
                    getStudentsWithNameStartingWith(universityRegister);
                    break;
                case 9:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nUniversity Register Menu:");
        System.out.println("1. Add a new student");
        System.out.println("2. Remove an existing student");
        System.out.println("3. Query existing students by name");
        System.out.println("4. Query existing students by course");
        System.out.println("5. Query existing students by module");
        System.out.println("6. Get all students on a module sorted in descending order of marks");
        System.out.println("7. Get all students on a course whose names match a given text");
        System.out.println("8. Get all students whose names begin with a given letter");
        System.out.println("9. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();  // Consume the invalid input
        }
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character
        return choice;
    }

    private static void addStudent(UniversityRegister universityRegister) {
        System.out.print("Enter student ID: ");
        int id = getIntInput();
        System.out.print("Enter student name: ");
        String name = getStringInput();
        System.out.print("Enter student course: ");
        String course = getStringInput();
        System.out.print("Enter student module: ");
        String module = getStringInput();
        System.out.print("Enter student marks: ");
        int marks = getIntInput();

        Student newStudent = new Student(id, name, course, module, marks);
        universityRegister = universityRegister.addStudent(newStudent);

        System.out.println("Student added successfully!");
        System.out.println("Updated student list: ");
        universityRegister.students().forEach(System.out::println);
    }

    private static void removeStudentById(UniversityRegister universityRegister) {
        System.out.print("Enter student ID to remove: ");
        int idToRemove = getIntInput();

        universityRegister = universityRegister.removeStudentById(idToRemove);

        System.out.println("Student removed successfully!");
        System.out.println("Updated student list: ");
        universityRegister.students().forEach(System.out::println);
    }

    private static void queryStudentsByName(UniversityRegister universityRegister) {
        System.out.print("Enter student name to query: ");
        String nameToQuery = getStringInput();

        List<Student> result = universityRegister.queryStudentsByName(nameToQuery);

        System.out.println("Query results:");
        result.forEach(System.out::println);
    }

    private static void queryStudentsByCourse(UniversityRegister universityRegister) {
        System.out.print("Enter course to query: ");
        String courseToQuery = getStringInput();

        List<Student> result = universityRegister.queryStudentsByCourse(courseToQuery);

        System.out.println("Query results:");
        result.forEach(System.out::println);
    }

    private static void queryStudentsByModule(UniversityRegister universityRegister) {
        System.out.print("Enter module to query: ");
        String moduleToQuery = getStringInput();

        List<Student> result = universityRegister.queryStudentsByModule(moduleToQuery);

        System.out.println("Query results:");
        result.forEach(System.out::println);
    }

    private static void getStudentsOnModuleSortedDescending(UniversityRegister universityRegister) {
        System.out.print("Enter module to query: ");
        String moduleToQuery = getStringInput();

        List<Student> result = universityRegister.getStudentsOnModuleSortedDescending(moduleToQuery);

        System.out.println("Query results (sorted in descending order of marks):");
        result.forEach(System.out::println);
    }

    private static void getStudentsOnCourseWithNameMatching(UniversityRegister universityRegister) {
        System.out.print("Enter course to query: ");
        String courseToQuery = getStringInput();
        System.out.print("Enter text to match in names: ");
        String textToMatch = getStringInput();

        List<Student> result = universityRegister.getStudentsOnCourseWithNameMatching(courseToQuery, textToMatch);

        System.out.println("Query results:");
        result.forEach(System.out::println);
    }

    private static void getStudentsWithNameStartingWith(UniversityRegister universityRegister) {
        System.out.print("Enter letter to match at the beginning of names: ");
        char letterToMatch = getStringInput().charAt(0);

        List<Student> result = universityRegister.getStudentsWithNameStartingWith(letterToMatch);

        System.out.println("Query results:");
        result.forEach(System.out::println);
    }

    private static int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();  // Consume the invalid input
        }
        int input = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character
        return input;
    }

    private static String getStringInput() {
        String input = scanner.nextLine();
        return input.trim();
    }
}
