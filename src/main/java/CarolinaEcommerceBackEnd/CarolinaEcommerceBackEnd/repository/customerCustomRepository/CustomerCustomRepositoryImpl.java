package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.repository.customerCustomRepository;

import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.checkOut.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class CustomerCustomRepositoryImpl implements CustomerCustomRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Customer> getCustomerByEmail(String email) {

        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> criteriaQuery=criteriaBuilder.createQuery(Customer.class);


        Root<Customer> customer= criteriaQuery.from(Customer.class);

        Predicate customerPredicate=criteriaBuilder.equal(customer.get("email"),email);
        criteriaQuery.where(customerPredicate);

        TypedQuery<Customer> query=entityManager.createQuery(criteriaQuery);

        return query.getResultList();

    }
}
