package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.entity.Courier;
import hu.ulyssys.java.course.maven.service.AppUserService;
import hu.ulyssys.java.course.maven.service.CourierService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;

@Named
@ViewScoped
public class CourierCRUDMbean extends CoreCRUDMbean<Courier> {

    @Inject
    private AppUserService service;

    @Inject
    public CourierCRUDMbean(CourierService courierService, LoggedInUserBean loggedInUserBean) {
        super(courierService);
        if (!loggedInUserBean.isAdmin()) {
            throw new SecurityException("Nincs elég jogosultság");
        }
    }

    public void save(String loggedInUser) {
        if(!(getSelectedEntity().getFirstName().equals(getSelectedEntity().getLastName()))) {
            if (getSelectedEntity().getId() == null) {
                getSelectedEntity().setCreatedDate(new Date());
                getSelectedEntity().setCreatorUser(service.findByUsername(loggedInUser));
            }
            getSelectedEntity().setModifiedDate(new Date());
            getSelectedEntity().setModifierUser(service.findByUsername(loggedInUser));
            super.save();
        } else {
            throw new SecurityException("Nem lehet ugyanaz a keresztnev es a vezeteknev");
        }
    }

    @Override
    protected String dialogName() {
        return "courierDialog";
    }

    @Override
    protected Courier initNewEntity() {
        return new Courier();
    }
}
