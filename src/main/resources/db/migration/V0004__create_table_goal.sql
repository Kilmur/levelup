CREATE TABLE goals
(
    id             BIGSERIAL      NOT NULL      PRIMARY KEY,
    uuid           UUID           NOT NULL      default gen_random_uuid(),
    created_date   TIMESTAMP      NOT NULL      default now(),
    target_date    TIMESTAMP,
    name           VARCHAR        NOT NULL,
    description    VARCHAR,
    finished       BOOLEAN,
    sphere_id      BIGINT         NOT NULL     references spheres
);