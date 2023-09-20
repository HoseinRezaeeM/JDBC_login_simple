CREATE TABLE Brand(
    idBrand serial primary key,
    name varchar(50) unique ,
    website varchar(50),
    description varchar(50)
);