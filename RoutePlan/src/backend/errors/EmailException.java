package backend.errors;

public class EmailException extends Exception {
    public EmailException(){
        super("This is not an Email");
    }
}