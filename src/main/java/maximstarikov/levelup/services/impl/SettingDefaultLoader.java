package maximstarikov.levelup.services.impl;

import lombok.RequiredArgsConstructor;
import maximstarikov.levelup.models.entities.UserSetting;
import maximstarikov.levelup.repositories.UserSettingRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class SettingDefaultLoader {

    private final UserSettingRepository repository;

    @PostConstruct
    void createDefaultUserSettings() { // TODO : подумать как
//        List<UserSetting> userSettingForSaving = Stream.of(
//                UserSetting.builder()
//                        .uuid(UUID.randomUUID())
//                        .type(UserSetting.TypeValue.CHECKBOX)
//                        .defaultValue("false")
//                        .title("Отображать выполненные цели")
//                        .description("Если настройка включена в списке целей будут продолжать отображаться уже выполненные цели, если отключена - только актуальные")
//                        .techName("DISPLAY_FINISH_GOAL")
//                        .build(),
//                UserSetting.builder()
//                        .uuid(UUID.randomUUID())
//                        .type(UserSetting.TypeValue.TEXT)
//                        .defaultValue("#ffffff")
//                        .title("Цвет сфер по-умолчанию")
//                        .description("Цвет для сфер при создании")
//                        .techName("SPHERE_DEFAULT_COLOR")
//                        .build()).collect(Collectors.toList());
//        repository.saveAll(userSettingForSaving);
    }
}
