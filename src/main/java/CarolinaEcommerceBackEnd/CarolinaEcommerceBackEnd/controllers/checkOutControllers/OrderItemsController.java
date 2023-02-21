package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.controllers.checkOutControllers;

import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.checkOut.OrderItem;
import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.services.CheckoutServices.OrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class OrderItemsController {

    @Autowired
    OrderItemsService orderItemsService;


    @GetMapping("/orderItems")
    public ResponseEntity<List<OrderItem>>getAllOrderItems(){

      List<OrderItem> orderItems = orderItemsService.getAll();

      return new ResponseEntity<List<OrderItem>>(orderItems, HttpStatus.OK);
    }


}
