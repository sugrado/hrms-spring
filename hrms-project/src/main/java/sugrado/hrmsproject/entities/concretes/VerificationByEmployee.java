package sugrado.hrmsproject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "verifications_by_employee")
public class VerificationByEmployee {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "employer_id")
	private int employerId;

	@Column(name = "employee_id")
	private int employeeId;

	public VerificationByEmployee() {
	}

	public VerificationByEmployee(int id, int employerId, int employeeId) {
		super();
		this.id = id;
		this.employerId = employerId;
		this.employeeId = employeeId;
	}
}
