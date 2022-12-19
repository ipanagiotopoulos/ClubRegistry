package gr.hua.ds.club_registry.db.dao;


import gr.hua.ds.club_registry.db.models.User;

import java.util.List;

public interface UserDAO {
    public User getUserByUsernameAndPass( String username, String password);
    public User getUserByUsername(String username);

    public List <User> getUsers();

    public List<User> getGGASecretaries();
    public List<User> getHellenicPoliceSecretaries();
    public List<User> getClubSupervisors();

    public User getHellenicPoliceSecretaryByUsernameAndPassword(String username, String password);
    public User getGGASecretaryByUsernameAndPassword(String username, String password);
    public User geClubSupervisorByUsernameAndPassword(String username, String password);

    public User getClubSupervisor(String username);
    public User getGGASecretary(String username);
    public User getHellenicPoliceSecretary(String username);

    public void insertUserOnly(User user);
    public void insertUser(User user);
    public void updateUser(User oldUser, User newUser);
    public void deleteUser(User u);
}
