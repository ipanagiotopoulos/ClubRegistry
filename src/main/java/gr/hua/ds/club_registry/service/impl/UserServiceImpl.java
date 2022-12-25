package gr.hua.ds.club_registry.service.impl;

import gr.hua.ds.club_registry.db.dao.UserDAO;
import gr.hua.ds.club_registry.db.dao.UserProfileDAO;
import gr.hua.ds.club_registry.db.models.User;
import gr.hua.ds.club_registry.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDAO userDAO;

    @Override
    public User findUser( String username ) {
        return  userDAO.getUserByUsername(username);
    }

    @Override
    public List <User> findAllUsers() {
        return userDAO.getUsers();
    }

    @Override
    public List <User> findAllGGASecretaries() {
        return  userDAO.getGGASecretaries();
    }

    @Override
    public List <User> findAllHellenicPoliceSecretaries() {
        return  userDAO.getHellenicPoliceSecretaries();
    }

    @Override
    public List <User> findAllClubSupervisors() {
        return userDAO.getClubSupervisors();
    }

    @Override
    public void insertUser( User user ) {
        userDAO.insertUser(user);
    }

    @Override
    public void updateUser( User oldUser , User newUser ) {
        userDAO.updateUser(oldUser, newUser);
    }

    @Override
    public void deleteUser( User user ) {
        userDAO.deleteUser(user);
    }
}
