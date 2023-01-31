package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.services.RegistrationRespoFile;

import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User saveRegistration(User registration);

    User findRegistrationById(int id);

    void delete(int id );
}
