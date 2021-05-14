package sugrado.hrmsproject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sugrado.hrmsproject.business.abstracts.CandidateService;
import sugrado.hrmsproject.entities.concretes.Candidate;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {
	private CandidateService candidateService;

	@Autowired
	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}

	@GetMapping("/getall")
	public List<Candidate> getAll() {
		return this.candidateService.getAll();
	}

	@GetMapping("/getbyid")
	public Candidate getById(int id) {
		return this.candidateService.getById(id);
	}

	@PostMapping("/add")
	public void add(@RequestBody Candidate candidate) {
		this.candidateService.add(candidate);
	}

	@PostMapping("/update")
	public void update(@RequestBody Candidate candidate) {
		this.candidateService.update(candidate);
	}

	@PostMapping("/delete")
	public void delete(@RequestBody Candidate candidate) {
		this.candidateService.delete(candidate);
	}
}
