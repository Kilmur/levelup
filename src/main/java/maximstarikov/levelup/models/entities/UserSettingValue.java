package maximstarikov.levelup.models.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Entity
@Table(name = "user_setting_value")
@IdClass(UserSettingValue.UserSettingValueId.class)
public class UserSettingValue {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Id
    @Column(name = "setting_id")
    private Long settingId;

    private String value;

    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @JoinColumn(name = "setting_id", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private UserSetting setting;

    public UserSettingValue(User user, UserSetting setting) {
        this.userId = user.getId();
        this.settingId = setting.getId();
        this.value = setting.getDefaultValue();
        this.user = user;
        this.setting = setting;
    }

    @NoArgsConstructor
    public static class UserSettingValueId implements Serializable {

        private Long userId;
        private Long settingId;
    }
}
