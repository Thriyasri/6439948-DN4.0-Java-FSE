import java.sql.*;

public class StudentApp {

    static class Student {
        private int id;
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Student(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public int getAge() { return age; }
    }

    // DAO class
    static class StudentDAO {
        private Connection conn;

        public StudentDAO() {
            try {
                conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb",
                    "root",
                    "your_password" // Change this to your actual password
                );
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void insertStudent(Student student) {
            String sql = "INSERT INTO students (name, age) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, student.getName());
                stmt.setInt(2, student.getAge());
                stmt.executeUpdate();
                System.out.println("Student inserted.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void updateStudent(Student student) {
            String sql = "UPDATE students SET name = ?, age = ? WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, student.getName());
                stmt.setInt(2, student.getAge());
                stmt.setInt(3, student.getId());
                int rowsUpdated = stmt.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Student updated.");
                } else {
                    System.out.println("No student found with ID " + student.getId());
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        Student newStudent = new Student("Alice", 20);
        dao.insertStudent(newStudent);

        Student updatedStudent = new Student(1, "Alice Smith", 21);
        dao.updateStudent(updatedStudent);
    }
}
