CREATE TABLE Product(
    idProduct serial primary key ,
    name varchar(50),
    createDate varchar(50),
    idCategory int references category(idCategory),
    idBrand int references brand(idBrand)

);