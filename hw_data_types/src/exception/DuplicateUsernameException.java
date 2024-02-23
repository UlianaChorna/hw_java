package exception;

public class DuplicateUsernameException extends  Exception {
    public DuplicateUsernameException(String username) {
        super("User with username '" + username + "' already exists.");
    }
}
