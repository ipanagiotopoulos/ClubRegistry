package gr.hua.ds.club_registry.db.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

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
    private String taxNo;

    @Column(name="club_name")
    private String clubName;

    @Column(name="submission_date")
    private java.sql.Date  submissionDate;

    @Column(name="active")
    private Boolean active;

    @Column(name="team_name")
    private String teamName;

    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL,
            mappedBy = "user_profile")
    private User superVisor;

    public Club() {

    }

}
