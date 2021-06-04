package sugrado.hrmsproject.core.adapters.kpsAdapter;

import mernisService.QNQKPSPublicSoap;
import org.springframework.stereotype.Service;
import sugrado.hrmsproject.core.adapters.kpsAdapter.dto.CitizenCard;

@Service
public class MernisManager implements MernisService {

    QNQKPSPublicSoap client = new QNQKPSPublicSoap();

    @Override
    public boolean validateCitizen(CitizenCard citizen) {
        var result = false;
        try {
            result = client.TCKimlikNoDogrula(
                    Long.parseLong(citizen.getIdentificationNumber()),
                    citizen.getFirstName(),
                    citizen.getLastName(),
                    citizen.getBirthDate().getYear());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
