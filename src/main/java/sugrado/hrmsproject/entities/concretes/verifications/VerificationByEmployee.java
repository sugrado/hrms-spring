package sugrado.hrmsproject.entities.concretes.verifications;

import javax.persistence.*;

import lombok.*;
import sugrado.hrmsproject.entities.concretes.types.VerificationTypeEnum;

@Data
@Entity
@Table(name = "verifications_by_employee")
@PrimaryKeyJoinColumn(name = "id")
@RequiredArgsConstructor
@NoArgsConstructor
public class VerificationByEmployee extends Verification {

	@Column(name = "entity_id")
	@NonNull
	private int entityId;

	@Column(name = "verification_type")
	@NonNull
	private VerificationTypeEnum verificationType;

	@Column(name = "employee_id")
	private Integer employeeId;
}
