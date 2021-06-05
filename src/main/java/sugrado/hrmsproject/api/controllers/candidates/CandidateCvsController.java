package sugrado.hrmsproject.api.controllers.candidates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sugrado.hrmsproject.business.abstracts.candidates.CandidateCvService;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.candidates.CandidateCv;

@RestController
@RequestMapping("/api/candidatecvs")
public class CandidateCvsController {
    private CandidateCvService candidateCvService;

    @Autowired
    public CandidateCvsController(CandidateCvService candidateCvService) {
        super();
        this.candidateCvService = candidateCvService;
    }

    @GetMapping("/getall")
    public Result getall() {
        return this.candidateCvService.getAll();
    }

    @GetMapping("/getbyid")
    public Result getById(@RequestParam int id) {
        return this.candidateCvService.getById(id);
    }

    @GetMapping("/getbycandidateid")
    public Result getByCandidateId(@RequestParam int id) {
        return this.candidateCvService.getByCandidateId(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody CandidateCv candidateCV) {
        return this.candidateCvService.add(candidateCV);
    }

    @PostMapping("/update")
    public Result update(@RequestBody CandidateCv candidateCV) {
        return this.candidateCvService.update(candidateCV);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody CandidateCv candidateCV) {
        return this.candidateCvService.delete(candidateCV);
    }
}
