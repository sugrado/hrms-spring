package sugrado.hrmsproject.api.controllers.verifications;

import org.springframework.web.bind.annotation.*;
import sugrado.hrmsproject.business.abstracts.verifications.VerificationService;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.verifications.Verification;

import java.util.List;

@RestController
@RequestMapping("/api/verifications")
@CrossOrigin
public class VerificationsController {
    private final VerificationService verificationService;

    public VerificationsController(VerificationService verificationService) {
        super();
        this.verificationService = verificationService;
    }

    @GetMapping("/getall")
    public DataResult<List<Verification>> getAll() {
        return this.verificationService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<Verification> getById(@RequestBody int id) {
        return this.verificationService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Verification verification) {
        return this.verificationService.add(verification);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Verification verification) {
        return this.verificationService.update(verification);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Verification verification) {
        return this.verificationService.delete(verification);
    }
}
