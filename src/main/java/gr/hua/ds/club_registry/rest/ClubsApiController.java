package gr.hua.ds.club_registry.rest;


import gr.hua.ds.club_registry.db.models.Club;
import gr.hua.ds.club_registry.db.models.Shop;
import gr.hua.ds.club_registry.rest.exception.ClubNotFoundException;
import gr.hua.ds.club_registry.rest.exception.ClubsNotFoundException;
import gr.hua.ds.club_registry.rest.exception.ShopsNotFoundException;
import gr.hua.ds.club_registry.service.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/clubs")
public class ClubsApiController {

    @Autowired
    private ClubService clubService;


    @GetMapping("")
    public List<Club> getAllClubs(){
        Optional <List<Club>> clubs = Optional.ofNullable(clubService.findAllClubs());
        return clubs.orElseThrow(() ->new ShopsNotFoundException());
    }

    @GetMapping("/all_based_on_activity")
    public List<Club> getAllClubsActiveInactive( @RequestParam(name="active") Boolean active ){
        Optional <List<Club>> activeClubs = Optional.ofNullable(active?clubService.findAllActiveClubs():clubService.findAllInactiveClubs());
        return activeClubs.orElseThrow(() ->new ClubsNotFoundException() );
    }


    @GetMapping("/all_team_name")
    public List<Club> getAllClubsByTeamName(@RequestParam(name="team_name") String teamName){
        Optional <List<Club>> clubs = Optional.ofNullable(clubService.searchClubByTeamName(teamName));
        return clubs.orElseThrow(() ->new ShopsNotFoundException() );
    }

    @GetMapping("/all_supervisor_name")
    public List<Club> getClubsBySupervisorName(@RequestHeader String supervisorName){
        Optional <List<Club>> clubs = Optional.ofNullable(clubService.searchBySupervisorName(supervisorName));
        return clubs.orElseThrow(() ->new ShopsNotFoundException() );
    }

    @GetMapping("/team_active")
    public List<Club> getAllShopsByTeamNameAndActive(@RequestParam(name="team_name") String teamName, @RequestParam(name="active_Status") Boolean active){
        Optional <List<Club>> clubs = Optional.ofNullable(clubService.searchByTeamNameAndActiveStatus(teamName, active));
        return clubs.orElseThrow(() ->new ShopsNotFoundException() );
    }


    @GetMapping("/find")
    public Club findClub(@RequestHeader(name="tax_no") String taxNo){
        Optional <Club> club = Optional.ofNullable(clubService.searchByTaxNo(taxNo));
        return club.orElseThrow(() ->new ClubNotFoundException() );
    }
    @GetMapping("/supervisor_active")
    public List<Club> searchBySupervisorAndActiveStatus(@RequestHeader String supervisor, @RequestHeader Boolean active){
        Optional <List<Club>> clubs = Optional.ofNullable(clubService.searchBySupervisorAndActiveStatus(supervisor,active));
        return clubs.orElseThrow(() ->new ClubNotFoundException() );
    }

    public List<Club>  getClubsByDatePeriod(@RequestParam Date fromDate, @RequestParam  Date toDate){
        return null; //unimplemented
    }


    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Club insertClub(@RequestBody Club club){
        clubService.insertClub(club);
        return  club;
    }
    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Club updateClub(@RequestBody Club club){
        clubService.insertClub(club); //needs changes
        return  club;
    }

    @DeleteMapping("")
    public Club deleteClub(@RequestBody Club club){
        clubService.deleteClub(club);
        return  club;
    }

}
