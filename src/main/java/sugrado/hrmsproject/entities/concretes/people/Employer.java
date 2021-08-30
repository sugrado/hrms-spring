package sugrado.hrmsproject.entities.concretes.people;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sugrado.hrmsproject.core.entities.User;
import sugrado.hrmsproject.entities.concretes.jobAdvertisements.JobAdvertisement;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Employer extends User {

    @Column(name = "company_name")
    @NotBlank
    @NotNull
    private String companyName;

    @Column(name = "web_address")
    @NotBlank
    @NotNull
    private String webAddress;

    @Column(name = "phone_number")
    @NotBlank
    @NotNull
    private String phoneNumber;

    @Column(name = "new_content")
    //@Type(type = "json")
    private String newContent;

    @Column(name = "sent")
    private boolean sent;

    @JsonIgnore
    @OneToMany(mappedBy = "employer")
    private List<JobAdvertisement> jobAdvertisements;
}
