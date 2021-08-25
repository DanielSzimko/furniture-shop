package hu.ulyssys.java.course.maven.converter;

import hu.ulyssys.java.course.maven.entity.Farmer;
import hu.ulyssys.java.course.maven.service.FarmerService;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class FarmerConverter implements Converter {

    @Inject
    private FarmerService farmerService;


    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s == null) {
            return null;
        }
        //SQL query lesz majd, findByName
        return farmerService.findByName(s);

    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o instanceof Farmer) {
            return ((Farmer) o).getFullName();
        }
        if (o instanceof String) {
            return o.toString();
        }
        return null;
    }
}
