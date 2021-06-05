package sugrado.hrmsproject.api.controllers.candidates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sugrado.hrmsproject.business.abstracts.candidates.CandidateEducationService;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.candidates.CandidateEducation;

@RestController
@RequestMapping("/api/candidateeducations")
public class CandidateEducationsController {
    private CandidateEducationService candidateEducationService;

    @Autowired
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
