class Account {
    private Integer id;
    private String account;
    private String mail;
    private String login;
    private String password;

    public Account(Integer id, String account, String mail, String login, String password) {
        this.id = id;
        this.account = account;
        this.mail = mail;
        this.login = login;
        this.password = password;
    }
    public int getId() {
        return id;
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
}