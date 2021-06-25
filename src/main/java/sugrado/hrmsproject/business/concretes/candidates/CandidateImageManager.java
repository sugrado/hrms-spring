package sugrado.hrmsproject.business.concretes.candidates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sugrado.hrmsproject.business.abstracts.candidates.CandidateCvService;
import sugrado.hrmsproject.business.abstracts.candidates.CandidateImageService;
import sugrado.hrmsproject.business.constants.Messages;
import sugrado.hrmsproject.business.adapters.cloudinaryAdapter.CloudinaryService;
import sugrado.hrmsproject.core.utilities.results.*;
import sugrado.hrmsproject.dataAccess.abstracts.candidates.CandidateImageDao;
import sugrado.hrmsproject.entities.concretes.candidates.CandidateImage;

import java.util.List;
import java.util.Map;

@Service
public class CandidateImageManager implements CandidateImageService {
    private CandidateCvService candidateCvService;
    private CandidateImageDao candidateImageDao;
    private CloudinaryService cloudinaryService;

    @Autowired
    public CandidateImageManager(@Lazy CandidateCvService candidateCvService,
                                 CandidateImageDao candidateImageDao,
                                 CloudinaryService cloudinaryService) {
        this.candidateCvService = candidateCvService;
        this.candidateImageDao = candidateImageDao;
        this.cloudinaryService = cloudinaryService;
    }

    @Override
    public Result add(int candidateId, MultipartFile file) {
        var candidateCv = this.candidateCvService.getByCandidateId(candidateId);

        if (candidateCv.getData() == null)
            return new ErrorResult(Messages.notFound);

        Map<String, String> result = this.cloudinaryService.uploadImage(file).getData();
        var candidateImg = new CandidateImage(result.get("url"), candidateCv.getData());
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
    public DataResult<CandidateImage> getByCandidateCvId(int id) {
        return new SuccessDataResult<CandidateImage>(this.candidateImageDao.getByCandidateCvId(id), Messages.listed);
    }
}
