package annotations;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        SomeClass a = new SomeClass();

        a.setMax(2);
        System.out.println("max " + a.getMax());

        a.setOdd(21);
        System.out.println("odd " + a.getOdd());

        a.setDevide(20);
        System.out.println("devide " + a.getDevide());
    }
}
