package sugrado.hrmsproject.api.controllers.candidates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sugrado.hrmsproject.business.abstracts.candidates.CandidateLanguageService;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.candidates.CandidateLanguage;

@RestController
@RequestMapping("/api/candidatelanguages")
@CrossOrigin
public class CandidateLanguagesController {
    private CandidateLanguageService candidateLanguageService;

    @Autowired
    public CandidateLanguagesController(CandidateLanguageService candidateLanguageService) {
        super();
        this.candidateLanguageService = candidateLanguageService;
    }

    @GetMapping("/getall")
    public Result getall() {
        return this.candidateLanguageService.getAll();
    }

    @GetMapping("/getbyid")
    public Result getById(@RequestParam int id) {
        return this.candidateLanguageService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody CandidateLanguage candidateLanguage) {
        return this.candidateLanguageService.add(candidateLanguage);
    }

    @PostMapping("/update")
    public Result update(@RequestBody CandidateLanguage candidateLanguage) {
        return this.candidateLanguageService.update(candidateLanguage);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody CandidateLanguage candidateLanguage) {
        return this.candidateLanguageService.delete(candidateLanguage);
    }
}
