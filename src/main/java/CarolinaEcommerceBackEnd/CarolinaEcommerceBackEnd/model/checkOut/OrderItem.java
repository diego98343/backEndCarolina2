package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.checkOut;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  id;

    private String imageUrl;

    private String name;

    private String reference;

    private BigDecimal unitPrice;

    private int quantity;
    
    private String size;

    private Long productId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public OrderItem(int id, String imageUrl, String name, BigDecimal unitPrice, int quantity, String size, Long productId, Order order) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.size = size;
        this.productId = productId;
        this.order = order;
    }

    public OrderItem() {
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
    @JsonBackReference
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
