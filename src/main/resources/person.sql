DROP TABLE IF EXISTS person;

CREATE TABLE person
(
    id         SERIAL,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    age        INTEGER     NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO person (first_name, last_name, age)
VALUES ('Иван', 'Петров', 23);