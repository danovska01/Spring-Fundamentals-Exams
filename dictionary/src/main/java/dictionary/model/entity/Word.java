package dictionary.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "words")
public class Word extends BaseEntity {


    @Column
    private String term;

    @Column
    private String translation;

    @Column(columnDefinition = "TEXT")
    private String example;


    @ManyToOne(fetch = FetchType.EAGER)
    private Language language;

    @Column
    private LocalDate date;

    @ManyToOne(fetch = FetchType.EAGER)
    private User addedBy;


    public Word() {
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate inputDate) {
        this.date = inputDate;
    }

    public User getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(User addedBy) {
        this.addedBy = addedBy;
    }
}
