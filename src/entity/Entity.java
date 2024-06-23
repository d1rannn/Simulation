package entity;

public abstract class Entity {
    protected String type;

    public Entity(String type) {
        this.type = " ";
    }

    public Entity() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
