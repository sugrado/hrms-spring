package sugrado.hrmsproject.core.utilities.helpers.imageUploadHelper;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sugrado.hrmsproject.business.constants.Messages;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.core.utilities.results.SuccessResult;

import java.io.IOException;

@Service
public class CloudinaryManager implements CloudinaryService {
    private Cloudinary cloudinary;

    @Autowired
    public CloudinaryManager(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }
    // TODO: Adapters klasörüne taşınacak.
    public Result uploadImage(MultipartFile file) {
        try {
            var uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new SuccessResult(Messages.added);
    }
}
