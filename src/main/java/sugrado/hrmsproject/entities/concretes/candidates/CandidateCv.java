package sugrado.hrmsproject.entities.concretes.candidates;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="candidate_cvs")
public class CandidateCv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @Column(name = "github_profile")
    private String githubProfile;

    @Column(name = "linkedin_profile")
    private String linkedinProfile;

    @Column(name = "content")
    private String content;

    @Column(name = "abilities")
    private String abilities;

    @OneToMany(mappedBy = "candidateCV")
    @JsonIgnore
    private List<CandidateJobExperience> candidateJobExperiences;

    @OneToMany(mappedBy = "candidateCV")
    @JsonIgnore
    private List<CandidateEducation> candidateEducations;

    @OneToMany(mappedBy = "candidateCV")
    @JsonIgnore
    private List<CandidateLanguage> candidateLanguages;
}
