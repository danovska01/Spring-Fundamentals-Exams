package webapp.gira.models.entities;

import webapp.gira.models.entities.enums.ClassificationName;

import javax.persistence.*;

@Entity
@Table(name = "classifications")
public class Classification extends BaseEntity {

    private ClassificationName classificationName;
    private String description;

    public Classification() {
    }

    public Classification(ClassificationName classificationName) {
        this.classificationName = classificationName;
    }

    @Enumerated(EnumType.ORDINAL)
    public ClassificationName getClassificationName() {
        return classificationName;
    }

    public Classification setClassificationName(ClassificationName classificationName) {
        this.classificationName = classificationName;
        return this;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Classification setDescription(String description) {
        this.description = description;
        return this;
    }
}
