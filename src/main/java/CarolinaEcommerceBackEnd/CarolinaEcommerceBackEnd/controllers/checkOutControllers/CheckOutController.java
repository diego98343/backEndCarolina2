package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.controllers.checkOutControllers;

import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.Dto.Purchase;
import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.Dto.PurchaseResponse;
import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.checkOut.Customer;
import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.services.CheckoutServices.CheckoutService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class CheckOutController {


    //the constructor replace the auto-wire//
    private final CheckoutService checkoutService;


    public CheckOutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase){

      PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);

        return  purchaseResponse;
  }

   @GetMapping("/customers")
   public ResponseEntity<List<Customer>> getAllCustumers(){
        List<Customer> allCustomer= checkoutService.getAllCustomers();
        return new ResponseEntity<List<Customer>>(allCustomer,HttpStatus.OK);
   }





}
