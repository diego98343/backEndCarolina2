package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.repository.OrderAddressCustomRepository;

import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.checkOut.Address;
import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.checkOut.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class OrderAddressCustomRepositoryImpl implements OrderAddressCustomRepository {

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Address> getAddressByOrder(int order) {

        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery<Address> criteriaQuery=criteriaBuilder.createQuery(Address.class);


        Root<Address> Address= criteriaQuery.from(Address.class);

        Predicate addressReferencePredicate=criteriaBuilder.equal(Address.get("order"),order);
        criteriaQuery.where(addressReferencePredicate);

        TypedQuery<Address> query=entityManager.createQuery(criteriaQuery);

        return query.getResultList();
    }
}
