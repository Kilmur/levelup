package maximstarikov.levelup.services;

import maximstarikov.levelup.models.entities.User;
import maximstarikov.levelup.models.entities.UserSettingValue;

import java.util.Collection;

public interface UserSettingValueService {

    void createDefaultUserSettingsValue(User user);

    Collection<UserSettingValue> getAllWithUserSettings(Long userId);
}
