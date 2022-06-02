CREATE TABLE IF NOT EXISTS Users (
    id BIGINT  not null AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    email varchar(255)  NOT NULL,
    primary key (id)
);