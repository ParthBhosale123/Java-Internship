import java.sql.*;
import java.util.Scanner;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class EmployeeApp {
    private String URL;
    private String USER;
    private String PASSWORD;

    private Connection conn;
    private Scanner sc;

    public EmployeeApp() {
        try {
            // Load DB credentials from config.properties
            Properties props = new Properties();
            props.load(new FileInputStream("Task7-DatabaseApp/config.properties"));

            URL = props.getProperty("db.url");
            USER = props.getProperty("db.user");
            PASSWORD = props.getProperty("db.password");

            // Load MySQL Driver explicitly (good practice)
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            sc = new Scanner(System.in);
            System.out.println("✅ Connected to Database Successfully!");
        } catch (IOException e) {
            System.err.println("❌ Could not load config.properties file.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("❌ Database connection failed.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("❌ MySQL Driver not found. Did you add the JAR to classpath?");
            e.printStackTrace();
        }
    }

    public void addEmployee() throws SQLException {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Department: ");
        String dept = sc.nextLine();
        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();
        sc.nextLine(); // consume newline

        String sql = "INSERT INTO employees (name, department, salary) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, dept);
        ps.setDouble(3, salary);
        ps.executeUpdate();

        System.out.println("✅ Employee added successfully!");
    }

    public void viewEmployees() throws SQLException {
        String sql = "SELECT * FROM employees";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        System.out.println("\n--- Employee Records ---");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("department") + " | " +
                    rs.getDouble("salary"));
        }
    }

    public void updateEmployee() throws SQLException {
        System.out.print("Enter Employee ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New Name: ");
        String name = sc.nextLine();
        System.out.print("Enter New Department: ");
        String dept = sc.nextLine();
        System.out.print("Enter New Salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        String sql = "UPDATE employees SET name=?, department=?, salary=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, dept);
        ps.setDouble(3, salary);
        ps.setInt(4, id);
        ps.executeUpdate();

        System.out.println("✅ Employee updated successfully!");
    }

    public void deleteEmployee() throws SQLException {
        System.out.print("Enter Employee ID to Delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        String sql = "DELETE FROM employees WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();

        System.out.println("✅ Employee deleted successfully!");
    }

    public void close() {
        try {
            if (conn != null)
                conn.close();
            if (sc != null)
                sc.close();
            System.out.println("🔒 Connection closed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        while (true) {
            System.out.println("\n=== Employee Database Menu ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1 -> addEmployee();
                    case 2 -> viewEmployees();
                    case 3 -> updateEmployee();
                    case 4 -> deleteEmployee();
                    case 5 -> {
                        close();
                        return;
                    }
                    default -> System.out.println("❌ Invalid choice.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        EmployeeApp app = new EmployeeApp();
        app.start();
    }
}
