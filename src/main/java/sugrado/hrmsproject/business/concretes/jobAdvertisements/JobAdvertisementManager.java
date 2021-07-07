package sugrado.hrmsproject.business.concretes.jobAdvertisements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sugrado.hrmsproject.business.abstracts.jobAdvertisements.JobAdvertisementService;
import sugrado.hrmsproject.business.abstracts.verifications.VerificationByEmployeeService;
import sugrado.hrmsproject.business.constants.Messages;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.core.utilities.results.SuccessDataResult;
import sugrado.hrmsproject.core.utilities.results.SuccessResult;
import sugrado.hrmsproject.dataAccess.abstracts.jobAdvertisements.JobAdvertisementDao;
import sugrado.hrmsproject.entities.concretes.jobAdvertisements.JobAdvertisement;
import sugrado.hrmsproject.entities.concretes.types.VerificationTypeEnum;
import sugrado.hrmsproject.entities.concretes.verifications.VerificationByEmployee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private JobAdvertisementDao jobAdvertisementDao;
    private VerificationByEmployeeService verificationByEmployeeService;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, VerificationByEmployeeService verificationByEmployeeService) {
        this.jobAdvertisementDao = jobAdvertisementDao;
        this.verificationByEmployeeService = verificationByEmployeeService;
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        jobAdvertisement.setStatus(true);
        this.jobAdvertisementDao.save(jobAdvertisement);
        var verificationByEmployee =
                new VerificationByEmployee(jobAdvertisement.getId(), VerificationTypeEnum.JobAdvertisement);
        this.verificationByEmployeeService.add(verificationByEmployee);
        return new SuccessResult(Messages.added);
    }

    @Override
    public Result update(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult(Messages.updated);
    }

    @Override
    public Result delete(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.delete(jobAdvertisement);
        return new SuccessResult(Messages.deleted);
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>
                (this.jobAdvertisementDao.findAll(), Messages.listed);
    }

    @Override
    public DataResult<JobAdvertisement> getById(int id) {
        return new SuccessDataResult<JobAdvertisement>
                (this.jobAdvertisementDao.getAllById(id), Messages.listed);
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllByStatusIsTrueAndEmployerId(int employerId) {
        return new SuccessDataResult<List<JobAdvertisement>>
                (this.jobAdvertisementDao.getAllByStatusIsTrueAndEmployerId(employerId), Messages.listed);
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllByDateSorted() {
        Sort sortedList = Sort.by(Sort.Direction.ASC, "releaseDate");
        return new SuccessDataResult<List<JobAdvertisement>>
                (this.jobAdvertisementDao.findAll(sortedList), Messages.listed);
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllByStatusIsTrue() {
        return new SuccessDataResult<List<JobAdvertisement>>
                (this.jobAdvertisementDao.getAllByStatusIsTrue(), Messages.listed);
    }

    @Override
    public DataResult<List<JobAdvertisement>> getApprovedAdvertisements() {
        // TODO: Will be refactored. This is a workaround.
        var jobAdvertisements = this.jobAdvertisementDao.findAll();
        List<JobAdvertisement> approvedAdvertisements = new ArrayList<JobAdvertisement>();

        for (JobAdvertisement jobAdvertisement : jobAdvertisements) {
            var check = this.verificationByEmployeeService.getByEntityId(jobAdvertisement.getId()).getData();
            if (check.isStatus()) {
                approvedAdvertisements.add(jobAdvertisement);
            }
        }
        return new SuccessDataResult<List<JobAdvertisement>>(approvedAdvertisements, Messages.listed);
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAdvertisementRequests() {
        // TODO: Will be refactored. This is a workaround.
        var jobAdvertisements = this.jobAdvertisementDao.findAll();
        List<JobAdvertisement> approvedAdvertisements = new ArrayList<JobAdvertisement>();

        for (JobAdvertisement jobAdvertisement : jobAdvertisements) {
            var check = this.verificationByEmployeeService.getByEntityId(jobAdvertisement.getId()).getData();
            if (!check.isStatus()) {
                approvedAdvertisements.add(jobAdvertisement);
            }
        }
        return new SuccessDataResult<List<JobAdvertisement>>(approvedAdvertisements, Messages.listed);
    }

    @Override
    public Result approveAdvert(int id) {
        var verification = this.verificationByEmployeeService.getByEntityId(id).getData();
        this.verificationByEmployeeService.approve(verification);
        return new SuccessResult();
    }

    @Override
    public Result cancelAdvert(int id) {
        var verification = this.verificationByEmployeeService.getByEntityId(id).getData();
        var advert = this.jobAdvertisementDao.getAllById(id);
        this.jobAdvertisementDao.delete(advert);
        return new SuccessResult();
    }
}
