package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.repository;


import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.checkOut.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productItemsRepositoy extends JpaRepository<OrderItem,Integer> {
}
