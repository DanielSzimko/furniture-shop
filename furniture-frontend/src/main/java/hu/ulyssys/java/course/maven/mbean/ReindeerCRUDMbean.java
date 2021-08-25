package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.entity.Reindeer;
import hu.ulyssys.java.course.maven.service.FarmerService;
import hu.ulyssys.java.course.maven.service.ReindeerService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class ReindeerCRUDMbean extends FarmerAwareCRUDMBean<Reindeer> {

    @Inject
    public ReindeerCRUDMbean(ReindeerService reindeerService, FarmerService farmerService) {
        super(reindeerService, farmerService);
    }

    @Override
    protected String dialogName() {
        return "reindeerDialog";
    }

    @Override
    protected Reindeer initNewEntity() {
        return new Reindeer();
    }
}
