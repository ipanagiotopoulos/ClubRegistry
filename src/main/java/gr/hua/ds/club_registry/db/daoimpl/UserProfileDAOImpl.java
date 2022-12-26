package gr.hua.ds.club_registry.db.daoimpl;

import gr.hua.ds.club_registry.db.dao.UserProfileDAO;
import gr.hua.ds.club_registry.db.models.UserProfile;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Session;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Repository;

@Repository
@EnableAutoConfiguration
public class UserProfileDAOImpl implements UserProfileDAO {
    @Autowired
    private EntityManager profileManager;

    @Override
    public void insertProfile( UserProfile userProfile ) {
        Session session = this.profileManager.unwrap(Session.class);
        session.persist(userProfile);
    }

    @Override
    public void updateProfile( UserProfile oldProfile, UserProfile newProfile ) {
        Session session = this.profileManager.unwrap(Session.class);
        session.remove(oldProfile);
        session.persist(newProfile);

    }

    @Override
    public void deleteProfile( UserProfile userProfile ) {
        Session session = this.profileManager.unwrap(Session.class);
        session.remove(userProfile);

    }
}
