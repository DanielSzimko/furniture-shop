package hu.ulyssys.java.course.maven.service;

import hu.ulyssys.java.course.maven.entity.Dog;

public interface DogService extends CoreService<Dog>, FarmerAwareService<Dog> {
}
