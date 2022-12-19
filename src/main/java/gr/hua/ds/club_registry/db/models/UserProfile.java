package gr.hua.ds.club_registry.db.models;


import gr.hua.ds.club_registry.db.models.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(
        name="user_profiles",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"tax_no", "club_name"})
)
@AllArgsConstructor
@Data
public class UserProfile {

    @Id
    @Column(name= "username")
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL,
            mappedBy = "user_profile")
    private User user;
    public UserProfile() {

    }
}
