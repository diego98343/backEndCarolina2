package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.repository.customerCustomRepository;

import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.checkOut.Customer;

import java.util.List;

public interface CustomerCustomRepository {


    List<Customer> getCustomerByEmail(String email);
    List<Customer> getCustomerById(int id);

}
