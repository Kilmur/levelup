package maximstarikov.levelup.services.impl;

import lombok.RequiredArgsConstructor;
import maximstarikov.levelup.models.entities.Sphere;
import maximstarikov.levelup.repositories.SphereRepository;
import maximstarikov.levelup.services.SphereService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SphereServiceImpl implements SphereService {

    private final SphereRepository repository;

    @Override
    public List<Sphere> getSphereWithGoalsByUserId(Long userId) {
        return repository.findAllByUserId(userId);
    }
}
