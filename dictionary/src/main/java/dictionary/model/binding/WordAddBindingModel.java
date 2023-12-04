package dictionary.model.binding;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class WordAddBindingModel {
    @NotBlank(message = "Empty term field is not acceptable")
    @Size(min = 2, max = 40, message = "Term field size is accepted in between 2-40 symbols")
    private String term;

    @NotBlank(message = "Empty translation field is not acceptable")
    @Size(min = 2, max = 80, message = "Translation field size is accepted in between 2-80 symbols")
    private String translation;

    @NotBlank(message = "Empty example field is not acceptable")
    @Size(min = 2, max = 200, message = "Example field size is accepted in between 2-200 symbols")
    private String example;

    @NotBlank
    private String language;

    @PastOrPresent(message = "Please select valid past or present date")
    @NotNull(message = "Please select valid past or present date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;



    public WordAddBindingModel(){

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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
