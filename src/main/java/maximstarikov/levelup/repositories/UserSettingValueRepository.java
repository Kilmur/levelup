package maximstarikov.levelup.repositories;

import maximstarikov.levelup.models.entities.UserSetting;
import maximstarikov.levelup.models.entities.UserSettingValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSettingValueRepository extends JpaRepository<UserSettingValue, Long> {
}
