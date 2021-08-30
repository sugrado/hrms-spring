package sugrado.hrmsproject.api.controllers.people;

import org.springframework.web.bind.annotation.*;
import sugrado.hrmsproject.business.abstracts.people.EmployeeService;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.people.Employee;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin
public class EmployeesController {
    private final EmployeeService employeeService;

    public EmployeesController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    @GetMapping("/getall")
    public DataResult<List<Employee>> getAll() {
        return this.employeeService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<Employee> getById(int id) {
        return this.employeeService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Employee employee) {
        return this.employeeService.add(employee);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Employee employee) {
        return this.employeeService.update(employee);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Employee employee) {
        return this.employeeService.delete(employee);
    }
}
