import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordStrengthChecker {
    private static final Pattern LOWERCASE_PATTERN = Pattern.compile("[a-z]");
    private static final Pattern UPPERCASE_PATTERN = Pattern.compile("[A-Z]");
    private static final Pattern DIGIT_PATTERN = Pattern.compile("\\d");
    private static final Pattern SPECIAL_PATTERN = Pattern.compile("[@$!%*?&]");

    public static int check(String password) {
        int requirementsMet = 0;
        Matcher lowercaseMatcher = LOWERCASE_PATTERN.matcher(password);
        if (lowercaseMatcher.find()) {
            requirementsMet++;
        }
        Matcher uppercaseMatcher = UPPERCASE_PATTERN.matcher(password);
        if (uppercaseMatcher.find()) {
            requirementsMet++;
        }
        Matcher digitMatcher = DIGIT_PATTERN.matcher(password);
        if (digitMatcher.find()) {
            requirementsMet++;
        }
        Matcher specialMatcher = SPECIAL_PATTERN.matcher(password);
        if (specialMatcher.find()) {
            requirementsMet++;
        }
        int percentage = requirementsMet * 25;
        return percentage;
    }
}

