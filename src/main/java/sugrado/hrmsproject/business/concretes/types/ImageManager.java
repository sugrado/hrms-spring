package sugrado.hrmsproject.business.concretes.types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sugrado.hrmsproject.business.abstracts.authorizations.UserService;
import sugrado.hrmsproject.business.abstracts.types.ImageService;
import sugrado.hrmsproject.business.adapters.cloudinaryAdapter.CloudinaryService;
import sugrado.hrmsproject.business.constants.Messages;
import sugrado.hrmsproject.core.utilities.results.ErrorResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.core.utilities.results.SuccessResult;

import java.util.Map;

@Service
public class ImageManager implements ImageService {
    private UserService userService;
    private CloudinaryService cloudinaryService;

    @Autowired
    public ImageManager(CloudinaryService cloudinaryService, UserService userService) {
        this.cloudinaryService = cloudinaryService;
        this.userService = userService;
    }

    @Override
    public Result add(int userId, MultipartFile file) {
        var user = this.userService.getById(userId).getData();

        if (user == null)
            return new ErrorResult(Messages.notFound);

        Map<String, String> result = this.cloudinaryService.uploadImage(file).getData();
        user.setPhoto(result.get("url"));
        this.userService.update(user);
        return new SuccessResult(Messages.added);
    }
}
