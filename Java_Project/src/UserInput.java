import java.util.Scanner;

public class UserInput {
    private Scanner scanner;

    public UserInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public Account getAccountInfo() {
        String account = getInput("Account");
        String mail = getInput("Mail");
        String login = getInput("Login");
        String password = getInput("Password");
        return new Account(account, mail, login, password);
    }

    private String getInput(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }
}