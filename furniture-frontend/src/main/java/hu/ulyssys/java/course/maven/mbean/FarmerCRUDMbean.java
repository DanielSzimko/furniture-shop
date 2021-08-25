package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.entity.Farmer;
import hu.ulyssys.java.course.maven.service.FarmerService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class FarmerCRUDMbean extends CoreCRUDMbean<Farmer> implements Serializable {


    @Inject
    public FarmerCRUDMbean(FarmerService farmerService) {
        super(farmerService);

    }


    @Override
    protected String dialogName() {
        return "farmerDialog";
    }

    @Override
    protected Farmer initNewEntity() {
        return new Farmer();
    }
}
