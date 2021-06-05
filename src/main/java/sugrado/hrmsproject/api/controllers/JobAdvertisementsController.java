package sugrado.hrmsproject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sugrado.hrmsproject.business.abstracts.JobAdvertisementService;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.JobAdvertisement;

import java.util.List;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {
    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobAdvertisement>> getAll() {
        return this.jobAdvertisementService.getAll();
    }

    @GetMapping("/get-by-employer")
    public DataResult<List<JobAdvertisement>> getAllByStatusIsTrueAndEmployerId(@RequestParam int employerId) {
        return this.jobAdvertisementService.getAllByStatusIsTrueAndEmployerId(employerId);
    }

    @GetMapping("/get-active-adverts")
    public DataResult<List<JobAdvertisement>> getAllByStatusIsTrue() {
        return this.jobAdvertisementService.getAllByStatusIsTrue();
    }

    @GetMapping("/get-by-date-sort")
    public DataResult<List<JobAdvertisement>> getAllByDateSorted() {
        return this.jobAdvertisementService.getAllByDateSorted();
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
        // TODO: Employer can set status to false
        return this.jobAdvertisementService.update(jobAdvertisement);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody JobAdvertisement jobAdvertisement) {
        return this.jobAdvertisementService.delete(jobAdvertisement);
    }
}
