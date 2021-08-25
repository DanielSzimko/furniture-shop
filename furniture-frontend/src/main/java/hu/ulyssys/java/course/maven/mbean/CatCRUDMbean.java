package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.entity.Cat;
import hu.ulyssys.java.course.maven.service.CatService;
import hu.ulyssys.java.course.maven.service.FarmerService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class CatCRUDMbean extends FarmerAwareCRUDMBean<Cat> implements Serializable {


    @Inject
    public CatCRUDMbean(CatService catService, FarmerService farmerService) {
        super(catService, farmerService);
    }

    @Override
    protected String dialogName() {
        return "catDialog";
    }

    @Override
    protected Cat initNewEntity() {
        return new Cat();
    }
}
