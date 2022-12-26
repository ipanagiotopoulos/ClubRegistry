package gr.hua.ds.club_registry.db.daoimpl;

import gr.hua.ds.club_registry.db.dao.ClubDAO;
import gr.hua.ds.club_registry.db.models.Club;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.PersistenceUnits;

import org.hibernate.Session;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Repository;


import java.sql.Date;
import java.util.List;


@Repository
@EnableAutoConfiguration
public class ClubDAOImpl implements ClubDAO {

    @PersistenceContext
    private EntityManager clubManager;

    @Override
    public List <Club> getClubs() {
        Session session= this.clubManager.unwrap(Session.class);
        return (List<Club>) session.createSQLQuery("from clubs").getResultList();
    }

    @Override
    public List <Club> getClubsByActiveStatus( Boolean active ) {
        Session session= this.clubManager.unwrap(Session.class);
        return (List<Club>) session.createQuery("from clubs where clubs.active=:active").setParameter("active",active).getResultList();
    }

    @Override
    public List <Club> getClubsByTeamName( String teamName ) {
        Session session= this.clubManager.unwrap(Session.class);
        return (List<Club>) session.createSQLQuery("from clubs where clubs.team_name=:teamName").setParameter("teamName",teamName).getResultList();
    }

    @Override
    public List <Club> getClubsByTeamNameAndActiveStatus( String teamName , Boolean active ) {
        Session session= this.clubManager.unwrap(Session.class);
        return (List<Club>) session.createSQLQuery("from clubs where clubs.team_name=:teamName and active=:active ").setParameter("teamName",teamName).setParameter("active",active).getResultList();
    }

    @Override
    public List <Club> getClubsBySupervisor( String supervisorUsername ) {
        Session session= this.clubManager.unwrap(Session.class);
        return (List<Club>) session.createSQLQuery("from clubs where clubs.supervisor_name=:supervisorUsername").setParameter("supervisorUsername",supervisorUsername).getResultList();
    }

    @Override
    public List <Club> getClubsBySupervisorAndActiveStatus( String supervisorUsername , Boolean active ) {
        Session session= this.clubManager.unwrap(Session.class);
        return (List<Club>) session.createSQLQuery("from clubs where clubs.supervisor_name=:supervisorUsername and active=:active").setParameter("supervisorUsername",supervisorUsername).setParameter("active",active).getResultList();
    }


    @Override
    public List <Club> getClubsFromSubmissionPeriod( Date fromDate , Date toDate ) {
        //Session session= this.clubManager.unwrap(Session.class);
        //return (List<Club>) session.createSelectionQuery("from clubs where clubs.submission_date between active=:active").setParameter("supervisorUsername",supervisorUsername).setParameter("active",active).getResultList();
        return null;
    }

    @Override
    public Club getClub( String taxNo ) {
        Session session= this.clubManager.unwrap(Session.class);
        return (Club) session.createSQLQuery("from clubs where clubs.tex_no=:taxNo").setParameter("taxNo",taxNo).getResultList().get(0);
    }

    @Override
    public void insertClub( Club club ) {
        Session session= this.clubManager.unwrap(Session.class);
        session.persist(club);
    }

    @Override
    public void deleteClub( Club club ) {
        Session session= this.clubManager.unwrap(Session.class);
        session.remove(club);

    }

    @Override
    public void updateClub( Club oldClub , Club newClub ) {
        Session session= this.clubManager.unwrap(Session.class);
        session.remove(oldClub);
        session.persist(newClub);
    }
}
