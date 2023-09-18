package models;

public class Shareholder {
    private Integer idShareholder;
    private String name;
    private String phoneNumber;
    private String nationalCode;

    public Shareholder(Integer idShareholder, String name, String phoneNumber, String nationalCode) {
        this.idShareholder = idShareholder;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.nationalCode = nationalCode;
    }

    public Integer getIdShareholder() {
        return idShareholder;
    }

    public void setIdShareholder(Integer idShareholder) {
        this.idShareholder = idShareholder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }
}
