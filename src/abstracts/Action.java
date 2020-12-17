package abstracts;

public abstract class Action {


    public static void doing(String object, String nameOfAction, String info) {
        System.out.println(object + ' ' + nameOfAction + ' ' + info);
    }

    public static void doing(String object, String otherInformationAboutAction, String nameOfAction, String info) {
        System.out.println(object + ' ' + otherInformationAboutAction + ' ' + nameOfAction + ' ' + info);

    }

    public static void doing(String object, String typeOfEvent){
        System.out.println(object + ' ' + typeOfEvent);
    }


    public static void doing(String condition, String object, String nameOfAction, String info, String then) {
        System.out.println(condition + ' ' + object + ' ' + nameOfAction + ' ' + info + ' ' + then);
    }

    public static void doing(String condition, String object, String nameOfAction, String info, String thenObject, String thenNameOfAction, String thenInfo) {
        System.out.println(condition + ' ' + object + ' ' + nameOfAction + ' ' + info + ' ' + thenObject + ' ' + thenNameOfAction + ' ' + thenInfo);
    }

}