package gr.hua.ds.club_registry.db.daoimpl;

import gr.hua.ds.club_registry.db.dao.ShopDAO;
import gr.hua.ds.club_registry.db.models.Shop;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Repository;


import java.sql.Date;
import java.util.List;

@Repository
@EnableAutoConfiguration
public class ShopDAOImpl implements ShopDAO {

    @Autowired
    private EntityManager shopManager;

    @Override
    public List <Shop> getShops() {
        Session session= this.shopManager.unwrap(Session.class);
        return (List<Shop>) session.createSelectionQuery("from shops").getResultList();
    }

    @Override
    public List <Shop> getShopsByActiveStatus( Boolean active ) {
        Session session= this.shopManager.unwrap(Session.class);
        return (List<Shop>) session.createSelectionQuery("from shops where shops.active=:active").setParameter("active", active).getResultList();
    }

    @Override
    public List <Shop> getShopsByClubName( String clubName ) {
        Session session= this.shopManager.unwrap(Session.class);
        return (List<Shop>) session.createSelectionQuery("from shops where shops.club_name=:club_name").setParameter("club_name", clubName).getResultList();
    }

    @Override
    public List <Shop> getShopsByTeamName( String teamName ) {
        Session session= this.shopManager.unwrap(Session.class);
        return (List<Shop>) session.createSelectionQuery("from shops where shops.team_name=:team_name").setParameter("team_name", teamName).getResultList();
    }

    @Override
    public List <Shop> getShopsByCity( String cityName ) {
        Session session= this.shopManager.unwrap(Session.class);
        return (List<Shop>) session.createSelectionQuery("from shops where shops.city=:city").setParameter("city", cityName).getResultList();
    }

    @Override
    public List <Shop> getShopsByCityAndTeamName( String cityName , String teamName ) {
        Session session= this.shopManager.unwrap(Session.class);
        return (List<Shop>) session.createSelectionQuery("from shops where shops.city=:city and shops.team_name=:team_name").setParameter("city", cityName).setParameter("team_name", teamName).getResultList();
    }

    @Override
    public List <Shop> getShopsByCityAndClubName( String cityName , String clubName ) {
        Session session= this.shopManager.unwrap(Session.class);
        return (List<Shop>) session.createSelectionQuery("from shops where shops.city=:city and shops.club_name=:club_name").setParameter("city", cityName).setParameter("club_name", clubName).getResultList();
    }

    @Override
    public List <Shop> getShopsByTeamNameAndActiveStatus( String teamName , Boolean active ) {
        Session session= this.shopManager.unwrap(Session.class);
        return (List<Shop>) session.createSelectionQuery("from shops where shops.team_name=:team_name and shops.active=:active").setParameter("team_name", teamName).setParameter("active", active).getResultList();
    }

    @Override
    public List <Shop> getShopsByClubNameAndActiveStatus( String clubName , Boolean active ) {
        Session session= this.shopManager.unwrap(Session.class);
        return (List<Shop>) session.createSelectionQuery("from shops where shops.club_name=:club_name and shops.active=:active").setParameter("club_name", clubName).setParameter("active", active).getResultList();
    }

    //!NOT IMPLEMENTED
    @Override
    public List <Shop> getShopsBySupervisor( String supervisorUserName ) {
        return null;
    }


    //!NOT IMPLEMENTED
    @Override
    public List <Shop> getShopsBySupervisorAndActiveStatus( String supervisorUserName , Boolean active ) {
        return null;
    }

    //!NOT IMPLEMENTED
    @Override
    public List <Shop> getShopsFromSubmissionPeriod( Date fromDate , Date toDate ) {
        return null;
    }

    @Override
    public Shop getShop( String shopId ) {
        Session session= this.shopManager.unwrap(Session.class);
        return (Shop) session.createSelectionQuery("from shops where shops.id=:id ").setParameter("id", shopId).getResultList();
    }

    @Override
    public void insertShop( Shop shop ) {
        Session session= this.shopManager.unwrap(Session.class);
        session.persist(shop);

    }

    @Override
    public void deleteShop( Shop shop ) {
        Session session= this.shopManager.unwrap(Session.class);
        session.remove(shop);

    }

    @Override
    public void updateShop( Shop oldShop , Shop newShop ) {
        Session session= this.shopManager.unwrap(Session.class);
        session.remove(oldShop);
        session.persist(newShop);
    }
}
