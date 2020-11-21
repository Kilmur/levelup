package maximstarikov.levelup.facades;

import maximstarikov.levelup.models.dto.in.RegistrationUserDto;

public interface UserFacade {

    void addUser(RegistrationUserDto dto);
}
