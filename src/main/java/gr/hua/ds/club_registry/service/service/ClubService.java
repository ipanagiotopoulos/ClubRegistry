package gr.hua.ds.club_registry.service.service;

import java.sql.Date;
import java.util.List;
import gr.hua.ds.club_registry.db.models.Club;

public interface ClubService {
    public List<Club> findAllClubs();
    public List<Club> findAllActiveClubs(Boolean active);
    public List<Club> searchClubByName(String clubName);
    public List<Club> searchBySupervisorName(String supervisorName);
    public Club searchByTaxNo(String taxNo);
    public List<Club> searchByTeamNameAndActiveStatus(String teamName, String active);
    public List<Club> searchBySupervisorAndActiveStatus(String supervisor, String active);
    public List<Club> searchByDatePeriod( Date fromDate, Date toDate);
    public void insertClub(Club club);
    public void deleteClub(Club club);
    public void updateClub( Club oldClub , Club newClub );
}


