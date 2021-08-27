package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.entity.Courier;
import hu.ulyssys.java.course.maven.entity.Furniture;
import hu.ulyssys.java.course.maven.entity.Order;
import hu.ulyssys.java.course.maven.service.AppUserService;
import hu.ulyssys.java.course.maven.service.CourierService;
import hu.ulyssys.java.course.maven.service.FurnitureService;
import hu.ulyssys.java.course.maven.service.OrderService;
import org.primefaces.PrimeFaces;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named
@ViewScoped
public class OrdersCRUDMbean extends CoreCRUDMbean<Order> implements Serializable {

    private List<Courier> courierList;

    @Inject
    private OrderService orderService;

    @Inject
    private AppUserService appUserService;

    @Inject
    private FurnitureService furnitureService;

    @Inject
    private CourierService courierService;

    @Inject
    public OrdersCRUDMbean(OrderService orderService, LoggedInUserBean loggedInUserBean, CourierService courierService) {
        super(orderService);
        courierList = courierService.getAll();
        if (!loggedInUserBean.isAdmin()) {
            throw new SecurityException("Nincs elég jogosultság");
        }
    }


    public void save(String loggedInUser) {
        if (getSelectedEntity().getDeliverDate().before(new Date())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "A dátum nem mutathat a múltba!", null));
        } else {
            getSelectedEntity().setModifierUser(appUserService.findByUsername(loggedInUser));
            getSelectedEntity().setModifiedDate(new Date());
            super.service.update(getSelectedEntity());
            PrimeFaces.current().executeScript("PF('" + dialogName() + "').hide()");
        }
    }

    public String toFurnitureString(String list){
        String result="";
        Furniture furniture = new Furniture();
        String[] splited = list.split(";");
        for (int i=0;i<splited.length;i++){
          furniture = furnitureService.findById(Long.valueOf(splited[i]));

          if(furniture == null){
              result = result.concat("Már nem rendelhető");
          }else {
              result = result.concat(furniture.getName() + ";");
          }

        }

        return result;
    }


    @Override
    protected String dialogName() {
        return "ordersDialog";
    }

    @Override
    protected Order initNewEntity() {
        return new Order();
    }

    public List<Courier> getCourierList() {
        return courierList;
    }

    public void setCourierList(List<Courier> courierList) {
        this.courierList = courierList;
    }
}
