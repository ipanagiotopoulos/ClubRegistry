package gr.hua.ds.club_registry.service.impl;

import gr.hua.ds.club_registry.db.models.Shop;
import gr.hua.ds.club_registry.service.service.ShopService;

import java.util.List;

public class ShopServiceImpl implements ShopService {

    @Override
    public List <Shop> findAllShops() {
        return null;
    }

    @Override
    public List <Shop> findAllActiveShops( Boolean active ) {
        return null;
    }

    @Override
    public List <Shop> findShopsByClubName( String clubName ) {
        return null;
    }

    @Override
    public List <Shop> findShopsByTeamName( String teamName ) {
        return null;
    }

    @Override
    public List <Shop> findShopsByCity( String cityName ) {
        return null;
    }

    @Override
    public List <Shop> findShopsByCityAndTeamName( String cityName , String teamName ) {
        return null;
    }

    @Override
    public List <Shop> findShopsByCityAndClubName( String cityName , String clubName ) {
        return null;
    }

    @Override
    public List <Shop> findShopsByTeamNameAndActiveStatus( String teamName , Boolean active ) {
        return null;
    }

    @Override
    public List <Shop> findShopsByClubNameAndActiveStatus( String clubName , Boolean active ) {
        return null;
    }

    @Override
    public Shop findShop( String shopId ) {
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
