package maximstarikov.levelup.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import maximstarikov.levelup.models.enums.SettingTypeValue;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "user_settings")
public class UserSetting {

    @Id
    @SequenceGenerator(name="user_settings_id_gen", sequenceName = "user_settings_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_settings_id_gen")
    private Long id;

    @Type(type = "uuid-char")
    private UUID uuid;

    @Enumerated(EnumType.STRING)
    private SettingTypeValue type;

    private String defaultValue;

    private String title;

    private String description;

    private String techName;

    public enum TypeValue {
        CHECKBOX, TEXT
    }
}

