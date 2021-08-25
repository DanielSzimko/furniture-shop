package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.entity.Courier;
import hu.ulyssys.java.course.maven.entity.Order;
import hu.ulyssys.java.course.maven.service.AppUserService;
import hu.ulyssys.java.course.maven.service.CourierService;
import hu.ulyssys.java.course.maven.service.OrderService;
import org.primefaces.PrimeFaces;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class OrdersCRUDMbean extends CoreCRUDMbean<Order> implements Serializable {

    private List<Courier> courierList;

    private Order selectedEntity;

    @Inject
    private OrderService orderService;

    @Inject
    public OrdersCRUDMbean(OrderService orderService, LoggedInUserBean loggedInUserBean, CourierService courierService) {
        super(orderService);
        courierList = courierService.getAll();
        if (!loggedInUserBean.isAdmin()) {
            throw new SecurityException("Nincs elég jogosultság");
        }
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
