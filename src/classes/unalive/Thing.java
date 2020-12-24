package classes.unalive;


import exeptions.*;

public class Thing{
    private String name;
    private String count;

    Thing(){};

    public Thing(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) throws NotNumberExeption {
        try {
            int n = Integer.parseInt(count);
        } catch (NumberFormatException | NullPointerException e){
            throw new NotNumberExeption("Count должен содержать только цифры");
        }
        this.count = count;
    }
}
