package sugrado.hrmsproject.entities.concretes.candidates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sugrado.hrmsproject.entities.concretes.jobAdvertisements.JobAdvertisement;

import javax.persistence.*;

@Data
@Entity
@Table(name = "favourites")
@AllArgsConstructor
@NoArgsConstructor
public class Favourite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "job_ad_id")
    private JobAdvertisement jobAdvertisement;

    @ManyToOne()
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
}
