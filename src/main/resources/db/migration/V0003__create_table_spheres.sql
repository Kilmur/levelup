CREATE TABLE spheres
(
    id                BIGSERIAL      NOT NULL      PRIMARY KEY,
    uuid              UUID           NOT NULL      default gen_random_uuid(),
    name              VARCHAR        NOT NULL,
    created_date      TIMESTAMP      NOT NULL      default now(),
    background_color  VARCHAR        NOT NULL,
    user_id           BIGINT         NOT NULL      references users ON DELETE CASCADE
);