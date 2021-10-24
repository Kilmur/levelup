CREATE TABLE user_roles
(
    user_id        BIGINT      NOT NULL     references users,
    roles          VARCHAR     NOT NULL
);