package sugrado.hrmsproject.api.controllers.candidates;

import org.springframework.web.bind.annotation.*;
import sugrado.hrmsproject.business.abstracts.candidates.CandidateService;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.candidates.Candidate;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
public class CandidatesController {
    private final CandidateService candidateService;

    public CandidatesController(CandidateService candidateService) {
        super();
        this.candidateService = candidateService;
    }

    @GetMapping("/getall")
    public DataResult<List<Candidate>> getAll() {
        return this.candidateService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<Candidate> getById(int id) {
        return this.candidateService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Candidate candidate) {
        return this.candidateService.add(candidate);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Candidate candidate) {
        return this.candidateService.update(candidate);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Candidate candidate) {
        return this.candidateService.delete(candidate);
    }
}
