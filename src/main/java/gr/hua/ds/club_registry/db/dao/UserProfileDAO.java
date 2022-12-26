package gr.hua.ds.club_registry.db.dao;

import gr.hua.ds.club_registry.db.models.UserProfile;

public interface UserProfileDAO {
        public void insertProfile( UserProfile userProfile);
        public void updateProfile( UserProfile oldProfile, UserProfile newProfile );
        public void deleteProfile(UserProfile userProfile);
}
