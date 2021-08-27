package hu.ulyssys.java.course.maven.rest.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Max;
import java.util.Date;

public class OrderModel {

    private Long id;

    @Max(value = 200)
    private String city;

    @Max(value = 200)
    private String street;

    @Max(value = 200)
    private String typeOfStreet;

    @Max(value = 200)
    private String houseNumber;

    private String furnitureList;

    private Long courierID;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date deliverDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date createdDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date modifiedDate;

    private Long creatorID;

    private Long modifierID;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getFurnitureList() {
        return furnitureList;
    }

    public void setFurnitureList(String furnitureList) {
        this.furnitureList = furnitureList;
    }

    public Long getCourierID() {
        return courierID;
    }

    public void setCourierID(Long courierID) {
        this.courierID = courierID;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Long getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(Long creatorID) {
        this.creatorID = creatorID;
    }

    public Long getModifierID() {
        return modifierID;
    }

    public void setModifierID(Long modifierID) {
        this.modifierID = modifierID;
    }

    public Date getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }
}
