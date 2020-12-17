package classes.alive;

import interfaces.*;

public class Goat implements HasName, HasSecondName {
    private String health;
    private String name;
    private String secondName;

    public Goat(String name, String health){
        this.name = name;
        this.health = health;
    }
    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSecondName() {
        return secondName;
    }

    @Override
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
