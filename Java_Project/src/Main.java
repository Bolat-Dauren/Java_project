//import java.sql.*;
//import java.util.Scanner;
//
//public class Main {
//
//    private static final String DB_USERNAME = "postgres";
//    private static final String DB_PASSWORD = "0000";
//    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
//
//    public static void main(String[] args) throws Exception {
//        Scanner scanner = new Scanner(System.in);
//        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
//        while (true) {
//            System.out.println(" ");
//            System.out.println("1. Показать список всех задач");
//            System.out.println("2. Выполнить задачу");
//            System.out.println("3. Создать задачу");
//            System.out.println("4. Выйти");
//            System.out.println(" ");
//
//            int command = scanner.nextInt();
//
//            switch (command) {
//                case 1:
//
//                    Statement st = connection.createStatement();
//                    String DB_USER_ID = "select * from task1 order by id";
//                    ResultSet result = st.executeQuery(DB_USER_ID);
//
//                    System.out.println(" ");
//
//                    while (result.next()) {
//                        System.out.println(result.getInt("id") + "   |   " + result.getString("name") + "   |   " + result.getString("state") + "   |   ");
//                    }
//                    System.out.println(" ");
//                    break;
//
//                case 2:
//
//                    String sql = "update task1 set state = 'Done' where id = ?";
//                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
//                    System.out.println(" ");
//                    System.out.println("Введите идентификатор задачи: ");
//                    System.out.println(" ");
//                    int TASK_ID = scanner.nextInt();
//                    preparedStatement.setInt(1, TASK_ID);
//                    preparedStatement.executeUpdate();
//                    break;
//
//                case 3:
//
//                    String sql1 = "insert into task1(name, state) values (?, 'IN_PROCESS')";
//                    PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
//                    System.out.println(" ");
//                    System.out.println("Введите название задачи: ");
//                    System.out.println(" ");
//                    String TASK_NAME = scanner.next();
//                    preparedStatement1.setString(1, TASK_NAME);
//                    preparedStatement1.executeUpdate();
//                    break;
//
//                case 4:
//                    System.exit(0);
//
//                default:
//                    System.err.println("Команда не распознана");
//            }
//        }
//    }
//}






import java.sql.*;
import java.util.Scanner;

import static java.lang.System.*;

public class Main {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "0000";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    Connection connection;

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
        PasswordChecker.check();
    }

    public void run() throws SQLException {
        Scanner scanner = new Scanner(in);
        while (true) {
            out.println(" ");
            out.println("1. Показать список всех аккаунтов");
            out.println("2. Создать");
            out.println("3. Выйти");
            out.println(" ");

            int command = scanner.nextInt();

            switch (command) {
                case 1:
                    Statement st = connection.createStatement();
                    String DB_ACCOUNT = "select * from accounts order by Accounts";
                    ResultSet result = st.executeQuery(DB_ACCOUNT);

                    out.println(" ");

                    while (result.next()) {
                        out.println(result.getString("Account") + "   |   " + result.getString("Mail") + "   |   " + result.getString("Login") + "   |   " + result.getString("Password"));
                    }
                    out.println(" ");
                    break;

                case 2:
                    // Take input from user for site, mail, login, and password
                    UserInput userInput = new UserInput(scanner);
                    Account newAccount = userInput.getAccountInfo();

                    // Insert the user inputs into the database
                    String sql = "INSERT INTO accounts(account, mail, login, password) VALUES (?, ?, ?, ?)";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, newAccount.getAccount());
                    statement.setString(2, newAccount.getMail());
                    statement.setString(3, newAccount.getLogin());
                    statement.setString(4, newAccount.getPassword());
                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        out.println("A new user data has been inserted successfully.");
                    }
                    break;

                case 3:
                    exit(0);

                default:
                    err.println("Команда не распознана");
            }
        }
    }
}


//import java.sql.*;
//import java.util.Scanner;
//
//public class Main {
//    private static final String DB_USERNAME = "postgres";
//    private static final String DB_PASSWORD = "0000";
//    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
//    Connection connection;
//
//    public Main() throws SQLException {
//        connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
//    }
//
//    public static void main(String[] args) {
//        try {
//            Main main = new Main();
//            main.run();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void run() throws SQLException {
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            System.out.println(" ");
//            System.out.println("1. Показать список всех аккаунтов");
//            System.out.println("2. Создать");
//            System.out.println("3. Выйти");
//            System.out.println(" ");
//
//            int command = scanner.nextInt();
//
//            switch (command) {
//                case 1:
//                    Statement st = connection.createStatement();
//                    String DB_ACCOUNT = "select * from accounts order by Accounts";
//                    ResultSet result = st.executeQuery(DB_ACCOUNT);
//
//                    System.out.println(" ");
//
//                    while (result.next()) {
//                        System.out.println(result.getString("Account") + "   |   " + result.getString("Mail") + "   |   " + result.getString("Login") + "   |   " + result.getString("Password"));
//                    }
//                    System.out.println(" ");
//                    break;
//
//                case 2:
//                    // Take input from user for site, mail, login, and password
//                    String account = getInput("Account");
//                    String mail = getInput("Mail");
//                    String login = getInput("Login");
//                    String password = getInput("Password");
//
//                    // Insert the user inputs into the database
//                    String sql = "INSERT INTO accounts (account, mail, login, password) VALUES (?, ?, ?, ?)";
//                    PreparedStatement statement = connection.prepareStatement(sql);
//                    statement.setString(1, account);
//                    statement.setString(2, mail);
//                    statement.setString(3, login);
//                    statement.setString(4, password);
//                    int rowsInserted = statement.executeUpdate();
//                    if (rowsInserted > 0) {
//                        System.out.println("A new user data has been inserted successfully.");
//                    }
//                    break;
//
//                case 3:
//                    System.exit(0);
//
//                default:
//                    System.err.println("Команда не распознана");
//            }
//        }
//    }
//
//    // Method to get input from user
//    public static String getInput(String prompt) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print(prompt + ": ");
//        return scanner.nextLine();
//    }
//}
