package sugrado.hrmsproject.business.concretes.candidates;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sugrado.hrmsproject.business.abstracts.candidates.CandidateImageService;
import sugrado.hrmsproject.business.abstracts.candidates.CandidateService;
import sugrado.hrmsproject.business.constants.Messages;
import sugrado.hrmsproject.core.adapters.cloudinaryAdapter.CloudinaryService;
import sugrado.hrmsproject.core.utilities.results.*;
import sugrado.hrmsproject.dataAccess.abstracts.candidates.CandidateImageDao;
import sugrado.hrmsproject.entities.concretes.candidates.CandidateImage;

import java.util.List;
import java.util.Map;

@Service
public class CandidateImageManager implements CandidateImageService {
    private CandidateService candidateService;
    private CandidateImageDao candidateImageDao;
    private CloudinaryService cloudinaryService;

    public CandidateImageManager(CandidateService candidateService,
                                 CandidateImageDao candidateImageDao,
                                 CloudinaryService cloudinaryService) {
        this.candidateService = candidateService;
        this.candidateImageDao = candidateImageDao;
        this.cloudinaryService = cloudinaryService;
    }

    @Override
    public Result add(int candidateId, MultipartFile file) {
        var candidate = this.candidateService.getById(candidateId);

        if (candidate.getData() == null)
            return new ErrorResult(Messages.notFound);

        Map<String, String> result = this.cloudinaryService.uploadImage(file).getData();
        var candidateImg = new CandidateImage(result.get("url"), candidate.getData());
        this.candidateImageDao.save(candidateImg);
        return new SuccessResult(Messages.added);
    }

    @Override
    public DataResult<CandidateImage> getById(int id) {
        return new SuccessDataResult<CandidateImage>(this.candidateImageDao.getById(id), Messages.listed);
    }

    @Override
    public DataResult<List<CandidateImage>> getAll() {
        return new SuccessDataResult<List<CandidateImage>>(this.candidateImageDao.findAll(), Messages.listed);
    }

    @Override
    public DataResult<CandidateImage> getByCandidateId(int id) {
        return new SuccessDataResult<CandidateImage>(this.candidateImageDao.getByCandidateId(id), Messages.listed);
    }
}
