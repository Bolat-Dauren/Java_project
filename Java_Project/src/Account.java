public class Account {
    private String site;
    private String mail;
    private String login;
    private String password;

    public Account(String site, String mail, String login, String password) {
        this.site = site;
        this.mail = mail;
        this.login = login;
        this.password = password;
    }

    public String getSite() {
        return site;
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
}
