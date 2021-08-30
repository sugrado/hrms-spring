package sugrado.hrmsproject.api.controllers.verifications;

import org.springframework.web.bind.annotation.*;
import sugrado.hrmsproject.business.abstracts.verifications.VerificationByEmployeeService;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.verifications.VerificationByEmployee;

@RestController
@RequestMapping("/api/verificationsbyemployee")
@CrossOrigin
public class VerificationsByEmployeeController {
    private final VerificationByEmployeeService verificationByEmployeeService;

    public VerificationsByEmployeeController(VerificationByEmployeeService verificationByEmployeeService) {
        super();
        this.verificationByEmployeeService = verificationByEmployeeService;
    }

    @PostMapping("/approve")
    public Result approve(@RequestBody VerificationByEmployee verificationByEmployee) {
        return this.verificationByEmployeeService.approve(verificationByEmployee);
    }
}
