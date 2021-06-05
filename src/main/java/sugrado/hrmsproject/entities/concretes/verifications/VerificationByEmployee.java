package sugrado.hrmsproject.entities.concretes.verifications;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "verifications_by_employee")
@PrimaryKeyJoinColumn(name = "id")
@AllArgsConstructor
@NoArgsConstructor
public class VerificationByEmployee extends Verification {

	@Column(name = "employer_id")
	private int employerId;

	@Column(name = "employee_id")
	private Integer employeeId;
}
