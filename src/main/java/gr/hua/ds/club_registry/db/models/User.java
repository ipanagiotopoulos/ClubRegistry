package gr.hua.ds.club_registry.db.models;

import jakarta.persistence.*;
import gr.hua.ds.club_registry.db.enums.Roles;
import lombok.Data;

@Entity
@Table(
        name="users"
)
@Data
public class User {

        @Id
        @Column(name= "username")
        private String username;

        @Column(name = "password")
        private String password;

        @Column(name = "activated")
        private Boolean activated;

        @PrimaryKeyJoinColumn
        @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private UserProfile profile;

        @Column(name = "role")
        private Roles userRole;
        //@PrimaryKeyJoinColumn
        //@OneToOne(fetch = FetchType.LAZY)
        //private Authority authority;

}
