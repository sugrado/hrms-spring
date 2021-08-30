package sugrado.hrmsproject.business.concretes.people;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sugrado.hrmsproject.business.abstracts.people.EmployerService;
import sugrado.hrmsproject.business.constants.Messages;
import sugrado.hrmsproject.core.utilities.results.*;
import sugrado.hrmsproject.dataAccess.abstracts.people.EmployerDao;
import sugrado.hrmsproject.entities.concretes.people.Employer;
import sugrado.hrmsproject.entities.dtos.CompareEmployerInfoDto;
import sugrado.hrmsproject.entities.dtos.EmployerUpdateRequestDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EmployerManager implements EmployerService {

    private final EmployerDao employerDao;
    private final ObjectMapper objectMapper;
    private final ModelMapper modelMapper;

    public EmployerManager(EmployerDao employerDao, ObjectMapper objectMapper, ModelMapper modelMapper) {
        super();
        this.employerDao = employerDao;
        this.objectMapper = objectMapper;
        this.modelMapper = modelMapper;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), Messages.listed);
    }

    @Override
    public DataResult<Employer> getById(int employerId) {
        return new SuccessDataResult<Employer>(this.employerDao.findById(employerId).get(), Messages.listed);
    }

    @Override
    public Result add(Employer employer) {
        employer.setSent(false);
        this.employerDao.save(employer);
        return new SuccessResult(Messages.added);
    }

    @Override
    public Result update(Employer employer) {
        this.employerDao.save(employer);
        return new SuccessResult(Messages.updated);
    }

    @Override
    public Result delete(Employer employer) {
        this.employerDao.delete(employer);
        return new SuccessResult(Messages.deleted);
    }

    @Override
    public DataResult<List<CompareEmployerInfoDto>> listUpdateRequest() {
        // TODO: Will be refactored. This is a workaround.
        var employers = this.employerDao.findAll();
        List<CompareEmployerInfoDto> requests = new ArrayList<CompareEmployerInfoDto>();

        for (Employer employer : employers) {
            var check = this.employerDao.findById(employer.getId()).get();
            if (check.getNewContent() != null) {
                CompareEmployerInfoDto compareEmployerInfoDto = new CompareEmployerInfoDto();
                compareEmployerInfoDto.setOldContent(employer);
                Map<String, Object> mappedValue = null;
                try {
                    mappedValue = objectMapper.readValue(employer.getNewContent(), Map.class);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
                compareEmployerInfoDto.setNewContent(this.modelMapper.map(mappedValue, Employer.class));
                requests.add(compareEmployerInfoDto);
            }
        }
        return new SuccessDataResult<List<CompareEmployerInfoDto>>(requests, Messages.listed);
    }

    @Override
    public Result updateRequest(EmployerUpdateRequestDto employerUpdateRequestDto) {
        var employer = this.employerDao.findById(employerUpdateRequestDto.employerId).get();
        employer.setNewContent(employerUpdateRequestDto.newContent);
        employer.setSent(true);
        this.employerDao.saveAndFlush(employer);
        return new SuccessResult(Messages.updated);
    }

    @Override
    public Result approveUpdateRequest(int employerId) {
        var currentEmployer = this.employerDao.findById(employerId).get();
        try {
            Map<String, Object> mappedValue = objectMapper.readValue(currentEmployer.getNewContent(), Map.class);
            currentEmployer = this.modelMapper.map(mappedValue, Employer.class);
            currentEmployer.setSent(false);
            currentEmployer.setNewContent(null);
            this.update(currentEmployer);
            return new SuccessResult("Ok");
        } catch (JsonProcessingException e) {
            return new ErrorResult(e.getMessage());
        }
    }

    @Override
    public Result cancelUpdateRequest(int employerId) {
        var currentEmployer = this.employerDao.findById(employerId).get();
        currentEmployer.setNewContent(null);
        currentEmployer.setSent(false);
        this.employerDao.saveAndFlush(currentEmployer);
        return new SuccessResult("Cancelled");
    }
}
