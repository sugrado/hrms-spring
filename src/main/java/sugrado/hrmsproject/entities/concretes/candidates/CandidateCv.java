package sugrado.hrmsproject.entities.concretes.candidates;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="candidate_cvs")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidateEducations","candidateJobExperiences", "candidateLanguages", "candidateImage"})
public class CandidateCv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @OneToOne
    @JoinColumn(name="candidate_id")
    @JsonIgnoreProperties({"password", "identificationNumber"})
    private Candidate candidate;

    @Column(name = "github_profile")
    private String githubProfile;

    @Column(name = "linkedin_profile")
    private String linkedinProfile;

    @Column(name = "content")
    private String content;

    @Column(name = "abilities")
    private String abilities;

    @OneToOne(mappedBy = "candidateCv", cascade = CascadeType.ALL)
    private CandidateImage candidateImage;

    @OneToMany(mappedBy = "candidateCv", cascade = CascadeType.ALL)
    private List<CandidateJobExperience> candidateJobExperiences;

    @OneToMany(mappedBy = "candidateCv", cascade = CascadeType.ALL)
    private List<CandidateEducation> candidateEducations;

    @OneToMany(mappedBy = "candidateCv", cascade = CascadeType.ALL)
    private List<CandidateLanguage> candidateLanguages;
}
