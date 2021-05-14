package sugrado.hrmsproject.business.abstracts;

import java.util.List;

import sugrado.hrmsproject.entities.concretes.Candidate;

public interface CandidateService {
	List<Candidate> getAll();

	Candidate getById(int candidateId);

	void add(Candidate candidate);

	void update(Candidate candidate);

	void delete(Candidate candidate);
}
