package sugrado.hrmsproject.dataAccess.abstracts.people;

import org.springframework.data.jpa.repository.JpaRepository;

import sugrado.hrmsproject.entities.concretes.people.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
