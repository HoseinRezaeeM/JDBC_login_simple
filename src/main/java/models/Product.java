package models;

public class Product {
    private Integer idProduct;
    private String name;
    private String createDate;
    private int idCategory;
    private int idBrand;

    public Product(Integer idProduct, String name, String createDate, int idCategory, int idBrand) {
        this.idProduct = idProduct;
        this.name = name;
        this.createDate = createDate;
        this.idCategory = idCategory;
        this.idBrand = idBrand;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public int getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(int idBrand) {
        this.idBrand = idBrand;
    }
}
