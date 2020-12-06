package maximstarikov.levelup.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }

    public static UserNotFoundException byLogin(String login) {
        return new UserNotFoundException("User not found by login: " + login);
    }
}
