package project.spotifyplaylist.model.entity;

import jakarta.persistence.*;
import project.spotifyplaylist.model.entity.enums.StyleNameEnum;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "styles")
public class Style extends BaseEntity {
    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private StyleNameEnum styleName;
    @Column(columnDefinition = "TEXT")
    private String description;


    public Style() {

    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public StyleNameEnum getStyleName() {
        return styleName;
    }

    public void setStyleName(StyleNameEnum styleName) {
        this.styleName = styleName;
    }
}
