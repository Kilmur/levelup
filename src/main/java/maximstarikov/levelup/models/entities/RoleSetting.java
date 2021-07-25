package maximstarikov.levelup.models.entities;

import lombok.Getter;
import maximstarikov.levelup.models.enums.SettingTypeValue;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "roles_settings")
public class RoleSetting {

    @Id
    @SequenceGenerator(name = "system_settings_gen", sequenceName = "system_settings_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "system_settings_gen")
    private Long id;

    private String techName;

    private String value;

    @Enumerated(EnumType.STRING)
    private SettingTypeValue type;

    private String roleName;
}
