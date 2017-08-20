package accounts;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by lb on 17.08.17.
 */
@Entity
@Table(name = "users")
public class UserProfile implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "login", unique = true, updatable = false)
    private String login;

    @Column(name = "password")
    private String password;

    @SuppressWarnings("UnusedDeclaration")
    public UserProfile() {
    }

    public UserProfile(String login, String pass) {
        this.login = login;
        this.password = pass;
    }

    public UserProfile(String login) {
        this.login = login;
        this.password = login;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public long getId() {
        return id;
    }
}
