package dictionary.repository;

import dictionary.model.entity.Word;
import dictionary.model.entity.enums.LanguageNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface WordRepository extends JpaRepository<Word, String> {
    Set<Word> findAllByLanguage_LanguageName(LanguageNameEnum languageNameEnum);
}
