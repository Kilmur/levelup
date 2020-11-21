package maximstarikov.levelup.exceptions;

public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(String message) {
        super(message);
    }

    public static UserAlreadyExistsException byLogin(String login) {
        return new UserAlreadyExistsException("User already exists with login: " + login);
    }
}
