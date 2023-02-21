package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.services.RegistrationServices;

import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.User;
import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceML implements UserService {
    
    
    @Autowired
    UserRepository registrationRepository;
    
    @Override
    public List<User> findAll(){
        return registrationRepository.findAll();
    }

    @Override
    public User saveRegistration(User registration) {
        registrationRepository.save(registration);
        return registration;
    }

    @Override
    public User findRegistrationById(int id) {

        if(registrationRepository.findById(id).isPresent()){
            User userRegistration = registrationRepository.findById(id).get();
            return  userRegistration;
        }

        return null;
    }

    @Override
    public void delete(int id) {
      User user = findRegistrationById(id);
      registrationRepository.delete(user);
    }


}
