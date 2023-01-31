package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.Dto;

import lombok.Data;

@Data
public class PurchaseResponse {

    private String orderTrackingNumber;


    public PurchaseResponse(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }

    public PurchaseResponse() {
    }

    public String getOrderTrackingNumber() {
        return orderTrackingNumber;
    }

    public void setOrderTrackingNumber(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }
}
