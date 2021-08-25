package hu.ulyssys.java.course.maven.mbean.model;


public class CartModel {

    private String city;

    private String street;

    private String typeOfStreet;

    private Integer houseNumber;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTypeOfStreet() {
        return typeOfStreet;
    }

    public void setTypeOfStreet(String typeOfStreet) {
        this.typeOfStreet = typeOfStreet;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }
}
