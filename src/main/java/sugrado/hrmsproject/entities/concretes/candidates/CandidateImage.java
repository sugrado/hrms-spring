package sugrado.hrmsproject.entities.concretes.candidates;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
}
