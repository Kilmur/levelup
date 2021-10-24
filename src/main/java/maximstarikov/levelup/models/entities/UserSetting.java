package maximstarikov.levelup.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import maximstarikov.levelup.models.enums.SettingTypeValue;

import javax.persistence.*;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "users_settings")
public class UserSetting {

    @Id
    @SequenceGenerator(name="users_settings_gen", sequenceName = "users_settings_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_settings_gen")
    private Long id;

    private UUID uuid;

    @Enumerated(EnumType.STRING)
    private SettingTypeValue type;

    private String defaultValue;

    private String title;

    private String description;

    private String techName;
}

