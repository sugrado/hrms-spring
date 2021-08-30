package sugrado.hrmsproject.api.controllers.types;

import org.springframework.web.bind.annotation.*;
import sugrado.hrmsproject.business.abstracts.types.JobPositionService;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.types.JobPosition;

import java.util.List;

@RestController
@RequestMapping("/api/jobpositions")
@CrossOrigin
public class JobPositionsController {
    private final JobPositionService jobPositionService;

    public JobPositionsController(JobPositionService jobPositionService) {
        super();
        this.jobPositionService = jobPositionService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobPosition>> getAll() {
        return this.jobPositionService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<JobPosition> getById(int id) {
        return this.jobPositionService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobPosition jobPosition) {
        return this.jobPositionService.add(jobPosition);
    }

    @PostMapping("/update")
    public Result update(@RequestBody JobPosition jobPosition) {
        return this.jobPositionService.update(jobPosition);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody JobPosition jobPosition) {
        return this.jobPositionService.delete(jobPosition);
    }
}

