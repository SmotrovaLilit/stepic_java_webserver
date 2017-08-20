package accounts;

import dbService.DBException;
import dbService.DBService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lb on 17.08.17.
 */
public class AccountService {
    private final DBService dbService;
    private final Map<String, UserProfile> sessionIdToProfile;

    public AccountService() {

        sessionIdToProfile = new HashMap<>();
        dbService = new DBService();
    }

    public void addNewUser(UserProfile userProfile) throws DBException {
        dbService.addUser(userProfile.getLogin(), userProfile.getPassword());
    }

    public UserProfile getUserByLogin(String login) throws DBException {
        return dbService.getUserByLogin(login);
    }

    public UserProfile getUserBySessionId(String sessionId) {
        return sessionIdToProfile.get(sessionId);
    }

    public void addSession(String sessionId, UserProfile userProfile) {
        sessionIdToProfile.put(sessionId, userProfile);
    }

    public void deleteSession(String sessionId) {
        sessionIdToProfile.remove(sessionId);
    }
}
