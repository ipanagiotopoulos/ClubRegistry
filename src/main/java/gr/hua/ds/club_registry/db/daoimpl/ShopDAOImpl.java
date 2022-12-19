package gr.hua.ds.club_registry.db.daoimpl;

import gr.hua.ds.club_registry.db.dao.ShopDAO;
import gr.hua.ds.club_registry.db.models.Shop;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@EnableAutoConfiguration
public class ShopDAOImpl implements ShopDAO {

    @Autowired
    private EntityManager shopManager;

    @Override
    public List <Shop> getClubs() {
        return null;
    }

    @Override
    public List <Shop> getShopsByActiveStatus( Boolean active ) {
        return null;
    }

    @Override
    public List <Shop> getShopsByClubName( String clubName ) {
        return null;
    }

    @Override
    public List <Shop> getShopsByTeamName( String teamName ) {
        return null;
    }

    @Override
    public List <Shop> getShopsByCity( String cityName ) {
        return null;
    }

    @Override
    public List <Shop> getShopsByCityAndTeamName( String cityName , String teamName ) {
        return null;
    }

    @Override
    public List <Shop> getShopsByCityAndClubName( String cityName , String clubName ) {
        return null;
    }

    @Override
    public List <Shop> getShopsByTeamNameAndActiveStatus( String teamName , Boolean active ) {
        return null;
    }

    @Override
    public List <Shop> getShopsByClubNameAndActiveStatus( String clubName , Boolean active ) {
        return null;
    }

    @Override
    public List <Shop> getShopsBySupervisor( String supervisorUserName ) {
        return null;
    }

    @Override
    public List <Shop> getShopsBySupervisorAndActiveStatus( String supervisorUserName , Boolean active ) {
        return null;
    }

    @Override
    public List <Shop> getShopsFromSubmissionPeriod( Date fromDate , Date toDate ) {
        return null;
    }

    @Override
    public Shop getShop( String shopId ) {
        return null;
    }

    @Override
    public void insertShop( Shop shop ) {

    }

    @Override
    public void deleteShop( Shop shop ) {

    }

    @Override
    public void updateShop( Shop oldShop , Shop newShop ) {

    }
}
