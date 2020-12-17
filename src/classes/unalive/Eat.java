package classes.unalive;

import interfaces.*;

public class Eat implements HasName {
    private String name;

    public Eat(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
