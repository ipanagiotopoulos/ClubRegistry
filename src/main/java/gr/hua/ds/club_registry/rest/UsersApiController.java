package gr.hua.ds.club_registry.rest;

import gr.hua.ds.club_registry.db.enums.Roles;
import gr.hua.ds.club_registry.db.models.User;
import gr.hua.ds.club_registry.rest.exception.UserNotFoundException;
import gr.hua.ds.club_registry.rest.exception.UsersNotFoundException;
import gr.hua.ds.club_registry.service.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api/users")
@CrossOrigin(origins = "http://localhost:5000",allowCredentials = "true")
public class UsersApiController {

    @Autowired
    private UserService userService;

   @GetMapping("/all")
   public List <User>  getAllUsers(){
       return userService.findAllUsers();
   }


   @GetMapping("/user")
   public User getUser( @RequestHeader String username ){
       Optional<User> user = Optional.ofNullable(userService.findUser(username));
       return user.orElseThrow(() -> new UserNotFoundException(username));
   }

   @GetMapping("/supervisors")
   public List<User> findAllSupervisors(){
       Optional<List<User>> supervisors = Optional.ofNullable(userService.findAllUsers());
       return supervisors.orElseThrow(() ->new UsersNotFoundException(Roles.GGA_ROLE) );
   }


   @GetMapping("/hp_off")
   public List<User> findAllHellenicPoliceEmployees(){
       Optional<List<User>> hellenicPolliceEmployees = Optional.ofNullable(userService.findAllUsers());
       return hellenicPolliceEmployees.orElseThrow(() -> new UsersNotFoundException(Roles.POLICE_ROLE));
   }

    @GetMapping("/gga_off")
    public List<User> findAllGGAEmployees(){
        Optional<List<User>> ggaEmployees = Optional.ofNullable(userService.findAllUsers());
        return ggaEmployees.orElseThrow(() -> new UsersNotFoundException(Roles.GGA_ROLE));
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    public User insertUser(@RequestBody User user){
       userService.insertUser(user);
       return user;
    }
    @PostMapping(value="/updateuser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@RequestBody User user){
        User oldUser =  userService.findUser(user.getUsername());
        userService.updateUser(oldUser, user);
        return user;
    }

    @DeleteMapping("")
    public String deleteUser(@RequestBody User user){
        userService.deleteUser(user);
        return "User "+ user.getUsername( )+ " has been deleted!";
    }


}
