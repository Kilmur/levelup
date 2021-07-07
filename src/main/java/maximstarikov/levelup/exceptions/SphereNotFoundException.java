package maximstarikov.levelup.exceptions;

import java.util.UUID;

public class SphereNotFoundException extends RuntimeException {

    public SphereNotFoundException(String message) {
        super(message);
    }

    public static SphereNotFoundException byUuid(UUID uuid) {
        return new SphereNotFoundException("Sphere not found by uuid: " + uuid);
    }
}
