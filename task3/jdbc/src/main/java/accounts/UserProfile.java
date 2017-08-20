package accounts;

/**
 * Created by lb on 17.08.17.
 */
public class UserProfile {
    private final long id;
    private final String login;
    private final String pass;

    public UserProfile(long id, String login, String pass) {
        this.id = id;
        this.login = login;
        this.pass = pass;
    }

    public UserProfile(long id, String login) {
        this.id = id;
        this.login = login;
        this.pass = login;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }
}
