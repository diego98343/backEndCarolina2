package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.controllers.checkOutControllers;

import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.checkOut.Address;
import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.checkOut.OrderItem;
import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class AddressController {

   @Autowired
   AddressRepository addressRepository;

    @GetMapping("/addressByProductId/{orderId}")
    public ResponseEntity<List<Address>> getAllOrderItemsByProductId(@PathVariable("orderId")int order){

        List<Address> address = addressRepository.getAddressByOrder(order);

        return new ResponseEntity<List<Address>>(address, HttpStatus.OK);
    }


}
