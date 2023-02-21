package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.services.CheckoutServices;

import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.checkOut.OrderItem;

import java.util.List;

public interface OrderItemsService {

    List<OrderItem> getAll();
}
