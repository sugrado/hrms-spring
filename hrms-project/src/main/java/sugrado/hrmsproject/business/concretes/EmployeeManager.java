package sugrado.hrmsproject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sugrado.hrmsproject.business.abstracts.EmployeeService;
import sugrado.hrmsproject.dataAccess.abstracts.EmployeeDao;
import sugrado.hrmsproject.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService{

	private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	@Override
	public List<Employee> getAll() {
		return this.employeeDao.findAll();
	}

	@Override
	public Employee getById(int employeeId) {
		return this.employeeDao.findById(employeeId).get();
	}

	@Override
	public void add(Employee employee) {
		this.employeeDao.save(employee);
	}

	@Override
	public void update(Employee employee) {
		this.employeeDao.save(employee);
	}

	@Override
	public void delete(Employee employee) {
		this.employeeDao.delete(employee);
	}

}
