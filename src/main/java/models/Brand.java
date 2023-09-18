package models;

public class Brand {
    private Integer idBrand;
    private String name;
    private String website;
    private String description;

    public Brand(Integer idBrand, String name, String website, String description) {
        this.idBrand = idBrand;
        this.name = name;
        this.website = website;
        this.description = description;
    }

    public Integer getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(Integer idBrand) {
        this.idBrand = idBrand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
