package gr.hua.ds.club_registry.service.impl;

import java.util.List;

import gr.hua.ds.club_registry.db.dao.ShopDAO;
import gr.hua.ds.club_registry.db.models.Shop;
import gr.hua.ds.club_registry.service.service.ShopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ShopServiceImpl implements ShopService {


    @Autowired
    private ShopDAO shopDAO;

    @Override
    public List <Shop> findAllShops() {
        return shopDAO.getShops();
    }

    @Override
    public List <Shop> findAllActiveShops() {
        return shopDAO.getShopsByActiveStatus(true);
    }

    @Override
    public List <Shop> findAllInActiveShops() {
        return shopDAO.getShopsByActiveStatus(false);
    }

    @Override
    public List <Shop> findShopsByClubName( String clubName ) {
        return  shopDAO.getShopsByClubName(clubName);
    }

    @Override
    public List <Shop> findShopsByTeamName( String teamName ) {
        return shopDAO.getShopsByTeamName(teamName);
    }

    @Override
    public List <Shop> findShopsByCity( String cityName ) {
        return shopDAO.getShopsByCity(cityName);
    }

    @Override
    public List <Shop> findShopsByCityAndTeamName( String cityName , String teamName ) {
        return shopDAO.getShopsByCityAndTeamName(cityName, teamName);
    }

    @Override
    public List <Shop> findShopsByCityAndClubName( String cityName , String clubName ) {
        return shopDAO.getShopsByCityAndClubName(cityName, clubName);
    }

    @Override
    public List <Shop> findShopsByTeamNameAndActiveStatus( String teamName , Boolean active ) {
        return shopDAO.getShopsByTeamNameAndActiveStatus(teamName, active);
    }

    @Override
    public List <Shop> findShopsByClubNameAndActiveStatus( String clubName , Boolean active ) {
        return shopDAO.getShopsByClubNameAndActiveStatus(clubName, active);
    }

    @Override
    public Shop findShop( String shopId ) {
        return shopDAO.getShop(shopId);
    }

    @Override
    public void insertShop( Shop shop ) {
        shopDAO.insertShop(shop);
    }

    @Override
    public void deleteShop( Shop shop ) {
      shopDAO.deleteShop(shop);
    }

    @Override
    public void updateShop( Shop oldShop , Shop newShop ) {
        shopDAO.updateShop(oldShop,newShop);

    }
}
