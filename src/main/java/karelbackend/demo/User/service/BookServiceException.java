package karelbackend.demo.User.service;

public class BookServiceException extends Exception{
    private String field;
    public BookServiceException(String field, String message) {
        super(message);
        this.field = field;
    }
    public String getField(){
        return field;
    }
}
