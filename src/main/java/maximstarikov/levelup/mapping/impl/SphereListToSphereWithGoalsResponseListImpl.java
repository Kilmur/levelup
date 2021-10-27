package maximstarikov.levelup.mapping.impl;

import maximstarikov.levelup.mapping.SphereListToSphereWithGoalsResponseList;
import maximstarikov.levelup.models.dto.out.SphereWithGoalsResponse;
import maximstarikov.levelup.models.entities.Sphere;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SphereListToSphereWithGoalsResponseListImpl implements SphereListToSphereWithGoalsResponseList {

    @Override
    public List<SphereWithGoalsResponse> convert(Collection<Sphere> spheres) {
        return spheres.stream().map(entity -> SphereWithGoalsResponse.builder()
                .name(entity.getName())
                .uuid(entity.getUuid())
                .backgroundColor(entity.getBackgroundColor())
                .goals(entity.getGoals()
                        .stream()
                        .map(goal -> SphereWithGoalsResponse.Goal.builder()
                                .name(goal.getName())
                                .uuid(goal.getUuid())
                                .backgroundColor(goal.getBackgroundColor())
                                .targetDate(goal.getTargetDate())
                                .build())
                        .collect(Collectors.toSet()))
                .build())
                .collect(Collectors.toList());
    }
}
