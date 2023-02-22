package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.repository.OrderItemsCustomRepos;

import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.checkOut.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class OrderItemSearchRepositoryImpl implements OrderItemSearchRepository {


    @Autowired
    private EntityManager entityManager;



    @Override
    public List<OrderItem> findByOrder(int order) {

        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery<OrderItem> criteriaQuery=criteriaBuilder.createQuery(OrderItem.class);


        Root<OrderItem> orderItems= criteriaQuery.from(OrderItem.class);

        Predicate orderItemsReferencePredicate=criteriaBuilder.equal(orderItems.get("order"),order);
        criteriaQuery.where(orderItemsReferencePredicate);

        TypedQuery<OrderItem> query=entityManager.createQuery(criteriaQuery);


        return query.getResultList();
    }
}
