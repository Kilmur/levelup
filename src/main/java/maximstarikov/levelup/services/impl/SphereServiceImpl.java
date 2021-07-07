package maximstarikov.levelup.services.impl;

import lombok.RequiredArgsConstructor;
import maximstarikov.levelup.models.entities.Sphere;
import maximstarikov.levelup.repositories.SphereRepository;
import maximstarikov.levelup.services.SphereService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SphereServiceImpl implements SphereService {

    private final SphereRepository repository;

    @Override
    public Collection<Sphere> getSphereWithGoalsByUserId(Long userId) {
        return repository.findAllWithGoalsByUserId(userId);
    }

    @Override
    public Sphere save(Sphere newSphere) {
        return repository.save(newSphere);
    }

    @Override
    public Optional<Sphere> getByUuid(UUID uuid) {
        return repository.findByUuid(uuid);
    }
}
