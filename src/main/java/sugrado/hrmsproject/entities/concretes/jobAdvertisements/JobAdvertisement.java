package sugrado.hrmsproject.entities.concretes.jobAdvertisements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sugrado.hrmsproject.entities.concretes.people.Employer;
import sugrado.hrmsproject.entities.concretes.types.City;
import sugrado.hrmsproject.entities.concretes.types.EmploymentType;
import sugrado.hrmsproject.entities.concretes.types.JobPosition;
import sugrado.hrmsproject.entities.concretes.verifications.VerificationByEmployee;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_advertisements")
public class JobAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "min_salary")
    private int minSalary;

    @Column(name = "max_salary")
    private int maxSalary;

    @Column(name = "open_position_number")
    private int openPositionNumber;

    @Column(name = "content")
    private String content;

    @Column(name = "status")
    private boolean status;

    @Column(name = "remote")
    private boolean remote;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "application_deadline")
    private LocalDate applicationDeadline;

    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne()
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

    @ManyToOne()
    @JoinColumn(name = "employment_type_id")
    private EmploymentType employmentType;

    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Employer employer;
}
