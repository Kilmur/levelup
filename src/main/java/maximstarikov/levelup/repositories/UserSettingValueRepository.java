package maximstarikov.levelup.repositories;

import maximstarikov.levelup.models.entities.UserSettingValue;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface UserSettingValueRepository extends JpaRepository<UserSettingValue, Long> {

    @EntityGraph(attributePaths = "setting")
    Collection<UserSettingValue> findAllWithSettingsByUserId(Long userId);

    Optional<UserSettingValue> findByUserIdAndSettingTechName(Long userId, String settingTechName);
}
