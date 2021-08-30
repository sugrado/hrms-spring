package sugrado.hrmsproject.api.controllers.candidates;

import org.springframework.web.bind.annotation.*;
import sugrado.hrmsproject.business.abstracts.candidates.CandidateJobExperienceService;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.candidates.CandidateJobExperience;

@RestController
@RequestMapping("/api/candidatejobexperiences")
@CrossOrigin
public class CandidateJobExperiencesController {
    private final CandidateJobExperienceService candidateJobExperienceService;

    public CandidateJobExperiencesController(CandidateJobExperienceService candidateJobExperienceService) {
        super();
        this.candidateJobExperienceService = candidateJobExperienceService;
    }

    @GetMapping("/getall")
    public Result getall() {
        return this.candidateJobExperienceService.getAll();
    }

    @GetMapping("/getbyid")
    public Result getById(@RequestParam int id) {
        return this.candidateJobExperienceService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody CandidateJobExperience candidateJobExperience) {
        return this.candidateJobExperienceService.add(candidateJobExperience);
    }

    @PostMapping("/update")
    public Result update(@RequestBody CandidateJobExperience candidateJobExperience) {
        return this.candidateJobExperienceService.update(candidateJobExperience);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody CandidateJobExperience candidateJobExperience) {
        return this.candidateJobExperienceService.delete(candidateJobExperience);
    }
}
