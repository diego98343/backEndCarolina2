package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.services.CheckoutService;

import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.checkOut.Order;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderService {

    List<Order>getAll();
}
