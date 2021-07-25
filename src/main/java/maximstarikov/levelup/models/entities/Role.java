package maximstarikov.levelup.models.entities;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ROLE_USER,

    ROLE_PREMIUM,

    ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
