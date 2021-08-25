package hu.ulyssys.java.course.maven.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table
public class Furniture extends AbstractEntity{

    @Column(name = "name", nullable = false)
    @Size(max = 200)
    private String name;

    @Column(name = "description", nullable = false)
    @Size(max = 500)
    private String description;

    @Column(name = "price", nullable = false)
    private Integer price;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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
        return "" +super.getId();
    }
}
