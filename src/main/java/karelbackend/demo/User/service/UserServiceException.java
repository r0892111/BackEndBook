package karelbackend.demo.User.service;

public class UserServiceException extends Exception{
    private String field;
    public UserServiceException(String field, String message) {
        super(message);
        this.field = field;
    }
    public String getField(){
        return field;
    }
}
