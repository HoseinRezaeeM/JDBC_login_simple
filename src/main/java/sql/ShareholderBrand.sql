CREATE TABLE SharehoderBrand(
    idBarand int
            references Brand(idBrand),
    idShareholder int
            references Shareholder(idshareholder)
);