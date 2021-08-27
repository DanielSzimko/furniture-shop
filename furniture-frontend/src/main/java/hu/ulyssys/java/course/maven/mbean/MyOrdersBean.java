package hu.ulyssys.java.course.maven.mbean;

import hu.ulyssys.java.course.maven.entity.Furniture;
import hu.ulyssys.java.course.maven.entity.Order;
import hu.ulyssys.java.course.maven.service.FurnitureService;
import hu.ulyssys.java.course.maven.service.OrderService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class MyOrdersBean extends CoreCRUDMbean<Order> {

    List<Order> myOrdersList;

    @Inject
    private OrderService orderService;

    @Inject
    private FurnitureService furnitureService;

    @Inject
    public MyOrdersBean(OrderService orderService) {
        super(orderService);
    }

    @PostConstruct
    public void init(){
        myOrdersList = new ArrayList<>();
    }

    public List<Order> findMyOrders(Long id){
       return orderService.findOrderByUserId(id);
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
        return "myOrderDialog";
    }

    @Override
    protected Order initNewEntity() {
        return new Order();
    }

    public List<Order> getMyOrdersList() {
        return myOrdersList;
    }

    public void setMyOrdersList(List<Order> myOrdersList) {
        this.myOrdersList = myOrdersList;
    }
}
