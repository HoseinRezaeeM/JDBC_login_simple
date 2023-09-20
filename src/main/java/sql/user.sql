CREATE TABLE Users(
    idUser serial primary key ,
    name varchar(50),
    userName varchar(50) unique ,
    email varchar(100) unique,
    password varchar(50)
);