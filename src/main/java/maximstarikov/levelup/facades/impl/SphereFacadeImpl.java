package maximstarikov.levelup.facades.impl;

import lombok.RequiredArgsConstructor;
import maximstarikov.levelup.exceptions.SphereNotFoundException;
import maximstarikov.levelup.facades.SphereFacade;
import maximstarikov.levelup.mapping.SphereListToSphereWithGoalsResponseList;
import maximstarikov.levelup.models.dto.in.SphereCreateDto;
import maximstarikov.levelup.models.dto.in.SphereUpdateDto;
import maximstarikov.levelup.models.dto.out.SphereResponse;
import maximstarikov.levelup.models.dto.out.SphereWithGoalsResponse;
import maximstarikov.levelup.models.entities.Sphere;
import maximstarikov.levelup.models.entities.User;
import maximstarikov.levelup.services.SphereService;
import maximstarikov.levelup.services.UserService;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import static org.apache.logging.log4j.util.Strings.isBlank;
import static org.apache.logging.log4j.util.Strings.isNotBlank;

@Service
@RequiredArgsConstructor
public class SphereFacadeImpl implements SphereFacade {

    private final SphereService sphereService;
    private final UserService userService;
    private final SphereListToSphereWithGoalsResponseList spheresToResponseListConverter;
    private  final ConversionService conversionService;

    @Override
    public List<SphereWithGoalsResponse> getSpheresWithGoals() {
        User user = userService.getCurrentUser();
        return spheresToResponseListConverter.convert(sphereService.getSphereWithGoalsByUserId(user.getId()));
    }

    @Override
    public SphereResponse create(SphereCreateDto dto) {
        Sphere newSphere = new Sphere();
        newSphere.setName(dto.getName());
        if (isBlank(dto.getBackgroundColor())) {
            newSphere.setBackgroundColor("#ffffff"); // TODO : из настроек
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
