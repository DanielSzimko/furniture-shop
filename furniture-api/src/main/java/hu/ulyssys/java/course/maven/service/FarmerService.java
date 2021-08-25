package hu.ulyssys.java.course.maven.service;

import hu.ulyssys.java.course.maven.entity.Farmer;

public interface FarmerService extends CoreService<Farmer> {

    Farmer findByName(String name);
}
