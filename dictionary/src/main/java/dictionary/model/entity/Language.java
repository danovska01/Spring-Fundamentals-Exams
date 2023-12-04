package dictionary.model.entity;

import dictionary.model.entity.enums.LanguageNameEnum;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "languages")
public class Language extends BaseEntity {
    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private LanguageNameEnum languageName;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "language")
    private Set<Word> words;

    public Language() {

    }

    public LanguageNameEnum getLanguageName() {
        return languageName;
    }

    public void setLanguageName(LanguageNameEnum languageNameEnum) {
        this.languageName = languageNameEnum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Word> getWords() {
        return words;
    }

    public void setWords(Set<Word> words) {
        this.words = words;
    }
}
