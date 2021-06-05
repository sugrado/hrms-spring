package sugrado.hrmsproject.core.utilities.helpers.imageUploadHelper;

import org.springframework.web.multipart.MultipartFile;
import sugrado.hrmsproject.core.utilities.results.Result;

public interface CloudinaryService {
    Result uploadImage(MultipartFile file);
}
