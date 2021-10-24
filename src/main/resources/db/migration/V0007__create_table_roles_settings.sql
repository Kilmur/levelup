CREATE TABLE roles_settings
(
    id              BIGSERIAL      NOT NULL      PRIMARY KEY,
    tech_name       VARCHAR        NOT NULL,
    value           VARCHAR        NOT NULL,
    type            VARCHAR,
    role_name       VARCHAR        NOT NULL
);