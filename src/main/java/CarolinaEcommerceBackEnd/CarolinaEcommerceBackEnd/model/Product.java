package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="product")
public class Product {


    //UPDATE APPLICATION PROPERTIES TO USE @COLUM
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_Id")
    private int productId;

    @Column(name="productName")
    private  String productName;

    @Column(name="description")
    private String description;

    @Column(name="productPrice")
    private int productPrice;

    @ManyToOne
    @JoinColumn(name="category_id")
    private ProductCategory productCategory;

    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;


    @Column(name = "last_updated")
    @UpdateTimestamp
    private Date lastUpdated;

    @Column(name = "units_in_stock")
    private int unitsInStock;

    @Size(min = 5)
    @Column(name = "imageURL")
    private String imageURl;



    @Column(name = "productReference")
    private String productReference;



    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="product_image",
           joinColumns = {
            @JoinColumn(name="product_id")
           },
            inverseJoinColumns = {
            @JoinColumn(name="image_id")
            }
    )
    private Set<Attachment> productImage;

    public Product(int productId, String productName, String description, int productPrice, ProductCategory productCategory, Date dateCreated, boolean active, Date lastUpdated, int unitsInStock, String imageURl, Boolean displayProduct, String size, String productReference, Set<Attachment> productImage) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.dateCreated = dateCreated;

        this.lastUpdated = lastUpdated;
        this.unitsInStock = unitsInStock;
        this.imageURl = imageURl;


        this.productReference = productReference;
        this.productImage = productImage;
    }

    public Product() {
    }


    @JsonBackReference
    public ProductCategory getProductCategory() {
        return productCategory;
    }






    public String getProductReference() {
        return productReference;
    }

    public void setProductReference(String productReference) {
        this.productReference = productReference;
    }

    public String getImageURl() {
        return imageURl;
    }

    public void setImageURl(String imageURl) {
        this.imageURl = imageURl;
    }

    public Set<Attachment> getProductImage() {
        return productImage;
    }

    public void setProductImage(Set<Attachment> productImage) {
        this.productImage = productImage;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }
}
