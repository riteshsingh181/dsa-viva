import java.util.ArrayList;
import java.util.Comparator;
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
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Insert a new student
    public void insertStudent() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter Name: ");
        String name = scanner.next();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        System.out.print("Enter Grade: ");
        String grade = scanner.next();
        students.add(new Student(id, name, age, grade));
        System.out.println("Student added successfully.");
    }

    // Delete a student by ID
    public void deleteStudent() {
        System.out.print("Enter ID of the student to delete: ");
        int id = scanner.nextInt();
        students.removeIf(student -> student.id == id);
        System.out.println("Student deleted successfully.");
    }

    // Update a student by ID
    public void updateStudent() {
        System.out.print("Enter ID of the student to update: ");
        int id = scanner.nextInt();
        for (Student student : students) {
            if (student.id == id) {
                System.out.print("Enter new Name: ");
                student.name = scanner.next();
                System.out.print("Enter new Age: ");
                student.age = scanner.nextInt();
                System.out.print("Enter new Grade: ");
                student.grade = scanner.next();
                System.out.println("Student updated successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Search for a student by ID
    public void searchStudent() {
        System.out.print("Enter ID of the student to search: ");
        int id = scanner.nextInt();
        for (Student student : students) {
            if (student.id == id) {
                System.out.println("Student found: " + student);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Display all students
    public void displayStudents() {
        System.out.println("Student List:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Sort students by a chosen attribute
    public void sortStudents() {
        System.out.print("Sort by (id/name/age/grade): ");
        String criteria = scanner.next();
        switch (criteria) {
            case "id":
                students.sort(Comparator.comparingInt(student -> student.id));
                break;
            case "name":
                students.sort(Comparator.comparing(student -> student.name));
                break;
            case "age":
                students.sort(Comparator.comparingInt(student -> student.age));
                break;
            case "grade":
                students.sort(Comparator.comparing(student -> student.grade));
                break;
            default:
                System.out.println("Invalid sort criteria.");
                return;
        }
        System.out.println("Students sorted by " + criteria + ".");
        displayStudents();
    }

    // Menu-driven program
    public void menu() {
        while (true) {
            System.out.println("\n1. Insert Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Update Student");
            System.out.println("4. Search Student");
            System.out.println("5. Display Students");
            System.out.println("6. Sort Students");
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
                    sortStudents();
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
