package hu.ulyssys.java.course.maven.entity;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractAnimal extends AbstractEntity implements AnimalTypeAware {

    @Column(name = "name")
    private String name;
    @Column(name = "legs_number")
    private Integer legsNumber;

    @JoinColumn(name = "farmer_id")
    @ManyToOne
    private Farmer farmer;

    public AbstractAnimal() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLegsNumber() {
        return legsNumber;
    }

    public void setLegsNumber(Integer legsNumber) {
        this.legsNumber = legsNumber;
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }

}
