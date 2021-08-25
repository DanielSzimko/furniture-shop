package hu.ulyssys.java.course.maven.service.impl;

import hu.ulyssys.java.course.maven.entity.Dog;
import hu.ulyssys.java.course.maven.service.DogService;

import javax.ejb.Stateless;

@Stateless
public class DogServiceImpl extends AbstractFarmerServiceImpl<Dog>  implements DogService {

}
