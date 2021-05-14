package sugrado.hrmsproject.business.abstracts;

import java.util.List;

import sugrado.hrmsproject.entities.concretes.Employee;

public interface EmployeeService {
	List<Employee> getAll();

	Employee getById(int employeeId);

	void add(Employee employee);

	void update(Employee employee);

	void delete(Employee employee);
}
