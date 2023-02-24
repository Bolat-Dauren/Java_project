import java.sql.*;

public class AccountSearcher {


    // method for searching accounts by name and outputting results
    public void searchAccountByName(String accountName) {

        // PostgreSQL database connection details
        String DB_USERNAME = "postgres";
        String DB_PASSWORD = "qwe123";
        String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

        try {
            // connect to the database
            Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // create the SQL query to search the "account" column by name
            String sql = "SELECT account, mail, login, password FROM accounts WHERE account = ?";

            // prepare the statement and set the parameter value
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, accountName);

            // execute the query and process the results
            ResultSet rs = stmt.executeQuery();
            if(!rs.isBeforeFirst()) {
                System.out.println("Account not found in database.");
            }
            else{
                while (rs.next()) {
                    String account = rs.getString("account");
                    String mail = rs.getString("mail");
                    String login = rs.getString("login");
                    String password = rs.getString("password");
                    // output the result data in the desired format
                    System.out.format("|%-19s |%-19s |%-19s |%-19s |\n", "Account:", "Mail:", "Login:", "Password:");
                    for (int i = 1; i <= 4; i++) {
                        System.out.format("+--------------------");
                    }
                    System.out.println("+");
                    System.out.format("|%-19s |%-19s |%-19s |%-19s |\n", account, mail, login, password);
                    System.out.println("");
                }
            }

            // close the resources
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
