DROP TABLE IF EXISTS discipline;
DROP TABLE IF EXISTS brand;
DROP TABLE IF EXISTS rollerskate;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS basket;
DROP TABLE IF EXISTS orders;


CREATE TABLE discipline
(
    id         INT(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    UUID       VARCHAR(36)         NOT NULL,
    discipline VARCHAR(20)         NOT NULL UNIQUE
);

CREATE TABLE brand
(
    id    INT(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    UUID  VARCHAR(36)         NOT NULL,
    brand VARCHAR(30)         NOT NULL UNIQUE
);

CREATE TABLE rollerskate
(
    id            INT(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    UUID          VARCHAR(36)         NOT NULL,
    discipline_id INT                 NOT NULL,
    brand_id      INT                 NOT NULL,
    model         VARCHAR(60)         NOT NULL UNIQUE,
    year          YEAR DEFAULT NULL,
    description   TEXT DEFAULT 'NULL',
    price         INT(11)             NOT NULL
);

CREATE TABLE users
(
    id         INT(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    UUID       VARCHAR(36)         NOT NULL,
    mail       VARCHAR(50)         NOT NULL UNIQUE,
    login      VARCHAR(12)         NOT NULL UNIQUE,
    password   VARCHAR(10)         NOT NULL,
    google_key VARCHAR(20) DEFAULT 'NULL',
    phone      TEXT(15)    DEFAULT 'NULL',
    address     VARCHAR(30) DEFAULT 'NULL'
);

CREATE TABLE basket
(
    id    INT(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    UUID  VARCHAR(36)         NOT NULL,
    items VARCHAR(40)         NOT NULL
);

CREATE TABLE orders
(
    id    INT(10) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    UUID  VARCHAR(36)         NOT NULL,
    time  DATETIME            NOT NULL,
    items INT(100)            NOT NULL,
    user  INT(30)             NOT NULL
);

ALTER TABLE rollerskate
    ADD CONSTRAINT rollerskate_discipline_id_discipline_discipline_id FOREIGN KEY (id) REFERENCES discipline (id);
ALTER TABLE rollerskate
    ADD CONSTRAINT rollerskate_brand_id_brand_brand_id FOREIGN KEY (id) REFERENCES brand (id);
ALTER TABLE basket
    ADD CONSTRAINT basket_items_rollerskate_id FOREIGN KEY (id) REFERENCES rollerskate (id);
ALTER TABLE orders
    ADD CONSTRAINT orders_items_basket_id FOREIGN KEY (id) REFERENCES basket (id);
ALTER TABLE orders
    ADD CONSTRAINT orders_user_users_user_id FOREIGN KEY (user) REFERENCES users (id);