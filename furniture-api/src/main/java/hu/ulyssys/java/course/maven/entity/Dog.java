package hu.ulyssys.java.course.maven.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Dog extends AbstractAnimal {
    @Override
    public AnimalType getType() {
        return AnimalType.DOG;
    }
}
