package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.repository;


import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.checkOut.OrderItem;
import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.repository.OrderItemsCustomRepos.OrderItemSearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItem,Integer>, OrderItemSearchRepository {
}
