package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.services.CheckoutServices;

import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.checkOut.Order;
import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServicelpm implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order>getAll(){
        return orderRepository.findAll();
    }
}
