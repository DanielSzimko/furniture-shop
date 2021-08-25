package hu.ulyssys.java.course.maven.dao;

import hu.ulyssys.java.course.maven.entity.Farmer;

public interface FarmerDAO extends CoreDAO<Farmer> {

    Farmer findByName(String name);


}
