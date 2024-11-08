import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Student {
    int id;
    String name;
    int age;
    String grade;

    public Student(int id, String name, int age, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', age=" + age + ", grade='" + grade + "'}";
    }
}

public class StudentManagementSystem {
    private HashMap<Integer, Student> students = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    // Insert a new student
    public void insertStudent() {
    System.out.print("Enter ID: ");
    int id = scanner.nextInt();
    scanner.nextLine(); // Consume the newline left by nextInt()

    System.out.print("Enter Name: ");
    String name = scanner.nextLine(); // Use nextLine() to allow spaces in the name

    System.out.print("Enter Age: ");
    int age = scanner.nextInt();
    scanner.nextLine(); // Consume the newline left by nextInt()

    System.out.print("Enter Grade: ");
    String grade = scanner.nextLine(); // Use nextLine() for grade if it may contain spaces

    students.put(id, new Student(id, name, age, grade));
    System.out.println("Student added successfully.");
}


    // Delete a student by ID
    public void deleteStudent() {
        System.out.print("Enter ID of the student to delete: ");
        int id = scanner.nextInt();
        if (students.remove(id) != null) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Update a student by ID
    public void updateStudent() {
        System.out.print("Enter ID of the student to update: ");
        int id = scanner.nextInt();
        Student student = students.get(id);
        if (student != null) {
            System.out.print("Enter new Name: ");
            student.name = scanner.next();
            System.out.print("Enter new Age: ");
            student.age = scanner.nextInt();
            System.out.print("Enter new Grade: ");
            student.grade = scanner.next();
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Search for a student by ID
    public void searchStudent() {
        System.out.print("Enter ID of the student to search: ");
        int id = scanner.nextInt();
        Student student = students.get(id);
        if (student != null) {
            System.out.println("Student found: " + student);
        } else {
            System.out.println("Student not found.");
        }
    }

    // Display all students
    public void displayStudents() {
        System.out.println("Student List:");
        for (Map.Entry<Integer, Student> entry : students.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    // Sort students by ID (since HashMap doesn't keep order, we convert to list and sort)
    public void sortStudentsById() {
        students.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getValue()));
    }

    // Menu-driven program
    public void menu() {
        while (true) {
            System.out.println("\n1. Insert Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Update Student");
            System.out.println("4. Search Student");
            System.out.println("5. Display Students");
            System.out.println("6. Sort Students by ID");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    insertStudent();
                    break;
                case 2:
                    deleteStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    searchStudent();
                    break;
                case 5:
                    displayStudents();
                    break;
                case 6:
                    sortStudentsById();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.menu();
    }
}
