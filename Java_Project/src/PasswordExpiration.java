import java.util.Date;

public class PasswordExpiration {
    private static final long EXPIRATION_PERIOD_MS = 30 * 24 * 60 * 60 * 1000L; // 30 days

    public static boolean isPasswordExpired(Date lastChanged) {
        Date now = new Date();
        return now.getTime() - lastChanged.getTime() >= EXPIRATION_PERIOD_MS;
    }

    public static void notifyPasswordExpiringSoon(Date lastChanged) {
        Date now = new Date();
        long timeUntilExpiration = lastChanged.getTime() + EXPIRATION_PERIOD_MS - now.getTime();
        if (timeUntilExpiration <= 0) {
            System.out.println("Your password has already expired!");
        } else {
            System.out.printf("Your password will expire in %d days.%n", timeUntilExpiration / (24 * 60 * 60 * 1000L));
        }
    }

    public static void notifyPasswordExpired() {
        System.out.println("Your password has expired! Please change it.");
    }
}