package maximstarikov.levelup.services.impl;

import lombok.RequiredArgsConstructor;
import maximstarikov.levelup.models.entities.User;
import maximstarikov.levelup.models.entities.UserSettingValue;
import maximstarikov.levelup.repositories.UserSettingRepository;
import maximstarikov.levelup.repositories.UserSettingValueRepository;
import maximstarikov.levelup.services.UserSettingValueService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserSettingValueServiceImpl implements UserSettingValueService {

    private final UserSettingRepository userSettingRepository;
    private final UserSettingValueRepository settingValueRepository;

    @Override
    public void createDefaultUserSettingsValue(User user) {
        List<UserSettingValue> settingValueList = userSettingRepository.findAll()
                .stream()
                .map(userSetting -> new UserSettingValue(user, userSetting))
                .collect(Collectors.toList());
        settingValueRepository.saveAll(settingValueList);
    }

    @Override
    public Collection<UserSettingValue> getAllWithUserSettings(Long userId) {
        return settingValueRepository.findAllWithSettingsByUserId(userId);
    }

    @Override
    public Optional<UserSettingValue> getForUserByTechName(Long userId, String settingTechName) {
        return settingValueRepository.findByUserIdAndSettingTechName(userId, settingTechName);
    }
}
