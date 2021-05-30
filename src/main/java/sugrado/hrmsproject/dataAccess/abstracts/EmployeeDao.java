package sugrado.hrmsproject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import sugrado.hrmsproject.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
