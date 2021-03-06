package sugrado.hrmsproject.api.controllers.candidates;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sugrado.hrmsproject.business.abstracts.candidates.CandidateImageService;
import sugrado.hrmsproject.core.utilities.results.Result;

@RestController
@RequestMapping("/api/candidateImages")
@CrossOrigin
public class CandidateImagesController {
    private final CandidateImageService candidateImageService;

    private CandidateImagesController(CandidateImageService candidateImageService) {
        this.candidateImageService = candidateImageService;
    }

    @PostMapping("/add")
    public Result add(int candidateCvId, MultipartFile file) {
        return this.candidateImageService.add(candidateCvId, file);
    }

    @GetMapping("/getall")
    public Result getAll() {
        return this.candidateImageService.getAll();
    }

    @GetMapping("/getbyid")
    public Result getById(@RequestParam int id) {
        return this.candidateImageService.getById(id);
    }

    @GetMapping("/getbycandidatecvid")
    public Result getByCandidateCvId(@RequestParam int id) {
        return this.candidateImageService.getByCandidateCvId(id);
    }
}
