package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.entity.AbstractAnimal;
import hu.ulyssys.java.course.maven.entity.Farmer;
import hu.ulyssys.java.course.maven.service.CoreService;
import hu.ulyssys.java.course.maven.service.FarmerService;

import java.util.List;

public abstract class FarmerAwareCRUDMBean<T extends AbstractAnimal> extends CoreCRUDMbean<T> {
    private List<Farmer> farmerList;

    public FarmerAwareCRUDMBean(CoreService<T> service, FarmerService farmerService) {
        super(service);
        farmerList = farmerService.getAll();
    }


    public List<Farmer> getFarmerList() {
        return farmerList;
    }

    public void setFarmerList(List<Farmer> farmerList) {
        this.farmerList = farmerList;
    }
}
