package gr.hua.ds.club_registry.db.dao;

import gr.hua.ds.club_registry.db.enums.ShopType;
import gr.hua.ds.club_registry.db.models.Shop;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

public interface ShopDAO {
        public List <Shop> getShops();
        public List <Shop>  getShopsByActiveStatus(Boolean active);
        public List <Shop>  getShopsByClubName(String clubName);
        public List <Shop>  getShopsByTeamName(String teamName);
        public List<Shop> getShopsByCity(String cityName);
        public List<Shop> getShopsByCityAndTeamName(String cityName, String teamName);
        public List<Shop> getShopsByCityAndClubName(String cityName, String clubName);
        public List <Shop>  getShopsByTeamNameAndActiveStatus(String teamName,Boolean active);
        public List <Shop>  getShopsByClubNameAndActiveStatus(String clubName,Boolean active);
        public List <Shop>  getShopsBySupervisor(String supervisorUserName);
        public List <Shop>  getShopsBySupervisorAndActiveStatus(String supervisorUserName, Boolean active);
        public List<Shop> getShopsFromSubmissionPeriod( Date fromDate, Date toDate );
        public Shop getShop(String shopId);
        public void insertShop(Shop shop);
        public void deleteShop(Shop shop);
        public void updateShop(Shop oldShop, Shop newShop);
}
