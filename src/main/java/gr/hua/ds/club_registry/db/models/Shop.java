package gr.hua.ds.club_registry.db.models;

import gr.hua.ds.club_registry.db.enums.ShopType;

import gr.hua.ds.club_registry.db.models.Club;
import jakarta.persistence.*;

import lombok.Data;
import lombok.AllArgsConstructor;

@Entity
@Table(
        name="shops",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"address"})
)
@AllArgsConstructor
@Data
public class Shop {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private String  ShopId;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "active")
    private String city;

    @Column(name = "address")
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "shop_type", columnDefinition="ENUM('ROOM','SHOP'")
    private ShopType shopType;

    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL,
            mappedBy = "user_profile")
    private Club club;


    public Shop() {

    }
}
