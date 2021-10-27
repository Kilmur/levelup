package maximstarikov.levelup.mapping.impl;

import lombok.RequiredArgsConstructor;
import maximstarikov.levelup.exceptions.SphereNotFoundException;
import maximstarikov.levelup.exceptions.UserSettingValueNotFoundException;
import maximstarikov.levelup.models.dto.in.goal.GoalCreateDto;
import maximstarikov.levelup.models.entities.Goal;
import maximstarikov.levelup.services.SphereService;
import maximstarikov.levelup.services.UserService;
import maximstarikov.levelup.services.UserSettingValueService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoalCreateDtoToGoal implements Converter<GoalCreateDto, Goal> {

    private final SphereService sphereService;
    private final UserSettingValueService settingValueService;
    private final UserService userService;

    @Override
    public Goal convert(GoalCreateDto dto) {
        return new Goal(
                dto.getName(),
                dto.getDescription(),
                Strings.isBlank(dto.getBackgroundColor()) ? getDefaultColor() : dto.getBackgroundColor(),
                sphereService.getByUuid(dto.getSphereUuid()).orElseThrow(() -> SphereNotFoundException.byUuid(dto.getSphereUuid())),
                dto.getTargetDate());
    }

    private String getDefaultColor() {
        return settingValueService.getForUserByTechName(userService.getCurrentUser().getId(), "GOAL_DEFAULT_COLOR")
                .orElseThrow(() -> UserSettingValueNotFoundException.byUserIdAndSettingTechName(userService.getCurrentUser().getId(), "GOAL_DEFAULT_COLOR"))
                .getValue();
    }
}
