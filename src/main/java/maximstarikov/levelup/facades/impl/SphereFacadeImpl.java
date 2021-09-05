package maximstarikov.levelup.facades.impl;

import lombok.RequiredArgsConstructor;
import maximstarikov.levelup.exceptions.SphereNotFoundException;
import maximstarikov.levelup.exceptions.UserSettingValueNotFoundException;
import maximstarikov.levelup.facades.SphereFacade;
import maximstarikov.levelup.mapping.SphereListToSphereWithGoalsResponseList;
import maximstarikov.levelup.models.dto.in.SphereCreateDto;
import maximstarikov.levelup.models.dto.in.SphereUpdateDto;
import maximstarikov.levelup.models.dto.out.SphereResponse;
import maximstarikov.levelup.models.dto.out.SphereWithGoalsResponse;
import maximstarikov.levelup.models.dto.out.sphere.SpheresForStartScreenResponse;
import maximstarikov.levelup.models.entities.Sphere;
import maximstarikov.levelup.models.entities.User;
import maximstarikov.levelup.models.entities.UserSettingValue;
import maximstarikov.levelup.services.RoleSettingService;
import maximstarikov.levelup.services.SphereService;
import maximstarikov.levelup.services.UserService;
import maximstarikov.levelup.services.UserSettingValueService;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.apache.logging.log4j.util.Strings.isBlank;
import static org.apache.logging.log4j.util.Strings.isNotBlank;

@Service
@RequiredArgsConstructor
public class SphereFacadeImpl implements SphereFacade {

    private final SphereService sphereService;
    private final UserService userService;
    private final UserSettingValueService userSettingValueService;
    private final RoleSettingService roleSettingService;
    private final SphereListToSphereWithGoalsResponseList spheresToResponseListConverter;
    private  final ConversionService conversionService;

    private static final String SPHERE_DEFAULT_COLOR_SETTING_NAME = "SPHERE_DEFAULT_COLOR"; // TODO : подумать может вынести в enum

    @Override
    public SpheresForStartScreenResponse getSpheresForStart() {
        User user = userService.getCurrentUser();
        List<SphereWithGoalsResponse> sphereWithGoalsList = spheresToResponseListConverter.convert(sphereService.getSphereWithGoalsByUserId(user.getId()));

        List<SpheresForStartScreenResponse.UserSettingResponse> userSettingResponseList = userSettingValueService.getAllWithUserSettings(user.getId())
                .stream()
                .map(SpheresForStartScreenResponse.UserSettingResponse::createFrom)
                .collect(Collectors.toList());

        List<SpheresForStartScreenResponse.RoleSettingResponse> roleSettingResponseList = roleSettingService.getAllByRoleName(userService.getGeneralRole(user).name())
                .stream()
                .map(SpheresForStartScreenResponse::createFrom)
                .collect(Collectors.toList());

        return SpheresForStartScreenResponse.create(sphereWithGoalsList, userSettingResponseList, roleSettingResponseList);
    }

    @Override
    public SphereResponse create(SphereCreateDto dto) {
        Sphere newSphere = new Sphere();
        newSphere.setName(dto.getName());
        if (isBlank(dto.getBackgroundColor())) {
            Long currentUserId = userService.getCurrentUser().getId();
            UserSettingValue userSettingValue = userSettingValueService.getForUserByTechName(currentUserId, SPHERE_DEFAULT_COLOR_SETTING_NAME)
                    .orElseThrow(() -> UserSettingValueNotFoundException.byUserIdAndSettingTechName(currentUserId, SPHERE_DEFAULT_COLOR_SETTING_NAME));
            newSphere.setBackgroundColor(userSettingValue.getValue());
        } else {
            newSphere.setBackgroundColor(dto.getBackgroundColor());
        }
        newSphere.setUser(userService.getCurrentUser());
        return conversionService.convert(sphereService.save(newSphere), SphereResponse.class);
    }

    @Override
    @Transactional
    public SphereResponse update(SphereUpdateDto dto) {
        Sphere sphere = sphereService.getByUuid(dto.getUuid()).orElseThrow(() -> SphereNotFoundException.byUuid(dto.getUuid()));
        if (isNotBlank(dto.getName())) sphere.setName(dto.getName());
        if (isNotBlank(dto.getBackgroundColor())) sphere.setBackgroundColor(dto.getBackgroundColor());
        return conversionService.convert(sphere, SphereResponse.class);
    }

    @Override
    public void deleteByUuid(UUID uuid) {
        sphereService.deleteByUuid(uuid);
    }
}
