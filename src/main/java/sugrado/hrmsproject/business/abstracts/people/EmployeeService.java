package sugrado.hrmsproject.business.abstracts.people;

import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.people.Employee;

import java.util.List;

public interface EmployeeService {
    DataResult<List<Employee>> getAll();

    DataResult<Employee> getById(int employeeId);

    Result add(Employee employee);

    Result update(Employee employee);

    Result delete(Employee employee);
}
