package abstracts;

import java.util.Objects;

import exeptions.*;
import interfaces.*;

public abstract class Someone implements HasName {
    private String name;
    private String realname;
    private static String emotion;


    @Override
    public String getName() {
        return name;
    }


    @Override
    public void setName(String nameOfSomeone) throws UncheckedExeption {
        if(nameOfSomeone == nameOfSomeone.toLowerCase()){
            try{
                throw new UncheckedExeption("Поле name у объектов должно начинаться с большой буквы");
            } catch (UncheckedExeption e){
                e.printStackTrace();
            }
        }
        this.name = nameOfSomeone;
    }

    public void setEmotion(String emotion) {
        Someone.emotion = emotion;
    }

    public String getEmotion() {
        return getName() + " " + emotion;
    }

    public void setRealName(String realname) {
        this.realname = realname;
    }

    public String getRealName() {
        return realname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Someone someone = (Someone) o;
        return Objects.equals(name, someone.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "ASomeone{" +
                "name='" + name + '\'' +
                '}';
    }
}
