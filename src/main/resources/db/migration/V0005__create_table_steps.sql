CREATE TABLE steps
(
    id                BIGSERIAL      NOT NULL      PRIMARY KEY,
    uuid              UUID           NOT NULL      default gen_random_uuid(),
    name              VARCHAR        NOT NULL,
    description       VARCHAR,
    created_date      TIMESTAMP      NOT NULL      default now(),
    target_date       TIMESTAMP,
    background_color  VARCHAR        NOT NULL,
    goal_id           BIGINT         NOT NULL     references goals ON DELETE CASCADE
);