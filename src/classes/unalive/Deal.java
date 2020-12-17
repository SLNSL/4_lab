package classes.unalive;

public class Deal {
    private String name;
    private String result;
    private int count;
    private String info;
    private String owner;
    private Deal cause;

    public Deal(String name, String result){
        this.name = name;
        this.result = result;
    }

    public Deal(String name){
        this.name = name;
    }

    public Deal(String name, String owner, int count){
        this.name = name;
        this.owner = owner;
        this.count = count;
    }

    public Deal getCause() {
        return cause;
    }

    public void setCause(Deal cause) {
        this.cause = cause;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getCount(){
        return count;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }


}
