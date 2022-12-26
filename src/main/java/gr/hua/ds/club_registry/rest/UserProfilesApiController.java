package gr.hua.ds.club_registry.rest;


import gr.hua.ds.club_registry.db.models.UserProfile;
import gr.hua.ds.club_registry.service.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/userprofiles")
public class UserProfilesApiController {

    @Autowired
    private UserProfileService userProfileService;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserProfile insertProfile( @RequestBody UserProfile userProfile ){
        userProfileService.insertProfile(userProfile);
        return userProfile;
    }

    @PostMapping("/update")
    public UserProfile updateProfile( @RequestBody UserProfile userProfile ){
        userProfileService.insertProfile(userProfile);
        return userProfile;
    }


    @DeleteMapping("/")
    public String deleteProfile( @RequestBody UserProfile userProfile ){
        userProfileService.deleteProfile(userProfile);
        return "Profile with username:"+userProfile.getUsername()+" has been deleted!";
    }
}
