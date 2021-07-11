package maximstarikov.levelup.mapping.impl;

import lombok.RequiredArgsConstructor;
import maximstarikov.levelup.exceptions.SphereNotFoundException;
import maximstarikov.levelup.models.dto.in.goal.GoalCreateDto;
import maximstarikov.levelup.models.entities.Goal;
import maximstarikov.levelup.services.SphereService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoalCreateDtoToGoal implements Converter<GoalCreateDto, Goal> {

    private final SphereService sphereService;

    @Override
    public Goal convert(GoalCreateDto dto) {
        return new Goal(
                dto.getName(),
                dto.getDescription(),
                sphereService.getByUuid(dto.getSphereUuid()).orElseThrow(() -> SphereNotFoundException.byUuid(dto.getSphereUuid())),
                dto.getTargetDate());
    }
}
