package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.services.CheckoutServices;

import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.Dto.Purchase;
import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.Dto.PurchaseResponse;
import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.checkOut.Customer;
import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.checkOut.Order;
import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.checkOut.OrderItem;
import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class CheckOutServicelpml implements   CheckoutService {


    private final CustomerRepository customerRepository;

    //this constructor replace the AUTOWIRED
    public CheckOutServicelpml(CustomerRepository customerRepository ){
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase){

        //retrieve the order info from dto
        Order order = purchase.getOrder();
        //generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);
        //populate order with orderItems
        List<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item->order.add(item));
        //populate order with  billingAddress and shippingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        //populate customer with order
        Customer customer = purchase.getCustomer();
        customer.add(order);

        //save to the dataBase
        customerRepository.save(customer);


        return  new PurchaseResponse(orderTrackingNumber);
    }


    private String generateOrderTrackingNumber() {

        return UUID.randomUUID().toString();
    }


    @Override
    public List<Customer>getAllCustomers(){
        return customerRepository.findAll();
    }

}
