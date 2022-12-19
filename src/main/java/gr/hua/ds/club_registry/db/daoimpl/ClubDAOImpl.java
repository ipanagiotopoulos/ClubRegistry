package gr.hua.ds.club_registry.db.daoimpl;

import gr.hua.ds.club_registry.db.dao.ClubDAO;
import gr.hua.ds.club_registry.db.models.Club;
import gr.hua.ds.club_registry.db.models.Shop;
import gr.hua.ds.club_registry.db.models.User;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;


@EnableAutoConfiguration
public class ClubDAOImpl implements ClubDAO {

    @Autowired
    private EntityManager clubManager;

    @Override
    public List <Club> getClubs() {
        return null;
    }

    @Override
    public List <Club> getClubsByActiveStatus( Boolean active ) {
        Session session= this.clubManager.unwrap(Session.class);
        return (List<Club>) session.createSelectionQuery("from clubs where clubs.active=:active").setParameter("active",active).getResultList();
    }

    @Override
    public List <Club> getClubsByTeamName( String teamName ) {
        Session session= this.clubManager.unwrap(Session.class);
        return (List<Club>) session.createSelectionQuery("from clubs where clubs.team_name=:teamName").setParameter("teamName",teamName).getResultList();
    }

    @Override
    public List <Club> getClubsByTeamNameAndActiveStatus( String teamName , Boolean active ) {
        Session session= this.clubManager.unwrap(Session.class);
        return (List<Club>) session.createSelectionQuery("from clubs where clubs.team_name=:teamName and active=:active ").setParameter("teamName",teamName).setParameter("active",active).getResultList();
    }

    @Override
    public List <Club> getClubsBySupervisor( String supervisorUserName ) {
        return null;
    }

    @Override
    public List <Club> getClubsBySupervisorAndActiveStatus( String supervisorUserName , Boolean active ) {
        return null;
    }

    @Override
    public List <Club> getClubsFromSubmissionPeriod( Date fromDate , Date toDate ) {
        return null;
    }

    @Override
    public Club getClub( String taxNo ) {
        return null;
    }

    @Override
    public void insertClub( Club club ) {

    }

    @Override
    public void deleteClub( Club club ) {

    }

    @Override
    public void updateClub( Club oldClub , Shop newClub ) {

    }
}
