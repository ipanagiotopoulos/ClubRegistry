package gr.hua.ds.club_registry.service.service;

import java.util.List;
import gr.hua.ds.club_registry.db.models.User;

public interface UserService {
    public User findUser(String username);
    public List <User> findAllUsers();
    public List<User> findAllGGASecretaries();
    public List<User> findAllHellenicPoliceSecretaries();
    public List<User>  findAllClubSupervisors();
    public void insertUser(User user);
    public void updateUser(User oldUser, User newUser);
    public void deleteUser(User user);

}


