package sugrado.hrmsproject.business.adapters.cloudinaryAdapter;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.ErrorDataResult;
import sugrado.hrmsproject.core.utilities.results.SuccessDataResult;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryManager implements CloudinaryService {
    private final Cloudinary cloudinary;

    public CloudinaryManager(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Override
    public DataResult<Map> uploadImage(MultipartFile file) {
        try {
            var uploadResult = (Map<String, String>) cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            return new SuccessDataResult<>(uploadResult, "Success!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ErrorDataResult<>("Failed!");
    }
}
