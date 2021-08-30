package sugrado.hrmsproject.business.concretes.candidates;

import org.springframework.stereotype.Service;
import sugrado.hrmsproject.business.abstracts.candidates.*;
import sugrado.hrmsproject.business.constants.Messages;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.core.utilities.results.SuccessDataResult;
import sugrado.hrmsproject.core.utilities.results.SuccessResult;
import sugrado.hrmsproject.dataAccess.abstracts.candidates.CandidateCvDao;
import sugrado.hrmsproject.entities.concretes.candidates.CandidateCv;
import sugrado.hrmsproject.entities.dtos.CandidateCvPreviewDto;

import java.util.List;

@Service
public class CandidateCvManager implements CandidateCvService {
    private final CandidateCvDao candidateCvDao;
    private final CandidateService candidateService;
    private final CandidateImageService candidateImageService;
    private final CandidateEducationService candidateEducationService;
    private final CandidateJobExperienceService candidateJobExperienceService;
    private final CandidateLanguageService candidateLanguageService;

    public CandidateCvManager(CandidateCvDao candidateCvDao,
                              CandidateService candidateService,
                              CandidateImageService candidateImageService,
                              CandidateEducationService candidateEducationService,
                              CandidateJobExperienceService candidateJobExperienceService,
                              CandidateLanguageService candidateLanguageService) {
        this.candidateCvDao = candidateCvDao;
        this.candidateService = candidateService;
        this.candidateEducationService = candidateEducationService;
        this.candidateImageService = candidateImageService;
        this.candidateJobExperienceService = candidateJobExperienceService;
        this.candidateLanguageService = candidateLanguageService;
    }

    @Override
    public Result add(CandidateCv candidateCv) {
        this.candidateCvDao.save(candidateCv);
        return new SuccessResult(Messages.added);
    }

    @Override
    public Result update(CandidateCv candidateCv) {
        this.candidateCvDao.save(candidateCv);
        return new SuccessResult(Messages.updated);
    }

    @Override
    public Result delete(CandidateCv candidateCv) {
        this.candidateCvDao.delete(candidateCv);
        return new SuccessResult(Messages.deleted);
    }

    @Override
    public DataResult<List<CandidateCv>> getAll() {
        return new SuccessDataResult<List<CandidateCv>>(this.candidateCvDao.findAll(), Messages.listed);
    }

    @Override
    public DataResult<CandidateCv> getById(int id) {
        return new SuccessDataResult<CandidateCv>(this.candidateCvDao.findById(id).get(), Messages.listed);
    }

    @Override
    public DataResult<CandidateCv> getByCandidateId(int candidateId) {
        return new SuccessDataResult<CandidateCv>(this.candidateCvDao.getByCandidateId(candidateId), Messages.listed);
    }

    @Override
    public DataResult<CandidateCvPreviewDto> getDetailsByCandidateId(int candidateId) {
        var cv = this.candidateCvDao.getByCandidateId(candidateId);
        var candidate = this.candidateService.getById(candidateId).getData();
        var educations = this.candidateEducationService.getAllByCandidateCvId(cv.getId()).getData();
        var image = this.candidateImageService.getByCandidateCvId(cv.getId()).getData();
        var languages = this.candidateLanguageService.getAllByCandidateCvId(cv.getId()).getData();
        var experiences = this.candidateJobExperienceService.getAllByCandidateCvId(cv.getId()).getData();
        var candidateCvPreviewDto = new CandidateCvPreviewDto(cv.getGithubProfile(),
                cv.getLinkedinProfile(),
                cv.getContent(),
                cv.getAbilities(),
                cv,
                candidate,
                image,
                educations,
                languages,
                experiences);
        return new SuccessDataResult<CandidateCvPreviewDto>(candidateCvPreviewDto, Messages.listed);
    }
}
