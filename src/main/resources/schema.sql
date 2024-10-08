CREATE TABLE IF NOT EXISTS userTable (
    id INT AUTO_INCREMENT PRIMARY KEY,
    firstName varchar(50) NOT NULL,
    lastName varchar(50) NOT NULL,
    birthDate DATE,
    email varchar(50)
);

INSERT INTO userTable (firstName, lastName, birthDate, email) VALUES ( 'Andrey', 'Hlus', '1975-08-27', 'andnot@yandex.ru');
INSERT INTO userTable (firstName, lastName, birthDate, email) VALUES ( 'Ivan', 'Trubanov', '1975-09-06', NULL);
INSERT INTO userTable (firstName, lastName, birthDate, email) VALUES ( 'Sveta', 'Novikova', '1976-01-11', 'sveta-konfeta@mail.ru');
