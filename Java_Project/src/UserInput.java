import java.util.Scanner;

public class UserInput {
    private Scanner scanner;
    private PasswordChecker passChecker = new PasswordChecker();

    public UserInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public Account getAccountInfo() {
        String account = getInput("Account");
        String mail;
        while (true) {
            mail = getInput("Mail");
            if (EmailChecker.isValid(mail)) {
                break;
            } else {
                System.out.println("Invalid email, please try again.");
            }
        }
        String login = getInput("Login");
        String password;
        String answer;
        while (true) {
            password = getInput("Password");
            answer = passChecker.check(password);
            if (answer.contentEquals("wrong")) {
                continue;
            }
            else {break;}
        }
        return new Account(account, mail, login, password);
    }

    private String getInput(String prompt) {
        System.out.print(prompt + " ");
        return scanner.nextLine();
    }
}