package hu.ulyssys.java.course.maven.service;

import hu.ulyssys.java.course.maven.entity.Cat;

public interface CatService extends CoreService<Cat>, FarmerAwareService<Cat> {

}
