package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.controllers.checkOutControllers;

import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.checkOut.Customer;
import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class CustomerController {


    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/customerByEmail/{email}")
    public ResponseEntity<List<Customer>>  getCustomerByEmail(@PathVariable("email") String email){
        List<Customer> customer =customerRepository.getCustomerByEmail(email);
        return new ResponseEntity<List<Customer>>(customer,HttpStatus.OK);
    }

    @GetMapping("/customerById/{id}")
    public ResponseEntity<List<Customer>>  getCustomerById(@PathVariable("id") int id){
        List<Customer> customer =customerRepository.getCustomerById(id);
        return new ResponseEntity<List<Customer>>(customer,HttpStatus.OK);
    }


}
