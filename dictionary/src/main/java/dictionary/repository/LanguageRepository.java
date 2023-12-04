package dictionary.repository;

import dictionary.model.entity.Language;
import dictionary.model.entity.enums.LanguageNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, String> {
    Language findByLanguageName(LanguageNameEnum language);
}
