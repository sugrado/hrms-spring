package sugrado.hrmsproject.business.concretes.candidates;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sugrado.hrmsproject.business.abstracts.candidates.CandidateImageService;
import sugrado.hrmsproject.business.constants.Messages;
import sugrado.hrmsproject.core.utilities.helpers.imageUploadHelper.CloudinaryService;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.core.utilities.results.SuccessDataResult;
import sugrado.hrmsproject.dataAccess.abstracts.candidates.CandidateImageDao;
import sugrado.hrmsproject.entities.concretes.candidates.CandidateImage;

import java.util.List;

@Service
public class CandidateImageManager implements CandidateImageService {
    private CandidateImageDao candidateImageDao;
    private CloudinaryService cloudinaryService;

    public CandidateImageManager(CandidateImageDao candidateImageDao, CloudinaryService cloudinaryService) {
        this.candidateImageDao = candidateImageDao;
        this.cloudinaryService = cloudinaryService;
    }

    @Override
    public Result add(CandidateImage candidateImage, MultipartFile file) {
        return null;
    }

    @Override
    public Result update(CandidateImage candidateImage) {
        return null;
    }

    @Override
    public Result delete(int id) {
        return null;
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
