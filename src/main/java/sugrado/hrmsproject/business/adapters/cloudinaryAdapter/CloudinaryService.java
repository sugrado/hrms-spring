package sugrado.hrmsproject.business.adapters.cloudinaryAdapter;

import org.springframework.web.multipart.MultipartFile;
import sugrado.hrmsproject.core.utilities.results.DataResult;

import java.util.Map;

public interface CloudinaryService {
    DataResult<Map> uploadImage(MultipartFile file);
}
