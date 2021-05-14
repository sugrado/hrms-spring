package sugrado.hrmsproject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "verifications_by_code")
public class VerificationByCode {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "employer_id")
	private int employerId;

	@Column(name = "code")
	private String code;

	public VerificationByCode() {
	}

	public VerificationByCode(int id, int employerId, String code) {
		super();
		this.id = id;
		this.employerId = employerId;
		this.code = code;
	}
}
