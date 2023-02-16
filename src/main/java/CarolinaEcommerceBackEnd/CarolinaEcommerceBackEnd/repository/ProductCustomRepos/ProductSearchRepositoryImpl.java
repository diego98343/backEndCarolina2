package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.repository.ProductCustomRepos;

import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.Product;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class ProductSearchRepositoryImpl implements ProductSearchRepository {
    @Autowired
    private EntityManager entityManager;
    @Override
    public List<Product> findByName(String productName) {

        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery=criteriaBuilder.createQuery(Product.class);

        Root<Product> product= criteriaQuery.from(Product.class);

        Predicate productNamePredicate=criteriaBuilder.equal(product.get("productName"),productName);


        criteriaQuery.where(productNamePredicate);

        TypedQuery<Product> query=entityManager.createQuery(criteriaQuery);

        return query.getResultList();

    }
}
