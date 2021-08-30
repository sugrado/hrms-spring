package sugrado.hrmsproject.entities.concretes.candidates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sugrado.hrmsproject.entities.concretes.types.Language;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "candidate_languages")
public class CandidateLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "level")
    @NotNull
    @NotBlank
    private int level;

    @ManyToOne()
    @JoinColumn(name = "language_id")
    private Language language;

    @JoinColumn(name = "candidate_cv_id")
    @ManyToOne(targetEntity = CandidateCv.class)
    private CandidateCv candidateCv;
}
