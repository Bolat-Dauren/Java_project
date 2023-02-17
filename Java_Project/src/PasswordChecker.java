
import static java.lang.System.*;

public class PasswordChecker {

    public static void check() {
        Account password=new Account(String password);
        if (isSimplePassword(password)) {
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
