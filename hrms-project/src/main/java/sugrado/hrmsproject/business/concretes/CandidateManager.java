package sugrado.hrmsproject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sugrado.hrmsproject.business.abstracts.CandidateService;
import sugrado.hrmsproject.dataAccess.abstracts.CandidateDao;
import sugrado.hrmsproject.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;

	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}

	@Override
	public List<Candidate> getAll() {

		return this.candidateDao.findAll();
	}

	@Override
	public Candidate getById(int candidateId) {

		return this.candidateDao.findById(candidateId).get();
	}

	@Override
	public void add(Candidate candidate) {
		this.candidateDao.save(candidate);

	}

	@Override
	public void update(Candidate candidate) {
		this.candidateDao.save(candidate);

	}

	@Override
	public void delete(Candidate candidate) {
		this.candidateDao.delete(candidate);

	}

}
