package gr.hua.ds.club_registry.db.daoimpl;

import gr.hua.ds.club_registry.db.dao.UserProfileDAO;
import gr.hua.ds.club_registry.db.models.UserProfile;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserProfileDAOImpl implements UserProfileDAO {

    @PersistenceContext
    private EntityManager profileManager;

    @Override
    public void insertProfile( UserProfile userProfile ) {
        Session session= this.profileManager.unwrap(Session.class);
        session.persist(userProfile);
    }

    @Override
    public void updateProfile( UserProfile oldProfile, UserProfile newProfile ) {
        Session session= this.profileManager.unwrap(Session.class);
        session.remove(oldProfile);
        session.persist(newProfile);

    }

    @Override
    public void deleteProfile( UserProfile userProfile ) {
        Session session= this.profileManager.unwrap(Session.class);
        session.remove(userProfile);

    }
}
