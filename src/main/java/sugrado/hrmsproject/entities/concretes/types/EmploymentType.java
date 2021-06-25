package sugrado.hrmsproject.entities.concretes.types;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sugrado.hrmsproject.entities.concretes.jobAdvertisements.JobAdvertisement;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "employment_types")
@AllArgsConstructor
@NoArgsConstructor
public class EmploymentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "employmentType")
    @JsonIgnore
    private List<JobAdvertisement> jobAdvertisements;
}
