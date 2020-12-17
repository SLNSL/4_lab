package classes.unalive;

import enums.*;

import java.util.Objects;

public class Place {
    private Places type;

    Place(){};


    public Place(Places type_){
        type = type_;
    }

    public String getName(){
        return type.getName();
    }

    @Override
    public String toString() {
        return "Place{" +
                "type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return type == place.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
