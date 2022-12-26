package gr.hua.ds.club_registry.db.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(
        name="clubs",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"tax_no", "club_name"})
)
@AllArgsConstructor
@Data
public class Club {

    @Id
    @Column(name="tax_no")
    @NotBlank(message = "Tax number should contain 12 digits")
    @Size(min=12, max = 12,message = "Tax number should be 12 digits")
    @Pattern(regexp = "['0-9']", message = "Only number as an input")
    private String taxNo;

    @Column(name="club_name")
    @NotBlank(message="Club Name shouldn't be empty or null")
    @Size(min=3, max=80,message = "Available charachter limit is from 3 to 80")
    private String clubName;

    @OneToMany(mappedBy="club")
    private Set<Shop> shops;

    @Column(name="submission_date")
    @NotBlank(message = "Date should not be empty")
    @PastOrPresent(message = "Data should be past or present!")
    private java.sql.Date  submissionDate;

    @Column(name="active")
    @NotBlank(message = "Active should have the value 'true' or 'false'")
    private Boolean active;

    @Column(name="team_name")
    @NotBlank(message = "Team name should not be null or empty")
    @Size(min=3, max=80)
    private String teamName;

    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL,
            mappedBy = "associated_club")
    private User superVisor;

    public Club() {

    }

}
