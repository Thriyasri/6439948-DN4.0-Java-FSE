import java.sql.*;

public class TransactionExample {

    public static void transferMoney(int fromAccount, int toAccount, double amount) {
        String url = "jdbc:mysql://localhost:3306/bankdb";
        String user = "root";
        String password = "your_password"; // Replace with your MySQL password

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            conn.setAutoCommit(false); // Start transaction

            try (
                PreparedStatement debitStmt = conn.prepareStatement(
                    "UPDATE accounts SET balance = balance - ? WHERE id = ?");
                PreparedStatement creditStmt = conn.prepareStatement(
                    "UPDATE accounts SET balance = balance + ? WHERE id = ?")
            ) {
                debitStmt.setDouble(1, amount);
                debitStmt.setInt(2, fromAccount);
                debitStmt.executeUpdate();

                creditStmt.setDouble(1, amount);
                creditStmt.setInt(2, toAccount);
                creditStmt.executeUpdate();

                conn.commit(); // All good, commit
                System.out.println("Transfer successful. " + amount + " transferred from Account " + fromAccount + " to Account " + toAccount);

            } catch (SQLException e) {
                conn.rollback(); // Something went wrong, rollback
                System.out.println("Transfer failed. Rolling back.");
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        transferMoney(1, 2, 200.0); // Transfer 200 from Alice (ID 1) to Bob (ID 2)
    }
}
