import java.util.Scanner;

public class UserInput {
    private Scanner scanner;
    PasswordChecker passChecker = new PasswordChecker();

    public UserInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public Account getAccountInfo() {
        Integer id = Integer.valueOf(getInput("Id"));
        String account = getInput("Account");
        String mail = getInput("Mail");
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
        return new Account(id, account, mail, login, password);
    }

    private String getInput(String prompt) {
        System.out.print(prompt + " ");
        return scanner.nextLine();
    }
}