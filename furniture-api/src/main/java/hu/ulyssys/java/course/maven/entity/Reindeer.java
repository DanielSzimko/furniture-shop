package hu.ulyssys.java.course.maven.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Reindeer extends AbstractAnimal {

    @Column(name = "horn_number")
    private Integer hornNumber;

    @Override
    public AnimalType getType() {
        return AnimalType.REINDEER;
    }

    public Integer getHornNumber() {
        return hornNumber;
    }

    public void setHornNumber(Integer hornNumber) {
        this.hornNumber = hornNumber;
    }
}
