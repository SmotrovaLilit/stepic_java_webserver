package dbService.dao;

import accounts.UserProfile;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;



public class UsersDAO {

    private Session session;

    public UsersDAO(Session session) {
        this.session = session;
    }

    public UserProfile get(long id) throws HibernateException {
        return (UserProfile) session.get(UserProfile.class, id);
    }

    public UserProfile getUserByLogin(String name) throws HibernateException {
        Criteria criteria = session.createCriteria(UserProfile.class);
        return (UserProfile) criteria.add(Restrictions.eq("login", name)).uniqueResult();
    }

    public long insertUser(String login, String password) throws HibernateException {
        return (Long) session.save(new UserProfile(login, password));
    }
}