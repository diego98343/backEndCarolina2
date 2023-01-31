package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.services.CheckoutService;

import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.Dto.Purchase;
import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.Dto.PurchaseResponse;
import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.checkOut.Customer;

import java.util.List;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
    List<Customer>getPurchaseOrders();
}
