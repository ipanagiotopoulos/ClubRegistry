package gr.hua.ds.club_registry.service.impl;

import gr.hua.ds.club_registry.db.models.Club;
import gr.hua.ds.club_registry.service.service.ClubService;

import java.sql.Date;
import java.util.List;

public class ClubServiceImpl implements ClubService {

    @Override
    public List <Club> findAllClubs() {
        return null;
    }

    @Override
    public List <Club> findAllActiveClubs( Boolean active ) {
        return null;
    }

    @Override
    public List <Club> searchClubByName( String clubName ) {
        return null;
    }

    @Override
    public List <Club> searchBySupervisorName( String supervisorName ) {
        return null;
    }

    @Override
    public Club searchByTaxNo( String taxNo ) {
        return null;
    }

    @Override
    public List <Club> searchByTeamNameAndActiveStatus( String teamName , String active ) {
        return null;
    }

    @Override
    public List <Club> searchBySupervisorAndActiveStatus( String supervisor , String active ) {
        return null;
    }

    @Override
    public List <Club> searchByDatePeriod( Date fromDate , Date toDate ) {
        return null;
    }

    @Override
    public void insertClub( Club club ) {

    }

    @Override
    public void deleteClub( Club club ) {

    }

    @Override
    public void updateClub( Club oldClub , Club newClub ) {

    }
}
