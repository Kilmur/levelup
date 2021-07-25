package maximstarikov.levelup.services;

import maximstarikov.levelup.models.entities.RoleSetting;

import java.util.Collection;

public interface RoleSettingService {

    Collection<RoleSetting> getAllByRoleName(String roleName);
}
