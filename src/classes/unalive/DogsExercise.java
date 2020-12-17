package classes.unalive;


import abstracts.*;

public class DogsExercise {
    public static void DoExercise(Animal dog){
        Action.doing(dog.getName(), " бегает за существом: ", "Незнайка");
        Action.doing(dog.getName(), " прыгает через ", "кусты и цветочные клумбы");
        dog.setExercised(true);
    }

}
