package enums;

public enum Bugs {
    CRICKET("Сверчок"),
    GRASSHOPPER("Кузнечик"),
    FLY("Муха");

    private String type;

    Bugs(String type) {
        this.type = type;
    }


    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "EBugs{" +
                "type='" + type + '\'' +
                '}';
    }
}
