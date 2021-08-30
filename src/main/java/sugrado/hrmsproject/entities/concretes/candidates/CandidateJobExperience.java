package sugrado.hrmsproject.entities.concretes.candidates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "candidate_job_experiences")
public class CandidateJobExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "workplace_name")
    @NotNull
    @NotBlank
    private String workplaceName;

    @Column(name = "position_name")
    @NotNull
    @NotBlank
    private String positionName;

    @Column(name = "start_year")
    @NotNull
    @NotBlank
    private LocalDate startYear;

    @Column(name = "departure_date")
    private LocalDate departureDate;

    @JoinColumn(name = "candidate_cv_id")
    @ManyToOne(targetEntity = CandidateCv.class)
    private CandidateCv candidateCv;
}
