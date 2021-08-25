package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.entity.Slug;
import hu.ulyssys.java.course.maven.service.FarmerService;
import hu.ulyssys.java.course.maven.service.SlugService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class SlugCRUDMbean extends FarmerAwareCRUDMBean<Slug> implements Serializable {


    @Inject
    public SlugCRUDMbean(SlugService slugService, FarmerService farmerService) {
        super(slugService, farmerService);

    }


    @Override
    protected String dialogName() {
        return "slugDialog";
    }

    @Override
    protected Slug initNewEntity() {
        return new Slug();
    }
}
