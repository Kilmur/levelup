package maximstarikov.levelup.facades.impl;

import lombok.RequiredArgsConstructor;
import maximstarikov.levelup.facades.SphereFacade;
import maximstarikov.levelup.models.dto.out.SphereWithGoalsResponse;
import maximstarikov.levelup.services.SphereService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SphereFacadeImpl implements SphereFacade {

    private final SphereService sphereService;

    @Override
    public List<SphereWithGoalsResponse> getSpheresWithGoals() {
        SecurityContextHolder.getContext().getAuthentication().getName();
        return null;
    }
}
