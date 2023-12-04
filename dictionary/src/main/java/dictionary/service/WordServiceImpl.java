package dictionary.service;

import dictionary.model.entity.User;
import dictionary.model.entity.Word;
import dictionary.model.entity.enums.LanguageNameEnum;
import dictionary.model.service.WordServiceModel;
import dictionary.repository.LanguageRepository;
import dictionary.repository.UserRepository;
import dictionary.repository.WordRepository;
import dictionary.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class WordServiceImpl implements WordService{
    private final WordRepository wordRepository;
    private final ModelMapper modelMapper;
    private final LanguageRepository languageRepository;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    public WordServiceImpl(WordRepository wordRepository, ModelMapper modelMapper, LanguageRepository languageRepository, UserRepository userRepository, CurrentUser currentUser) {
        this.wordRepository = wordRepository;
        this.modelMapper = modelMapper;
        this.languageRepository = languageRepository;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }
    @Override
    public void add(WordServiceModel wordServiceModel) {
        Word word = modelMapper.map(wordServiceModel, Word.class);
        word.setLanguage(languageRepository.findByLanguageName(wordServiceModel.getLanguage()));

        User creator = userRepository.findById(currentUser.getId()).orElse(null);
        word.setAddedBy(creator);

        wordRepository.save(word);

    }

    @Override
    public Set<Word> getAllByLanguage(LanguageNameEnum languageNameEnum) {

        return wordRepository.findAllByLanguage_LanguageName(languageNameEnum);
    }

    @Override
    public void deleteById(String id) {
        wordRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        wordRepository.deleteAll();
    }
}
