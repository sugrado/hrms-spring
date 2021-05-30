package sugrado.hrmsproject.core.adapters.kpsAdapter;

import sugrado.hrmsproject.core.adapters.kpsAdapter.dto.CitizenCard;
import sugrado.hrmsproject.entities.dto.CandidateForRegisterDto;

public interface MernisService {
    public boolean validateCitizen(CitizenCard citizen);
}
