CREATE TABLE users_settings_values
(
    user_id              BIGINT      NOT NULL      references users,
    setting_id           BIGINT      NOT NULL      references users_settings,
    value                VARCHAR     NOT NULL
);