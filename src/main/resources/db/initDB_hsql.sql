DROP TABLE dish IF EXISTS;
DROP TABLE vote IF EXISTS;
DROP TABLE user_roles IF EXISTS;
DROP TABLE restaurant IF EXISTS;
DROP TABLE users IF EXISTS;
DROP SEQUENCE GLOBAL_SEQ IF EXISTS;

CREATE SEQUENCE GLOBAL_SEQ AS INTEGER START WITH 10000;

CREATE TABLE users
(
    id         INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
    name       VARCHAR(255)            NOT NULL,
    email      VARCHAR(255)            NOT NULL,
    password   VARCHAR(255)            NOT NULL,
    registered TIMESTAMP DEFAULT now() NOT NULL,
    enabled    BOOLEAN   DEFAULT TRUE  NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx
    ON USERS (email);
CREATE TABLE user_roles
(
    user_id INTEGER NOT NULL,
    role    VARCHAR(255),
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES USERS (id) ON DELETE CASCADE
);
CREATE TABLE restaurant
(
    id   INTEGER GENERATED by default as sequence GLOBAL_SEQ primary key,
    name varchar(255) not null
);
create table vote
(
    id           INTEGER GENERATED by default as sequence GLOBAL_SEQ primary key,
    restaurantId INTEGER                 not null,
    timeExist    TIMESTAMP DEFAULT now() NOT NULL,
    userId       INTEGER                 not null,
    FOREIGN KEY (restaurantId) REFERENCES restaurant (id) ON DELETE CASCADE,
    FOREIGN KEY (userId) REFERENCES users (id) ON DELETE CASCADE
);
CREATE TABLE dish
(
    id           INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    price        DECIMAL      NOT NULL,
    restaurantId INTEGER      NOT NULL,

    FOREIGN KEY (restaurantId) REFERENCES restaurant (id) ON DELETE CASCADE
);
