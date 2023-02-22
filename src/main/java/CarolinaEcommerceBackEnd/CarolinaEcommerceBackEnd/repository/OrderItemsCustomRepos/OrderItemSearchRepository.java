package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.repository.OrderItemsCustomRepos;

import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.checkOut.OrderItem;

import java.util.List;

public interface OrderItemSearchRepository {
    List<OrderItem> findByOrder(int order);
}
