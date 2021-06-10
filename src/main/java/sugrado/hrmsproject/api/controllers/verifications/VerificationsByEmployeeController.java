package sugrado.hrmsproject.api.controllers.verifications;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sugrado.hrmsproject.business.abstracts.verifications.VerificationByEmployeeService;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.verifications.VerificationByEmployee;

@RestController
@RequestMapping("/api/verificationsbyemployee")
@CrossOrigin
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
