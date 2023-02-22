package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.repository.OrderAddressCustomRepository;

import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.checkOut.Address;

import java.util.List;

public interface OrderAddressCustomRepository {

    List<Address> getAddressByOrder(int order);
}
