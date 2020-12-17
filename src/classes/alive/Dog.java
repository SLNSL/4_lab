package classes.alive;

import abstracts.*;
import java.util.Objects;



public class Dog extends Animal {
    private Someone owner;
    private boolean exercised;
    private String view;

    public Dog(Someone owner){
        this.owner = owner;
        setName("Собака");
    }

    public Dog(Someone owner, String nameOfDog){
        setName(nameOfDog);
        this.owner = owner;
    }

    @Override
    public void setView(String view) {
        this.view = view;
    }

    @Override
    public String getView() {
        return view;
    }

    @Override
    public boolean getExercised(){
        return exercised;
    }

    @Override
    public void setExercised(boolean exercised_) {
        exercised = exercised_;
    }


    @Override
    public String getOwner(){
        return owner.getName();
    }



    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dog dog = (Dog) o;
        return exercised == dog.exercised &&
                Objects.equals(owner, dog.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), owner, exercised);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "owner=" + owner +
                ", exercised=" + exercised +
                '}';
    }
}
