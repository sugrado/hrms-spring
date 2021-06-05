package sugrado.hrmsproject.api.controllers.candidates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sugrado.hrmsproject.business.abstracts.candidates.CandidateCvService;
import sugrado.hrmsproject.business.abstracts.candidates.CandidateImageService;
import sugrado.hrmsproject.core.utilities.results.Result;

@RestController
@RequestMapping("/api/candidateImages")
public class CandidateImagesController {
    private CandidateImageService candidateImageService;

    @Autowired
    private CandidateImagesController(CandidateImageService candidateImageService){
        this.candidateImageService = candidateImageService;
    }

    @GetMapping("/getall")
    public Result getAll() {
        return this.candidateImageService.getAll();
    }

    @GetMapping("/getbyid")
    public Result getById(@RequestParam int id) {
        return this.candidateImageService.getById(id);
    }

    @GetMapping("/getbycandidateid")
    public Result getByCandidateId(@RequestParam int id) {
        return this.candidateImageService.getByCandidateId(id);
    }
}
