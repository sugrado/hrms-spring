package sugrado.hrmsproject.entities.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sugrado.hrmsproject.entities.concretes.candidates.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateCvPreviewDto {
    private String githubProfile;
    private String linkedinProfile;
    private String content;
    private String abilities;

    @JsonIgnoreProperties({"candidate", "githubProfile","linkedinProfile","content", "abilities"})
    private CandidateCv candidateCv;

    @JsonIgnoreProperties({"candidateCv", "password"})
    private Candidate candidate;

    @JsonIgnoreProperties({"candidateCv"})
    private CandidateImage candidateImage;

    @JsonIgnoreProperties({"candidateCv"})
    private List<CandidateEducation> candidateEducations;

    @JsonIgnoreProperties({"candidateCv"})
    private List<CandidateLanguage> candidateLanguages;

    @JsonIgnoreProperties({"candidateCv"})
    private List<CandidateJobExperience> candidateJobExperiences;
}
