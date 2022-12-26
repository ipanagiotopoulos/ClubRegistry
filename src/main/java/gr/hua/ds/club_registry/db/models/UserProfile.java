package gr.hua.ds.club_registry.db.models;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(
        name="user_profiles"
)
@AllArgsConstructor
@Data
public class UserProfile {

    @Id
    @Column(name= "username")
    @NotBlank(message = "Username should not be null")
    @Size(min = 4, max=25)
    @Pattern(regexp = "[a-zA-Z0-9']+", message ="Only alphanumeric characters allowed!")
    private String username;

    @Column(name = "first_name")
    @NotBlank(message = "First name should be null")
    @Pattern(regexp = "[a-zA-Z]", message = "Only alphabetic characters allowed")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "Last name should be null")
    @Pattern(regexp = "[a-zA-Z]", message = "Only alphabetic characters allowed")
    private String lastName;

    @Column(name = "email")
    @Email(message = "email format is xxxx@xxx.xx")
    private String email;

    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL,
            mappedBy = "profile")
    private User user;

    public UserProfile() {

    }
}
