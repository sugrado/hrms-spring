package sugrado.hrmsproject.api.controllers.types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sugrado.hrmsproject.business.abstracts.types.EmploymentTypeService;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.types.EmploymentType;

import java.util.List;

@RestController
@RequestMapping("/api/employmenttypes")
@CrossOrigin
public class EmploymentTypesController {
    private EmploymentTypeService employmentTypeService;

    @Autowired
    public EmploymentTypesController(EmploymentTypeService employmentTypeService) {
        this.employmentTypeService = employmentTypeService;
    }

    @GetMapping("/getall")
    public DataResult<List<EmploymentType>> getAll() {
        return this.employmentTypeService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<EmploymentType> getById(@RequestParam int id) {
        return this.employmentTypeService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody EmploymentType employmentType) {
        return this.employmentTypeService.add(employmentType);
    }

    @PutMapping("/update")
    public Result update(@RequestBody EmploymentType employmentType) {
        return this.employmentTypeService.update(employmentType);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody EmploymentType employmentType) {
        return this.employmentTypeService.delete(employmentType);
    }
}
