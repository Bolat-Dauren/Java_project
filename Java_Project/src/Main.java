import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "0000";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    Connection connection;
    AccountSearcher accountSearcher = new AccountSearcher();

    public Main() throws SQLException {
        connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }

    public static void main(String[] args) throws SQLException {
        try {
            Main main = new Main();
            main.run();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void run() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Show all accounts");
            System.out.println("2. Create a new account");
            System.out.println("3. Delete an account");
            System.out.println("4. Find an account by name");
            System.out.println("5. Exit");
            int command = scanner.nextInt();
            scanner.nextLine();

            switch (command) {
                case 1:
                    Statement st = connection.createStatement();
                    String query = "SELECT * FROM accounts ORDER BY account";
                    ResultSet result = st.executeQuery(query);
                    if(!result.isBeforeFirst()) {
                        System.out.println(" ");
                        System.out.println("Database is empty");
                        System.out.println(" ");
                        break;
                    }
                    System.out.println("");
                    // print column headers
                    for (int i = 1; i <= 4; i++) {
                        System.out.format("+--------------------");
                    }
                    System.out.println("+");

                    System.out.format("|%-19s |%-19s |%-19s |%-19s |\n", "Account:", "Mail:", "Login:", "Password:");

                    // print horizontal line
                    for (int i = 1; i <= 4; i++) {
                        System.out.format("+--------------------");
                    }
                    System.out.println("+");

                    // print data rows
                    while (result.next()) {
                        String account = result.getString("account");
                        String mail = result.getString("mail");
                        String login = result.getString("login");
                        String password = result.getString("password");

                        System.out.format("|%-19s |%-19s |%-19s |%-19s |\n", account, mail, login, password);

                        // print horizontal line
                        for (int i = 1; i <= 4; i++) {
                            System.out.format("+--------------------");
                        }
                        System.out.println("+");
                    }
                    System.out.println("");

                    break;

                case 2:
                    UserInput userInput = new UserInput(scanner);
                    Account newAccount = userInput.getAccountInfo();
                    String sql = "INSERT INTO accounts(account, mail, login, password) VALUES (?, ?, ?, ?)";
                    PreparedStatement statement = this.connection.prepareStatement(sql);
                    statement.setString(1, newAccount.getAccount());
                    statement.setString(2, newAccount.getMail());
                    statement.setString(3, newAccount.getLogin());
                    statement.setString(4, newAccount.getPassword());
                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println(" ");
                        System.out.println("A new account has been created.");
                        System.out.println(" ");
                        continue;
                    }

                case 3:
                    System.out.print("Enter account name to delete: ");
                    String accountToDelete = scanner.nextLine();
                    String deleteQuery = "DELETE FROM accounts WHERE account=?";
                    PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
                    deleteStatement.setString(1, accountToDelete);
                    int rowsDeleted = deleteStatement.executeUpdate();
                    if (rowsDeleted > 0) {
                        System.out.println(" ");
                        System.out.println("The account " + accountToDelete + " has been deleted.");
                        System.out.println(" ");
                    } else {
                        System.out.println(" ");
                        System.out.println("No account with name " + accountToDelete + " found.");
                        System.out.println(" ");
                    }
                    break;

                case 4:
                    System.out.println("Enter the name of account that you want to find: ");
                    String name = scanner.nextLine();
                    System.out.println("");
                    accountSearcher.searchAccountByName(name);
                    break;

                case 5:
                    System.exit(0);

                default:
                    System.err.println("Command not recognized");
            }
        }
    }
}