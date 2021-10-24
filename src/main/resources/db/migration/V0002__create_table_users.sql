CREATE TABLE users
(
    id             BIGSERIAL      NOT NULL      PRIMARY KEY,
    login          VARCHAR        NOT NULL,
    password       VARCHAR        NOT NULL
);