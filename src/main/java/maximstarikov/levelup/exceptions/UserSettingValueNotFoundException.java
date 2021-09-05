package maximstarikov.levelup.exceptions;

public class UserSettingValueNotFoundException extends RuntimeException {

    public UserSettingValueNotFoundException(String message) {
        super(message);
    }

    public static UserSettingValueNotFoundException byUserIdAndSettingTechName(Long userId, String SettingTechName) {
        return new UserSettingValueNotFoundException(String.format("Setting value not found by user id: %s, and user setting tech name: %s", userId, SettingTechName));
    }
}
