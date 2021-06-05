package sugrado.hrmsproject.business.abstracts.people;

import java.util.List;

import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.people.Employee;

public interface EmployeeService {
	DataResult<List<Employee>> getAll();

	DataResult<Employee> getById(int employeeId);

	Result add(Employee employee);

	Result update(Employee employee);

	Result delete(Employee employee);
}
