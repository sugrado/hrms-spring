package sugrado.hrmsproject.api.controllers.candidates;

import org.springframework.web.bind.annotation.*;
import sugrado.hrmsproject.business.abstracts.candidates.CandidateEducationService;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.candidates.CandidateEducation;

@RestController
@RequestMapping("/api/candidateeducations")
@CrossOrigin
public class CandidateEducationsController {
    private final CandidateEducationService candidateEducationService;

    public CandidateEducationsController(CandidateEducationService candidateEducationService) {
        super();
        this.candidateEducationService = candidateEducationService;
    }

    @GetMapping("/getall")
    public Result getall() {
        return this.candidateEducationService.getAll();
    }

    @GetMapping("/getbyid")
    public Result getById(@RequestParam int id) {
        return this.candidateEducationService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody CandidateEducation candidateEducation) {
        return this.candidateEducationService.add(candidateEducation);
    }

    @PostMapping("/update")
    public Result update(@RequestBody CandidateEducation candidateEducation) {
        return this.candidateEducationService.update(candidateEducation);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody CandidateEducation candidateEducation) {
        return this.candidateEducationService.delete(candidateEducation);
    }
}
