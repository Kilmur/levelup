package maximstarikov.levelup.models.entities;

import lombok.Getter;
import maximstarikov.levelup.models.enums.SettingTypeValue;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "roles_settings")
public class RoleSetting {

    @Id
    @SequenceGenerator(name = "roles_settings_gen", sequenceName = "roles_settings_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_settings_gen")
    private Long id;

    private String techName;

    private String value;

    @Enumerated(EnumType.STRING)
    private SettingTypeValue type;

    private String roleName;
}
