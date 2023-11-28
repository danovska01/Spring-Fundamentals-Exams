package project.hero.model.service;


import project.hero.model.entity.enums.Class;

public class HeroServiceModel {

    private String name;

    private Class aClass;

    private Integer level;

    public HeroServiceModel(){

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
