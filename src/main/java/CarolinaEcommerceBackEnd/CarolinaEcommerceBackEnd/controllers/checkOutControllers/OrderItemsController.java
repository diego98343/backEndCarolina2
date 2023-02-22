package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.controllers.checkOutControllers;

import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.checkOut.OrderItem;
import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.repository.OrderItemsCustomRepos.OrderItemSearchRepository;

import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.repository.OrderItemsRepository;
import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.services.CheckoutServices.OrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class OrderItemsController {

    @Autowired
    OrderItemsService orderItemsService;




   @Autowired
   //remember to always use the main repository when you create a custom query repository
   OrderItemsRepository orderItemsRepository;


    @GetMapping("/orderItems")
    public ResponseEntity<List<OrderItem>>getAllOrderItems(){

      List<OrderItem> orderItems = orderItemsService.getAll();

      return new ResponseEntity<List<OrderItem>>(orderItems, HttpStatus.OK);
    }


    @GetMapping("/orderItemsByProductId/{orderId}")
    public ResponseEntity<List<OrderItem>>getAllOrderItemsByProductId(@PathVariable("orderId")int order){

        List<OrderItem> orderItems = orderItemsRepository.findByOrder(order);

        return new ResponseEntity<List<OrderItem>>(orderItems, HttpStatus.OK);
    }


}
