package sugrado.hrmsproject.business.abstracts.types;

import org.springframework.web.multipart.MultipartFile;
import sugrado.hrmsproject.core.utilities.results.Result;

public interface ImageService {
    Result add(int userId, MultipartFile file);
}
