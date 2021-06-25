package sugrado.hrmsproject.entities.concretes.candidates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "candidate_images")
public class CandidateImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "image_path")
    private String imagePath;

    @OneToOne()
    @JoinColumn(name = "candidate_cv_id")
    private CandidateCv candidateCv;

    public CandidateImage(String imagePath, CandidateCv candidateCv) {
        this.imagePath = imagePath;
        this.candidateCv = candidateCv;
    }
}
