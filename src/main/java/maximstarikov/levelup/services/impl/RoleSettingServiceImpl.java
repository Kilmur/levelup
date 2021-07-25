package maximstarikov.levelup.services.impl;

import lombok.RequiredArgsConstructor;
import maximstarikov.levelup.models.entities.RoleSetting;
import maximstarikov.levelup.repositories.RoleSettingRepository;
import maximstarikov.levelup.services.RoleSettingService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class RoleSettingServiceImpl implements RoleSettingService {

    private final RoleSettingRepository repository;

    @Override
    public Collection<RoleSetting> getAllByRoleName(String roleName) {
        return repository.findAllByRoleName(roleName);
    }
}
