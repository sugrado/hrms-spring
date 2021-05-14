package sugrado.hrmsproject.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "email_address")
	private String emailAddress;

	@Column(name = "password")
	private String password;

	public User() {
	}

	public User(int id, String emailAddress, String password) {
		super();
		this.id = id;
		this.emailAddress = emailAddress;
		this.password = password;
	}
}
