package gr.hua.ds.club_registry.service.impl;

import gr.hua.ds.club_registry.db.dao.ClubDAO;
import gr.hua.ds.club_registry.db.models.Club;
import gr.hua.ds.club_registry.service.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;


@Service
public class ClubServiceImpl implements ClubService {

    @Autowired
    private ClubDAO clubDAO;

    @Override
    public List <Club> findAllClubs() {
     return clubDAO.getClubs();
    }

    @Override
    public List <Club> findAllActiveClubs() {
        return clubDAO.getClubsByActiveStatus(true);
    }

    @Override
    public List<Club> findAllInactiveClubs(){
        return clubDAO.getClubsByActiveStatus(false);
    }

    @Override
    public List <Club> searchClubByTeamName( String teamName ) {
        return clubDAO.getClubsByTeamName(teamName);
    }

    @Override
    public List <Club> searchBySupervisorName( String supervisorName ) {
        return clubDAO.getClubsBySupervisor(supervisorName);
    }

    @Override
    public Club searchByTaxNo( String taxNo ) {
        return clubDAO.getClub(taxNo);
    }

    @Override
    public List <Club> searchByTeamNameAndActiveStatus( String teamName , Boolean active ) {
        return clubDAO.getClubsByTeamNameAndActiveStatus(teamName, active);
    }

    @Override
    public List <Club> searchBySupervisorAndActiveStatus( String supervisor , Boolean active ) {
        return clubDAO.getClubsBySupervisorAndActiveStatus(supervisor, active);
    }

    @Override
    public List <Club> searchByDatePeriod( Date fromDate , Date toDate ) {
        return clubDAO.getClubsFromSubmissionPeriod(fromDate, toDate);
    }

    @Override
    public void insertClub( Club club ) {
       clubDAO.insertClub(club);
    }

    @Override
    public void deleteClub( Club club ) {
      clubDAO.deleteClub(club);
    }

    @Override
    public void updateClub( Club oldClub , Club newClub ) {
        clubDAO.updateClub(oldClub, newClub);
    }
}
