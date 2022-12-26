package gr.hua.ds.club_registry.db.models;

import gr.hua.ds.club_registry.db.enums.ShopType;

import gr.hua.ds.club_registry.db.models.Club;
import jakarta.persistence.*;

import lombok.Data;
import lombok.AllArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
    @NotBlank
    @Column(name = "id")
    private String  ShopId;

    @Column(name = "active")
    @NotBlank(message = "Active should be 'true' or 'false'")
    private Boolean active;

    @Column(name = "city")
    @NotBlank(message = "City should not be empty or null")
    @Pattern(regexp = "[a-zA-Z\\s']+", message = "Alphabetical characters are only allowed")
    @Size(min=2, max=80)
    private String city;

    @Column(name = "address")
    @NotBlank(message = "Address should not be empty or null")
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "shop_type", columnDefinition="ENUM('ROOM','SHOP'")
    @NotBlank(message = "Shop Type should be either 'SHOP' or 'ROOM'")
    private ShopType shopType;

    @ManyToOne
    @JoinColumn(name="tax_no", nullable=false)
    private Club club;


    public Shop() {

    }
}
