package enums;

public enum User {

    PITER_CHALOVSKII("epam", "1234", "PITER CHAILOVSKII");

    public String login;
    public String password;
    public String userName;

    User(String login, String password, String userName) {
        this.login = login;
        this.password = password;
        this.userName = userName;
    }
}