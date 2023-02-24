
import java.util.regex.Matcher;

import java.util.regex.Pattern;

public class PasswordChecker {
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*\\d)[A-Za-z\\d@$!%*?&]{5,}$");

    public static String check(String password) {
        Matcher matcher = PASSWORD_PATTERN.matcher(password);
        if (!matcher.matches()) {
            System.out.println(" ");
            System.out.println("Your password is not strong");
            System.out.println(" ");
            return "wrong";
        } else {
            return password;
        }
    }
}

