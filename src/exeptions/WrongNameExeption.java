package exeptions;

public class WrongNameExeption extends RuntimeException{
    public WrongNameExeption(String message){
        super(message);
    }
}
