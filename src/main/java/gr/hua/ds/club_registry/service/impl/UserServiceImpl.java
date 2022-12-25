package gr.hua.ds.club_registry.service.impl;

import gr.hua.ds.club_registry.db.models.User;
import gr.hua.ds.club_registry.service.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public User findUser( String username ) {
        return null;
    }

    @Override
    public List <User> findAllUsers() {
        return null;
    }

    @Override
    public List <User> findAllGGASecretaries() {
        return null;
    }

    @Override
    public List <User> findAllHellenicPoliceSecretaries() {
        return null;
    }

    @Override
    public List <User> findAllClubSupervisors() {
        return null;
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
