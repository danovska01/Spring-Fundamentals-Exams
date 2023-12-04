package dictionary.service;

import dictionary.model.entity.Word;
import dictionary.model.entity.enums.LanguageNameEnum;
import dictionary.model.service.WordServiceModel;

import java.util.Set;

public interface WordService {
    void add(WordServiceModel wordServiceModel);

    Set<Word> getAllByLanguage(LanguageNameEnum languageNameEnum);

    void deleteById(String id);

    void deleteAll();
}
