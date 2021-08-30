package sugrado.hrmsproject.entities.concretes.verifications;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import sugrado.hrmsproject.entities.concretes.types.VerificationTypeEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

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
