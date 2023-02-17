
import java.sql.*;

import static java.lang.System.*;

public class PasswordChecker {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "0000";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static Connection connection;

    public PasswordChecker() throws SQLException {
        connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }

    public static void check() throws SQLException {
        Statement st = connection.createStatement();
        String DB_ACCOUNT = "select * from accounts order by Accounts";
        ResultSet result = st.executeQuery(DB_ACCOUNT);
        if (isSimplePassword(result.getString("Password"))) {
            out.println("Your password is too simple. Please choose a stronger password.");
        } else {
            out.println("Your password is strong.");
        }
    }

    private static boolean isSimplePassword(String password) {
        // Check if the password is too short
        if (password.length() < 8) {
            return true;
        }

        // Check if the password contains only lowercase letters
        if (password.matches("[a-z]+")) {
            return true;
        }

        // Check if the password contains only uppercase letters
        if (password.matches("[A-Z]+")) {
            return true;
        }

        // Check if the password contains only digits
        if (password.matches("[0-9]+")) {
            return true;
        }

        // Check if the password contains only special characters
        if (password.matches("[^a-zA-Z0-9]+")) {
            return true;
        }

        return false;
    }
}
