CREATE TABLE person
(
    id         INT NOT NULL AUTO_INCREMENT,
    name       VARCHAR(250),
    birth_date VARCHAR(250),
    email      VARCHAR(250),
    phone      VARCHAR(250)
);
CREATE TABLE user
(
    id         INT NOT NULL AUTO_INCREMENT,
    login       VARCHAR(250),
    password LONG(250)
)