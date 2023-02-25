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
            int score = calculatePasswordScore(password);
            int maxScore = 100;
            int percentage = (int) ((double) score / maxScore * 100);
            System.out.printf("Your password strength is %d%%\n", percentage);
            return password;
        }
    }

    private static int calculatePasswordScore(String password) {
        int score = 0;
        if (password.matches(".*[a-z].*")) {
            score += 10;
        }
        if (password.matches(".*[A-Z].*")) {
            score += 20;
        }
        if (password.matches(".*\\d.*")) {
            score += 30;
        }
        if (password.matches(".*[@$!%*?&].*")) {
            score += 40;
        }
        return score;
    }
}