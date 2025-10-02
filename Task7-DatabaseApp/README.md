# 🗂️ Task 7: Java JDBC – Employee Database App

A **Java CLI application** that connects to a MySQL database and performs **CRUD operations** using JDBC.
This project is part of the **Java Developer Internship – Task 7**.

---

## 🚀 Features

- ➕ **Add Employee** – Insert a new employee record.
- 👀 **View Employees** – Display all employee records from the database.
- ✏️ **Update Employee** – Modify an employee’s details using ID.
- ❌ **Delete Employee** – Remove an employee record by ID.
- 🔒 **Exit** – Close the database connection safely.

---

## 🛠 Tech Stack

- **Java (JDK 21+)**
- **MySQL**
- **JDBC (Java Database Connectivity)**
- **VS Code (or IntelliJ/Eclipse)**

---

## 🗄️ Database Setup (MySQL)

Run the following SQL commands before starting the app:

```sql
CREATE DATABASE employee_db;

USE employee_db;

CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    department VARCHAR(100),
    salary DOUBLE
);
```

---

## ⚙️ Configuration

This project uses a `config.properties` file (not included in GitHub for security).
You must create it in the project root (`Task7-DatabaseApp/`).

**config.properties:**

```properties
db.url=jdbc:mysql://localhost:3306/employee_db
db.user=root
db.password=YOUR_PASSWORD
```

⚠️ Note: `config.properties` is excluded via `.gitignore`, so your database password will not be exposed.

You may find an example template in `config.properties.example`.

---

## ⚙️ Setup MySQL JDBC Driver in VS Code

### Option 1: GUI Method ✅

1. Open **Java Projects** tab in VS Code.
2. Expand **Referenced Libraries**.
3. Click the ➕ button and select your JAR:
   `Task7-DatabaseApp/lib/mysql-connector-j-9.4.0.jar`

### Option 2: settings.json

Inside `.vscode/settings.json`:

```json
{
  "java.project.referencedLibraries": ["lib/mysql-connector-j-9.4.0.jar"]
}
```

Then reload Java Language Server in VS Code.

---

## ▶️ Run Program

1. Navigate to project folder:

   ```bash
   cd Java-Internship/Task7-DatabaseApp
   ```

2. Compile:

   ```bash
   javac -cp .;lib/mysql-connector-j-9.4.0.jar EmployeeApp.java
   ```

3. Run:

   ```bash
   java -cp .;lib/mysql-connector-j-9.4.0.jar EmployeeApp
   ```

(On Linux/Mac replace `;` with `:`)

---

## 📌 Example Menu

```
=== Employee Database Menu ===
1. Add Employee
2. View Employees
3. Update Employee
4. Delete Employee
5. Exit
Enter choice:
```

---

## 🧠 Key Concepts Practiced

- Secure configuration with `config.properties`
- JDBC Connectivity
- CRUD with PreparedStatement
- Handling ResultSet
- Exception Handling (SQL + Java)
- Preventing SQL Injection with PreparedStatement
- Resource Management (closing connections)
