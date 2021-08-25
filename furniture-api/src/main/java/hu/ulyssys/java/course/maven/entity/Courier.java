package hu.ulyssys.java.course.maven.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table
public class Courier extends AbstractEntity{

    @Column(name = "lastname", nullable = false)
    @Size(max = 500)
    private String lastName;

    @Column(name = "firstname", nullable = false)
    @Size(max = 500)
    private String firstName;

    @Column(name = "mobile_number", nullable = false)
    private String mobileNumber;

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
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

    @Override
    public String toString() {
        return ""+ firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Courier)) return false;

        Courier courier = (Courier) o;

        if (lastName != null ? !lastName.equals(courier.lastName) : courier.lastName != null) return false;
        if (firstName != null ? !firstName.equals(courier.firstName) : courier.firstName != null) return false;
        if (mobileNumber != null ? !mobileNumber.equals(courier.mobileNumber) : courier.mobileNumber != null)
            return false;
        if (createdDate != null ? !createdDate.equals(courier.createdDate) : courier.createdDate != null) return false;
        if (modifiedDate != null ? !modifiedDate.equals(courier.modifiedDate) : courier.modifiedDate != null)
            return false;
        if (creatorUser != null ? !creatorUser.equals(courier.creatorUser) : courier.creatorUser != null) return false;
        return modifierUser != null ? modifierUser.equals(courier.modifierUser) : courier.modifierUser == null;
    }

    @Override
    public int hashCode() {
        int result = lastName != null ? lastName.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (mobileNumber != null ? mobileNumber.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (modifiedDate != null ? modifiedDate.hashCode() : 0);
        result = 31 * result + (creatorUser != null ? creatorUser.hashCode() : 0);
        result = 31 * result + (modifierUser != null ? modifierUser.hashCode() : 0);
        return result;
    }
}
