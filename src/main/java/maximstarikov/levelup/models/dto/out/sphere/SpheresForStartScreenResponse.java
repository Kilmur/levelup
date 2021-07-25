package maximstarikov.levelup.models.dto.out.sphere;

import lombok.Value;
import maximstarikov.levelup.models.dto.out.SphereWithGoalsResponse;
import maximstarikov.levelup.models.entities.RoleSetting;
import maximstarikov.levelup.models.entities.UserSetting;
import maximstarikov.levelup.models.entities.UserSettingValue;
import maximstarikov.levelup.models.enums.SettingTypeValue;

import java.util.List;

@Value(staticConstructor = "create")
public class SpheresForStartScreenResponse {

    List<SphereWithGoalsResponse> spheres;

    List<UserSettingResponse> userSettings;

    List<RoleSettingResponse> roleSettings;

    // TODO : возможно потом вынести, если понадобится
    @Value
    public static class UserSettingResponse {

        String techName;

        String value;

        SettingTypeValue type;

        String title;

        String description;

        public static UserSettingResponse createFrom(UserSettingValue settingValue) {
            UserSetting setting = settingValue.getSetting();
            return new UserSettingResponse(setting.getTechName(), settingValue.getValue(), setting.getType(), setting.getTitle(), setting.getDescription());
        }
    }

    @Value
    public static class RoleSettingResponse {

        String techName;

        String value;

        SettingTypeValue type;
    }

    public static RoleSettingResponse createFrom(RoleSetting setting) {
        return new RoleSettingResponse(setting.getTechName(), setting.getValue(), setting.getType());
    }
}


