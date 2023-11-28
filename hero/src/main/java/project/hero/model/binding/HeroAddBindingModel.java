package project.hero.model.binding;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import project.hero.model.entity.enums.Class;

public class HeroAddBindingModel {
    @NotBlank
    private String name;
    @NotNull
    private Class aClass;
    @NotNull
    @Positive
    private Integer level;


    public HeroAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
