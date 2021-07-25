package maximstarikov.levelup.services.impl;

import lombok.RequiredArgsConstructor;
import maximstarikov.levelup.repositories.UserSettingRepository;
import maximstarikov.levelup.services.UserSettingService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSettingServiceImpl implements UserSettingService {

    private final UserSettingRepository repository;
}
