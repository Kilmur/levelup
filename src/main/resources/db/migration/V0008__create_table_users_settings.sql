CREATE TABLE users_settings
(
    id             BIGSERIAL      NOT NULL      PRIMARY KEY,
    uuid           UUID           NOT NULL      default gen_random_uuid(),
    type           VARCHAR        NOT NULL,
    default_value  VARCHAR        NOT NULL,
    title          VARCHAR        NOT NULL,
    description    VARCHAR,
    tech_name      VARCHAR        NOT NULL
);