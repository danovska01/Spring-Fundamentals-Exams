package webapp.gira.models.entities.enums;

public enum ClassificationName {
    BUG(1), FEATURE(2), SUPPORT(3), OTHER(4);

    private final int id;

    ClassificationName(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
