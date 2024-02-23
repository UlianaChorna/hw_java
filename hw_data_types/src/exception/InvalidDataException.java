package exception;

public class InvalidDataException extends Exception{
    public InvalidDataException() {
        super("Username and email must be provided.");
    }
}
