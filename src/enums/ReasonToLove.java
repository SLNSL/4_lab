package enums;


import java.util.ArrayList;
import java.util.EnumSet;

public enum ReasonToLove {
    VOICE("Говор толпы"),
    NOISE("Шум автомобилей"),
    SMELL("Разнообразные запахи от прохожих");

    private String type;
    private static ArrayList<ReasonToLove> reasons = new ArrayList<ReasonToLove>(EnumSet.allOf(ReasonToLove.class));


    ReasonToLove(String TypeOfReason){
        type = TypeOfReason;
    }

    public String getType() {
        return type;
    }

    public static ArrayList<ReasonToLove> getReasons() {
        return reasons;
    }
}
