import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager {
    private Connection connection;

    public DatabaseManager(Connection connection) {
        this.connection = connection;
    }

    public void insertAccount(Account account) throws SQLException {
        String sql = "INSERT INTO accounts (account, mail, login, password) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, account.getSite());
        statement.setString(2, account.getMail());
        statement.setString(3, account.getLogin());
        statement.setString(4, account.getPassword());
        statement.executeUpdate();
    }
}
