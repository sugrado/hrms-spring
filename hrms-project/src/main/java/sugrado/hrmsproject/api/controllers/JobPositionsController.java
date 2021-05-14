package sugrado.hrmsproject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sugrado.hrmsproject.business.abstracts.JobPositionService;
import sugrado.hrmsproject.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController {
	private JobPositionService jobPositionService;

	@Autowired
	public JobPositionsController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}

	@GetMapping("/getall")
	public List<JobPosition> getAll() {
		return this.jobPositionService.getAll();
	}

	@GetMapping("/getbyid")
	public JobPosition getById(int id) {
		return this.jobPositionService.getById(id);
	}

	@PostMapping("/add")
	public void add(@RequestBody JobPosition jobPosition) {
		this.jobPositionService.add(jobPosition);
	}

	@PostMapping("/update")
	public void update(@RequestBody JobPosition jobPosition) {
		this.jobPositionService.update(jobPosition);
	}

	@PostMapping("/delete")
	public void delete(@RequestBody JobPosition jobPosition) {
		this.jobPositionService.delete(jobPosition);
	}
}
