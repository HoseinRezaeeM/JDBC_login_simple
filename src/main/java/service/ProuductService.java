package service;

import repository.ProductRepository;

import java.sql.SQLException;

public class ProuductService {

    private final ProductRepository prouductRepository;

    public ProuductService(ProductRepository prouductRepository) {
        this.prouductRepository = prouductRepository;
    }
    public void loadAll() throws SQLException {
        prouductRepository.loadAll();
    }
}
