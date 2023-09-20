CREATE TABLE Category(
    idCategory serial primary key ,
    name varchar(50) unique ,
    description varchar(50)
);