package sugrado.hrmsproject.api.controllers.types;

import org.springframework.web.bind.annotation.*;
import sugrado.hrmsproject.business.abstracts.types.LanguageService;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.types.Language;

@RestController
@RequestMapping("/api/languages")
@CrossOrigin
public class LanguagesController {
    private final LanguageService languageService;

    public LanguagesController(LanguageService languageService) {
        super();
        this.languageService = languageService;
    }

    @GetMapping("/getall")
    public Result getall() {
        return this.languageService.getAll();
    }

    @GetMapping("/getbyid")
    public Result getById(@RequestParam int id) {
        return this.languageService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Language language) {
        return this.languageService.add(language);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Language language) {
        return this.languageService.update(language);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Language language) {
        return this.languageService.delete(language);
    }

}
