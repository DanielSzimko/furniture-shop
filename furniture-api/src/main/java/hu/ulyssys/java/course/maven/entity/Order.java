package hu.ulyssys.java.course.maven.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order extends AbstractEntity{

    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @Column(name = "modified_date")
    private Date modifiedDate;

    @JoinColumn(name = "creator_id", nullable = false)
    @ManyToOne
    private AppUser creatorUser;

    @JoinColumn(name = "modifier_id")
    @ManyToOne
    private AppUser modifierUser;

    @Column(name = "deliver_date", nullable = false)
    private Date deliverDate;

    @JoinColumn(name = "courier_id")
    @ManyToOne
    private Courier courier;

    @Column(name = "furniture_list", nullable = false)
    private String furnitureList;

    @Column(name = "city", nullable = false)
    @Size(max = 200)
    private String city;

    @Column(name = "street", nullable = false)
    @Size(max = 200)
    private String street;

    @Column(name = "type_of_street", nullable = false)
    @Size(max = 200)
    private String typeOfStreet;

    @Column(name = "house_number", nullable = false)
    @Size(max = 200)
    private String houseNumber;

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

    public AppUser getCreatorUser() {
        return creatorUser;
    }

    public void setCreatorUser(AppUser creatorUser) {
        this.creatorUser = creatorUser;
    }

    public AppUser getModifierUser() {
        return modifierUser;
    }

    public void setModifierUser(AppUser modifierUser) {
        this.modifierUser = modifierUser;
    }

    public Date getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public String getFurnitureList() {
        return furnitureList;
    }

    public void setFurnitureList(String furnitureList) {
        this.furnitureList = furnitureList;
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
}
