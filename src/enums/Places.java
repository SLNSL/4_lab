package enums;


public enum Places {
    DOGSPARK("Собачий Парк"),
    GARDEN("Сад"),
    DOGSRESTAURANT("Собачий Ресторан"),
    TOWN("Город"),
    HOME("Дом"),
    BARBER("Парикмахерская"),
    CONCERT("Концерт"),
    SPORTDOGGYM("Спортивный собачий зал"),
    POOL("Плавательный бассейн"),
    TUPIK("Дрянингский \"Тупичок\""),
    TUPIKNIGHT("Дрянингская ночлежка"),
    THEATER("Театр");


    private String name;

    Places(String nameOfPlace){
        name = nameOfPlace;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "EPlaces{" +
                "name='" + name + '\'' +
                '}';
    }
}
