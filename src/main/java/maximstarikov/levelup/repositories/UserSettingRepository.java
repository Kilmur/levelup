package maximstarikov.levelup.repositories;

import maximstarikov.levelup.models.entities.UserSetting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSettingRepository extends JpaRepository<UserSetting, Long> {
}
