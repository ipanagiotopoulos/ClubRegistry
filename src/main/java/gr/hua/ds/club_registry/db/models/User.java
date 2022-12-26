package gr.hua.ds.club_registry.db.models;

import jakarta.persistence.*;
import gr.hua.ds.club_registry.db.enums.Roles;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(
        name="users"
)
@Data
public class User {

        @Id
        @Column(name= "username")
        @NotBlank(message = "Username should not be null")
        @Size(min = 4, max=25)
        @Pattern(regexp = "[a-zA-Z0-9']+", message ="Only alphanumeric characters allowed!")
        private String username;

        @Column(name = "password")
        @NotBlank(message = "Password should not be null or empty!")
        @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$",
                message = "Password must contain at least one digit [0-9].\n"
                + "Password must contain at least one lowercase Latin character [a-z].\n" +
                "Password must contain at least one uppercase Latin character [A-Z].\n" +
                "Password must contain at least one special character like ! @ # & ( ).\n" +
                "Password must contain a length of at least 8 characters and a maximum of 20 characters")
        @Size(min=7,max=30)
        private String password;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "tax_no_club", referencedColumnName = "tax_no")
        private Club associated_club;

        @Column(name = "activated")
        @NotBlank(message = "Activated should be 'true' or 'false'")
        private Boolean activated;

        @PrimaryKeyJoinColumn(name = "username", referencedColumnName = "username")
        @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @NotBlank
        private UserProfile profile;

        @Column(name = "role")
        @NotBlank
        private Roles userRole;

}
