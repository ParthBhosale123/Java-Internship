import java.util.*;

/**
 * Student class with encapsulation
 */
class Student {
    private int id;
    private String name;
    private double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return String.format("%-5d %-15s %-5.2f", id, name, marks);
    }
}

/**
 * Student Management System (CRUD)
 */
public class StudentManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== Student Record Management =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Sort Students");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> searchStudent();
                case 6 -> sortStudents();
                case 7 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice, try again.");
            }
        } while (choice != 7);
    }

    // Add student
    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();
        students.add(new Student(id, name, marks));
        System.out.println("✅ Student added successfully!");
    }

    // View students
    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("⚠ No records found!");
            return;
        }
        System.out.printf("\n%-5s %-15s %-5s\n", "ID", "Name", "Marks");
        System.out.println("---------------------------------");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    // Update student
    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        for (Student s : students) {
            if (s.getId() == id) {
                sc.nextLine();
                System.out.print("Enter new name: ");
                s.setName(sc.nextLine());
                System.out.print("Enter new marks: ");
                s.setMarks(sc.nextDouble());
                System.out.println("✅ Record updated!");
                return;
            }
        }
        System.out.println("❌ Student not found!");
    }

    // Delete student
    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();
        Iterator<Student> itr = students.iterator();
        while (itr.hasNext()) {
            if (itr.next().getId() == id) {
                itr.remove();
                System.out.println("🗑 Student deleted successfully!");
                return;
            }
        }
        System.out.println("❌ Student not found!");
    }

    // Search student
    private static void searchStudent() {
        sc.nextLine();
        System.out.print("Enter name or ID to search: ");
        String input = sc.nextLine();

        boolean found = false;
        for (Student s : students) {
            if (String.valueOf(s.getId()).equals(input) || s.getName().equalsIgnoreCase(input)) {
                System.out.println("✅ Found: " + s);
                found = true;
            }
        }
        if (!found)
            System.out.println("❌ No student found!");
    }

    // Sort students
    private static void sortStudents() {
        if (students.isEmpty()) {
            System.out.println("⚠ No records to sort!");
            return;
        }
        System.out.println("Sort by: 1. Name  2. Marks");
        int opt = sc.nextInt();
        if (opt == 1) {
            students.sort(Comparator.comparing(Student::getName));
            System.out.println("✅ Sorted by Name!");
        } else if (opt == 2) {
            students.sort(Comparator.comparingDouble(Student::getMarks).reversed());
            System.out.println("✅ Sorted by Marks!");
        } else {
            System.out.println("❌ Invalid option!");
        }
        viewStudents();
    }
}
