package annotations;

import java.lang.reflect.Field;

public class SomeClass {
    @Max(n=19)
    private int max;

    @Odd
    private int odd;

    @Devideble(n=10)
    private int devide;

    public int getMax() {
        return max;
    }

    public void setMax(int max) throws MaxException{
        int n = 100000000;
        Field[] fields = getClass().getDeclaredFields();
        for (Field field : fields){
            if (field.getName().equals("max") && (field.getAnnotation(Max.class) != null)){
                n = field.getAnnotation(Max.class).n();
            }
        }

        if (max > n){
            try {
                throw new MaxException("Поле max больше задуманного");
            }
            catch(MaxException e){
                System.err.println(e.getMessage());
            }
        } else this.max = max;
    }


    public int getOdd() {
        return odd;
    }

    public void setOdd(int odd) throws OddException{

        Field[] fields = getClass().getDeclaredFields();
        for (Field field : fields){
            if (field.getName().equals("odd") && field.getAnnotation(Odd.class) != null){
                    if (odd % 2 == 0) {
                        try {
                            throw new OddException("Поле odd должно являтся нечётным");
                        } catch (OddException e){
                            System.err.println(e.getMessage());
                        }
                    } else this.odd = odd;
            }
        }
    }


    public int getDevide() {
        return devide;
    }

    public void setDevide(int devide) throws DevideException{

        Field[] fields = getClass().getDeclaredFields();
        for (Field field : fields){
            if (field.getName().equals("devide") && field.getAnnotation(Devideble.class) != null){
                    if (devide % field.getAnnotation(Devideble.class).n() != 0){
                        try {
                            throw new DevideException("Поле devide должно делиться на " + field.getAnnotation(Devideble.class).n());
                        } catch (DevideException e){
                            System.err.println(e.getMessage());
                        }

                    } else this.devide = devide;
            }
        }



    }
}
