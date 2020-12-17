package abstracts;

abstract public class ResultOfExercises {
    public static void ends(Animal dog, Someone human) {
        System.out.print("Физ-зарядка была полезной для самочувствия собаки: " + dog.getName());
        System.out.print(" , но это разозлило человека типа: " + human.getName()  + ", ведь его обязанности: следить за садом");
        System.out.println();
    }
}

