import java.util.Date;
class Account {
    private String account;
    private String mail;
    private String login;
    private String password;
    private Date lastChanged;

    public Account(String account, String mail, String login, String password) {
        this.account = account;
        this.mail = mail;
        this.login = login;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public String getMail() {
        return mail;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Date getLastChanged() {
        return lastChanged;
    }
    public void setPassword(String password) {
        this.password = password;
        this.lastChanged = new Date();
    }
}