package sugrado.hrmsproject.business.concretes.types;

import org.springframework.stereotype.Service;
import sugrado.hrmsproject.business.abstracts.types.EmploymentTypeService;
import sugrado.hrmsproject.business.constants.Messages;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.core.utilities.results.SuccessDataResult;
import sugrado.hrmsproject.core.utilities.results.SuccessResult;
import sugrado.hrmsproject.dataAccess.abstracts.types.EmploymentTypeDao;
import sugrado.hrmsproject.entities.concretes.types.EmploymentType;

import java.util.List;

@Service
public class EmploymentTypeManager implements EmploymentTypeService {
    private final EmploymentTypeDao employmentTypeDao;

    public EmploymentTypeManager(EmploymentTypeDao employmentTypeDao) {
        this.employmentTypeDao = employmentTypeDao;
    }

    @Override
    public Result add(EmploymentType employmentType) {
        this.employmentTypeDao.save(employmentType);
        return new SuccessResult(Messages.added);
    }

    @Override
    public Result update(EmploymentType employmentType) {
        this.employmentTypeDao.save(employmentType);
        return new SuccessResult(Messages.updated);
    }

    @Override
    public Result delete(EmploymentType employmentType) {
        this.employmentTypeDao.delete(employmentType);
        return new SuccessResult(Messages.deleted);
    }

    @Override
    public DataResult<List<EmploymentType>> getAll() {
        return new SuccessDataResult<List<EmploymentType>>(this.employmentTypeDao.findAll(), Messages.listed);
    }

    @Override
    public DataResult<EmploymentType> getById(int id) {
        return new SuccessDataResult<EmploymentType>(this.employmentTypeDao.findById(id).get(), Messages.listed);
    }
}
