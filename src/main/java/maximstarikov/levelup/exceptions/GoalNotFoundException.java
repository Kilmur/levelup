package maximstarikov.levelup.exceptions;

import java.util.UUID;

public class GoalNotFoundException extends RuntimeException {

    public GoalNotFoundException(String message) {
        super(message);
    }

    public static GoalNotFoundException byUuid(UUID uuid) {
        return new GoalNotFoundException("Goal not found by uuid: " + uuid);
    }
}
