package gr.hua.ds.club_registry.service.service;

import  gr.hua.ds.club_registry.db.models.UserProfile;

public interface UserProfileService {
    public void insertProfile( UserProfile userProfile);
    public void updateProfile( UserProfile oldProfile, UserProfile newProfile );
    public void deleteProfile(UserProfile userProfile);
}
