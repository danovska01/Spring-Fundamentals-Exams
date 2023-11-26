package project.likebook.model.binding;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import project.likebook.model.entity.enums.MoodName;

public class PostAddBindingModel {
    @NotBlank(message = "Content cannot be empty!")
    @Size(min = 2, max = 150, message = "Content length must be 2-150 chars")
    private String content;


    /// NOTICE!!!! -> NEVER PUT @NotBlank validator on this field
    @NotNull(message = "Mood was not chosen!")
    private MoodName mood;


    public PostAddBindingModel() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



    public MoodName getMood() {
        return mood;
    }

    public void setMood(MoodName mood) {
        this.mood = mood;
    }
}
