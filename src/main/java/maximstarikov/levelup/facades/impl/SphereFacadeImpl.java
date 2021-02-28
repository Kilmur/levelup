package maximstarikov.levelup.facades.impl;

import lombok.RequiredArgsConstructor;
import maximstarikov.levelup.exceptions.UserNotFoundException;
import maximstarikov.levelup.facades.SphereFacade;
import maximstarikov.levelup.mapping.SphereListToSphereWithGoalsResponseList;
import maximstarikov.levelup.models.dto.out.SphereWithGoalsResponse;
import maximstarikov.levelup.models.entities.User;
import maximstarikov.levelup.services.SphereService;
import maximstarikov.levelup.services.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SphereFacadeImpl implements SphereFacade {

    private final SphereService sphereService;
    private final UserService userService;
    private final SphereListToSphereWithGoalsResponseList spheresToResponseListConverter;

    @Override
    public List<SphereWithGoalsResponse> getSpheresWithGoals() {
        String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.getByLogin(userLogin).orElseThrow(() -> UserNotFoundException.byLogin(userLogin));
        return spheresToResponseListConverter.convert(sphereService.getSphereWithGoalsByUserId(user.getId()));
    }
}
