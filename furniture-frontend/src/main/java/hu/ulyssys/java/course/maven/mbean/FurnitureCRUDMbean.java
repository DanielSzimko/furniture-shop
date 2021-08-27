package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.entity.Furniture;
import hu.ulyssys.java.course.maven.entity.Order;
import hu.ulyssys.java.course.maven.mbean.model.CartModel;
import hu.ulyssys.java.course.maven.service.AppUserService;
import hu.ulyssys.java.course.maven.service.FurnitureService;
import hu.ulyssys.java.course.maven.service.OrderService;
import org.primefaces.PrimeFaces;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named
@SessionScoped
public class FurnitureCRUDMbean extends CoreCRUDMbean<Furniture> implements Serializable {

    private List<Furniture> actualOrder;

    private CartModel cartModel;


    @Inject
    private AppUserService service;

    @Inject
    private OrderService orderService;

    @Inject
    public FurnitureCRUDMbean(FurnitureService furnitureService) {
        super(furnitureService);
    }

    @PostConstruct
    public void init(){
        actualOrder = new ArrayList<>();
        cartModel = new CartModel();
    }



    public void addCart(Furniture furniture){
        List<Furniture> cart = new ArrayList<>(getActualOrder());
        cart.add(furniture);
        setActualOrder(cart);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeresen hozzáadtad a kosárhoz!"));
    }

    public void deleteFromCart(Furniture furniture){
        List<Furniture> cart = new ArrayList<>(getActualOrder());
        cart.remove(furniture);
        setActualOrder(cart);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeresen törölted a kosárból!"));
    }

    public void Checkout(List<Furniture> list, String username){
        Order order = new Order();
        String orderList = "";
        for (Furniture furniture : actualOrder) {
            orderList = orderList.concat(furniture.toString() + ";");
        }
        order.setFurnitureList(orderList);
        order.setCreatedDate(new Date());
        order.setCourier(null);
        order.setModifierUser(null);
        order.setCreatorUser(service.findByUsername(username));
        order.setCity(cartModel.getCity());
        order.setDeliverDate(new Date());
        order.setStreet(cartModel.getStreet());
        order.setTypeOfStreet(cartModel.getTypeOfStreet());
        order.setHouseNumber(String.valueOf(cartModel.getHouseNumber()));
        orderService.add(order);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeresen leadtad a rendelésed!"));
        order = new Order();
        actualOrder = new ArrayList<>();
        PrimeFaces.current().executeScript("PF('" + cartDialogName() + "').hide()");
    }

    public void save(String loggedInUser) {
        if (getSelectedEntity().getId() == null) {
            getSelectedEntity().setCreatedDate(new Date());
            getSelectedEntity().setCreatorUser(service.findByUsername(loggedInUser));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres mentés"));
        }
        getSelectedEntity().setModifiedDate(new Date());
        getSelectedEntity().setModifierUser(service.findByUsername(loggedInUser));
        super.save();

    }

    public List<Furniture> getActualOrder() {
        return actualOrder;
    }

    public void setActualOrder(List<Furniture> actualOrder) {
        this.actualOrder = actualOrder;
    }

    public CartModel getCartModel() {
        return cartModel;
    }

    public void setCartModel(CartModel cartModel) {
        this.cartModel = cartModel;
    }

    protected String cartDialogName(){
        return "cartDialog";
    }

    @Override
    protected String dialogName() {
        return "furnitureDialog";
    }

    @Override
    protected Furniture initNewEntity() {
        return new Furniture();
    }
}
