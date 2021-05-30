package sugrado.hrmsproject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sugrado.hrmsproject.business.abstracts.VerificationByEmployeeService;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.VerificationByEmployee;

@RestController
@RequestMapping("/api/verificationsbyemployee")
public class VerificationsByEmployeeController {
    private final VerificationByEmployeeService verificationByEmployeeService;

    @Autowired
    public VerificationsByEmployeeController(VerificationByEmployeeService verificationByEmployeeService) {
        super();
        this.verificationByEmployeeService = verificationByEmployeeService;
    }

    @GetMapping("/getall")
    public DataResult<List<VerificationByEmployee>> getAll() {
        return verificationByEmployeeService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<VerificationByEmployee> getById(@RequestBody int id) {
        return verificationByEmployeeService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody VerificationByEmployee verificationByEmployee) {
        return this.verificationByEmployeeService.add(verificationByEmployee);
    }

    @PostMapping("/update")
    public Result update(@RequestBody VerificationByEmployee verificationByEmployee, int employeeId) {
        return this.verificationByEmployeeService.update(verificationByEmployee, employeeId);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody VerificationByEmployee verificationByEmployee) {
        return this.verificationByEmployeeService.delete(verificationByEmployee);
    }
}
