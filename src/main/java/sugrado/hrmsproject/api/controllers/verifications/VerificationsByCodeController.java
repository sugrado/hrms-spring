package sugrado.hrmsproject.api.controllers.verifications;

import org.springframework.web.bind.annotation.*;
import sugrado.hrmsproject.business.abstracts.verifications.VerificationByCodeService;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.verifications.VerificationByCode;

@RestController
@RequestMapping("/api/verificationsbycode")
@CrossOrigin
public class VerificationsByCodeController {
    private final VerificationByCodeService verificationByCodeService;

    public VerificationsByCodeController(VerificationByCodeService verificationByCodeService) {
        super();
        this.verificationByCodeService = verificationByCodeService;
    }

    @PostMapping("/approve")
    public Result approve(@RequestBody VerificationByCode verificationByCode) {
        return this.verificationByCodeService.approve(verificationByCode);
    }
}
