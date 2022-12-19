package gr.hua.ds.club_registry.db.dao;

import org.springframework.context.annotation.Profile;

public interface ProfileDAO {
        public void insertProfile( Profile userProfile);
        public void updateProfile(Profile userProfile);
        public void deleteProfile(Profile userProfile);
}
