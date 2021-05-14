package sugrado.hrmsproject.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "verifications")
public class Verification {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "status")
	private boolean status;

	@Column(name = "date")
	private Date date;

	public Verification() {
	}

	public Verification(int id, boolean status, Date date) {
		super();
		this.id = id;
		this.status = status;
		this.date = date;
	}

}
