package maximstarikov.levelup.mapping.impl;

import maximstarikov.levelup.models.dto.out.SphereResponse;
import maximstarikov.levelup.models.entities.Sphere;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class SphereToSphereResponse implements Converter<Sphere, SphereResponse> {
    @Override
    public SphereResponse convert(Sphere entity) {
        return SphereResponse.builder()
                .uuid(entity.getUuid())
                .name(entity.getName())
                .backgroundColor(entity.getBackgroundColor())
                .build();
    }
}
