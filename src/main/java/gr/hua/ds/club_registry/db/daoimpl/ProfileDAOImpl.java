package gr.hua.ds.club_registry.db.daoimpl;

import gr.hua.ds.club_registry.db.dao.ProfileDAO;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@EnableAutoConfiguration
public class ProfileDAOImpl implements ProfileDAO {
    @Autowired
    private EntityManager profileManager;

    @Override
    public void insertProfile( Profile userProfile ) {

    }

    @Override
    public void updateProfile( Profile userProfile ) {

    }

    @Override
    public void deleteProfile( Profile userProfile ) {

    }
}
