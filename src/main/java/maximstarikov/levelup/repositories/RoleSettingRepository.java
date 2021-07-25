package maximstarikov.levelup.repositories;

import maximstarikov.levelup.models.entities.RoleSetting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface RoleSettingRepository extends JpaRepository<RoleSetting, Long> {

    Collection<RoleSetting> findAllByRoleName(String roleName);
}
