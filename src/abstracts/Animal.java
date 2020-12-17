package abstracts;


import interfaces.*;

abstract public class Animal extends Someone implements HasExercises, HasSecondName, HasView, HasOwner {
    private String secondName;

    public String getSecondName(){
        return secondName;
    };
    public void setSecondName(String secondName){
        this.secondName = secondName;
    };

}
