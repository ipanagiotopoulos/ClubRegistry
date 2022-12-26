package gr.hua.ds.club_registry.service.impl;


import gr.hua.ds.club_registry.db.models.UserProfile;
import gr.hua.ds.club_registry.service.service.UserProfileService;
import gr.hua.ds.club_registry.db.dao.UserProfileDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserProfileServiceImpl implements UserProfileService {


    @Autowired
    private UserProfileDAO userProfileDAO;

    @Override
    public void insertProfile( UserProfile userProfile ) {
        userProfileDAO.insertProfile(userProfile);
    }

    @Override
    public void updateProfile( UserProfile oldProfile , UserProfile newProfile ) {
        userProfileDAO.updateProfile(oldProfile, newProfile);

    }

    @Override
    public void deleteProfile( UserProfile userProfile ) {
        userProfileDAO.deleteProfile(userProfile);

    }
}
