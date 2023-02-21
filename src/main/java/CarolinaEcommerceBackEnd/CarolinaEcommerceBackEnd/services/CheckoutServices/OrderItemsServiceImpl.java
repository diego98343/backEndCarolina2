package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.services.CheckoutServices;

import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.checkOut.OrderItem;
import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.repository.OrderItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderItemsServiceImpl implements OrderItemsService {

    @Autowired
    OrderItemsRepository orderItemsRepository;

    @Override
    public List<OrderItem> getAll() {
       return  orderItemsRepository.findAll();
    }

}
