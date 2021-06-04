package sugrado.hrmsproject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sugrado.hrmsproject.business.abstracts.JobAdvertisementService;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.JobAdvertisement;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {
    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService){
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobAdvertisement>> getAll() {
        return this.jobAdvertisementService.getAll();
    }

    @GetMapping("/get-all-by-employer")
    public DataResult<List<JobAdvertisement>> getAllByEmployer(int id) {
        return this.jobAdvertisementService.getAllByEmployer(id);
    }

    @GetMapping("/get-all-by-date")
    public DataResult<List<JobAdvertisement>> getAllByApplicationDeadline(LocalDate date) {
        return this.jobAdvertisementService.getAllByApplicationDeadline(date);
    }

    @GetMapping("/getbyid")
    public DataResult<JobAdvertisement> getById(@RequestParam int id) {
        return this.jobAdvertisementService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
        return this.jobAdvertisementService.add(jobAdvertisement);
    }

    @PostMapping("/update")
    public Result update(@RequestBody JobAdvertisement jobAdvertisement) {
        return this.jobAdvertisementService.update(jobAdvertisement);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody JobAdvertisement jobAdvertisement) {
        return this.jobAdvertisementService.delete(jobAdvertisement);
    }
}
