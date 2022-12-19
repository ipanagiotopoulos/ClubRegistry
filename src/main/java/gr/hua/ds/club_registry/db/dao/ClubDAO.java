package gr.hua.ds.club_registry.db.dao;

import java.sql.Date;
import java.util.List;
import gr.hua.ds.club_registry.db.models.Club;
import gr.hua.ds.club_registry.db.models.Shop;


public interface ClubDAO {
    public List <Club>  getClubs();
    public List <Club>  getClubsByActiveStatus(Boolean active);
    public List <Club>  getClubsByTeamName(String teamName);
    public List <Club>  getClubsByTeamNameAndActiveStatus(String teamName,Boolean active);
    public List <Club>  getClubsBySupervisor(String supervisorUserName);
    public List <Club>  getClubsBySupervisorAndActiveStatus(String supervisorUserName, Boolean active);
    public List<Club> getClubsFromSubmissionPeriod( Date fromDate, Date toDate );
    public Club getClub(String taxNo);
    public void insertClub(Club club);
    public void deleteClub(Club club);
    public void updateClub( Club oldClub, Shop newClub);
}
