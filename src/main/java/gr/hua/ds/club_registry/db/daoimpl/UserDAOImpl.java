package gr.hua.ds.club_registry.db.daoimpl;

import gr.hua.ds.club_registry.db.dao.UserDAO;
import gr.hua.ds.club_registry.db.models.User;
import gr.hua.ds.club_registry.db.enums.*;
import gr.hua.ds.club_registry.db.models.UserProfile;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.hibernate.Session;



import java.util.List;

@EnableAutoConfiguration
public class UserDAOImpl implements UserDAO {


    @Autowired
    private EntityManager  userManager;


    @Override
    public User getUserByUsername( String username ) {
        Session session= this.userManager.unwrap(Session.class);
        return (User) session.createSelectionQuery("from  where users.username=:username").setParameter("username", username).getResultList().get(0);
    }

    @Override
    public List <User> getUsers() {
        Session session= this.userManager.unwrap(Session.class);
        return (List<User>) session.createSelectionQuery("from users").getResultList();

    }

    @Override
    public List <User> getGGASecretaries() {
        Session session= this.userManager.unwrap(Session.class);
        return (List<User>) session.createSelectionQuery("from users where users.role=:role").setParameter("role", Roles.GGA_ROLE).getResultList();
    }

    @Override
    public List <User> getHellenicPoliceSecretaries() {
        Session session= this.userManager.unwrap(Session.class);
        return (List<User>) session.createSelectionQuery("from users where users.role=:role").setParameter("role",Roles.POLICE_ROLE).getResultList();
    }

    @Override
    public List <User> getClubSupervisors() {
        Session session= this.userManager.unwrap(Session.class);
        return (List<User>) session.createSelectionQuery("from users where users.role=:role").setParameter("role",Roles.CLUB_ROLE).getResultList();
    }

    @Override
    public User getUserByUsernameAndPassword( String username , String password ) {
        Session session= this.userManager.unwrap(Session.class);
        return (User) session.createSelectionQuery("from users where users.username=:username and users.password=:password").setParameter("username",username).setParameter("password", password).getResultList().get(0);
    }


    @Override
    public void insertUser( User user) {
        Session session= this.userManager.unwrap(Session.class);
        session.persist(user);
        session.persist(user.getProfile());
    }

    @Override
    public void updateUser( User oldUser , User newUser ) {
        Session session= this.userManager.unwrap(Session.class);
        session.remove(oldUser);
        session.persist(newUser);
    }

    @Override
    public void deleteUser( User user ) {
        Session session= this.userManager.unwrap(Session.class);
        session.remove(user);
        session.remove(user.getProfile());
    }
}
