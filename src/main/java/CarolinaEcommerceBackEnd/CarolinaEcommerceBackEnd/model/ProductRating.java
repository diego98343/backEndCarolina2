package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="productRating")
public class ProductRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="productRating_Id")
    private int productRatingId;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @Column(name="product_rating")
    private int productRating;

    @Column(name="comment")
    private String comment;



    public ProductRating() {
    }

    public ProductRating(int productRatingId, Product product, int productRating, String comment) {
        this.productRatingId = productRatingId;
        this.product = product;
        this.productRating = productRating;
        this.comment = comment;
    }

    public int getProductRatingId() {
        return productRatingId;
    }

    public void setProductRatingId(int productRatingId) {
        this.productRatingId = productRatingId;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getProductRating() {
        return productRating;
    }

    public void setProductRating(int productRating) {
        this.productRating = productRating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @JsonIgnore
    public Product getProduct() {
        return product;
    }
}
