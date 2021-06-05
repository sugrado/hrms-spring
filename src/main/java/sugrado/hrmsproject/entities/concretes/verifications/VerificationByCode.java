package sugrado.hrmsproject.entities.concretes.verifications;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "verifications_by_code")
@PrimaryKeyJoinColumn(name = "id")
@AllArgsConstructor
@NoArgsConstructor
public class VerificationByCode extends  Verification{

	@Column(name = "user_id")
	private int userId;

	@Column(name = "code")
	private String code;
}
