package gr.hua.ds.club_registry.db.daoimpl;

import gr.hua.ds.club_registry.db.dao.UserDAO;
import gr.hua.ds.club_registry.db.models.User;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;
import org.hibernate.Session;


import java.util.List;

@EnableAutoConfiguration
public class UserDAOImpl implements UserDAO {


    @Autowired
    private EntityManager  userManager;

    @Override
    public User getUserByUsernameAndPass( String username , String password ) {
        return null;
    }

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
        return (List<User>) session.createSelectionQuery("from users where users.role=:role").setParameter("role","GGA_ROLE").getResultList();
    }

    @Override
    public List <User> getHellenicPoliceSecretaries() {
        Session session= this.userManager.unwrap(Session.class);
        return (List<User>) session.createSelectionQuery("from users where users.role=:role").setParameter("role","GGA_ROLE").getResultList();
    }

    @Override
    public List <User> getClubSupervisors() {
        Session session= this.userManager.unwrap(Session.class);
        return (List<User>) session.createSelectionQuery("from users where users.role=:role").setParameter("role","GGA_ROLE").getResultList();
    }

    @Override
    public User getHellenicPoliceSecretaryByUsernameAndPassword( String username , String password ) {
        return null;
    }

    @Override
    public User getGGASecretaryByUsernameAndPassword( String username , String password ) {
        return null;
    }

    @Override
    public User geClubSupervisorByUsernameAndPassword( String username , String password ) {
        return null;
    }

    @Override
    public User getClubSupervisor( String username ) {
        return null;
    }

    @Override
    public User getGGASecretary( String username ) {
        return null;
    }

    @Override
    public User getHellenicPoliceSecretary( String username ) {
        return null;
    }

    @Override
    public void insertUserOnly( User user ) {

    }

    @Override
    public void insertUser( User user ) {

    }

    @Override
    public void updateUser( User oldUser , User newUser ) {

    }

    @Override
    public void deleteUser( User u ) {

    }
}
