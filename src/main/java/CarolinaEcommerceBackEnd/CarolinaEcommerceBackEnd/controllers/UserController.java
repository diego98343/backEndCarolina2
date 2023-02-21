package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.controllers;


import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.User;
import CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.services.RegistrationServices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class UserController {


    @Autowired
    UserService userService;

    @PostMapping("/user")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user){

        User userForm= userService.saveRegistration(user);

        return new ResponseEntity<User>(userForm,HttpStatus.CREATED);
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUsers(){

        List<User> userList = userService.findAll();
        return new ResponseEntity<List<User>>(userList,HttpStatus.OK);

    }


    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id){

        userService.delete(id);

        return new ResponseEntity<String>("user was deleted",HttpStatus.OK);

    }
















}
