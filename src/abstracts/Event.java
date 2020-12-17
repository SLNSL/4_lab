package abstracts;


import java.util.Objects;

public abstract class Event {
    private static String type = " Формальность";

    public static void ends(String nameOfEvent){
        type = nameOfEvent;
        Action.doing("Событие " + type , "завершилось");
    }

    public static void starts(String nameOfEvent){
        type = nameOfEvent;
        class Plus{
            String plus(String type){
                return "Событие " + type;
            };
        }
        Plus event = new Plus();

        Action.doing(event.plus(type) , "началось");
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(type, event.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return "Event{" +
                "type='" + type + '\'' +
                '}';
    }
}
