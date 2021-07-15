package sugrado.hrmsproject.api.controllers.people;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sugrado.hrmsproject.business.abstracts.people.EmployerService;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.people.Employer;
import sugrado.hrmsproject.entities.dtos.CompareEmployerInfoDto;
import sugrado.hrmsproject.entities.dtos.EmployerUpdateRequestDto;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployersController {
    private EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService) {
        super();
        this.employerService = employerService;
    }

    @GetMapping("/getall")
    public DataResult<List<Employer>> getAll() {
        return this.employerService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<Employer> getById(int id) {
        return this.employerService.getById(id);
    }

    @GetMapping("/approve-update-request")
    public Result approveUpdateRequest(@RequestParam int employerId) {
        try {
            return this.employerService.approveUpdateRequest(employerId);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/cancel-update-request")
    public Result cancelUpdateRequest(@RequestParam int employerId) {
        return this.employerService.cancelUpdateRequest(employerId);
    }

    @GetMapping("/get-update-requests")
    public DataResult<List<CompareEmployerInfoDto>> listUpdateRequest() {
        return this.employerService.listUpdateRequest();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Employer employer) {
        return this.employerService.add(employer);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Employer employer) {
        return this.employerService.update(employer);
    }

    @PostMapping("/update-request")
    public Result updateRequest(@RequestBody EmployerUpdateRequestDto employerUpdateRequestDto) {
        return this.employerService.updateRequest(employerUpdateRequestDto);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Employer employer) {
        return this.employerService.delete(employer);
    }
}
