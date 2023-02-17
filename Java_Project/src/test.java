import java.sql.*;

public class test {
    public static void main(String[] args) {
        // Take input from user for site, mail, login, and password
        String site = getInput("Site");
        String mail = getInput("Mail");
        String login = getInput("Login");
        String password = getInput("Password");

        // Connect to the PostgreSQL database
        Connection conn = null;
        String url = "jdbc:postgresql://localhost/testdb";
        String user = "postgres";
        String password_db = "postgres";
        try {
            conn = DriverManager.getConnection(url, user, password_db);
            System.out.println("Connected to the PostgreSQL server successfully.");

            // Insert the user inputs into the database
            String sql = "INSERT INTO user_data (site, mail, login, password) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, site);
            statement.setString(2, mail);
            statement.setString(3, login);
            statement.setString(4, password);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user data has been inserted successfully.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    System.out.println("Database connection closed.");
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    // Method to get input from user
    public static String getInput(String prompt) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }
}