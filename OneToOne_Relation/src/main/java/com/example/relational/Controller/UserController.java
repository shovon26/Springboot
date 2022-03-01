package com.example.relational.Controller;

import com.example.relational.Model.User;
import com.example.relational.Repository.UserRepository;
import com.example.relational.Service.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.JstlUtils;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserServiceImplementation userServiceImplementation;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/getAll")
    public List<User> getAll(){
        return userServiceImplementation.allUser();
    }
    @GetMapping("/getId/{id}")
    public User getUserById(@PathVariable("id") int id){
        return userServiceImplementation.getUserbyId(id);
    }

    @PostMapping("/postOne")
    public User addUser(@RequestBody  User user) {
        return userServiceImplementation.addOneUser(user);
    }
    @PostMapping("/postMultiple")
    public List<User> addMultipleUser(@RequestBody List<User> users){
        return userServiceImplementation.addMultipleUser(users);
    }

    @DeleteMapping("/deleteId/{id}")
    public void deleteUser(@PathVariable("id") int id){
        userServiceImplementation.deleteUserbyId(id);
    }

    @PutMapping("/updateId/{id}")
    public User updateUser(@RequestBody User user,@PathVariable int id) {

        return userRepository.findById(id).map(
                        userTemp -> {
                            userTemp.setName(user.getName());
                            userTemp.setAge(user.getAge());
                            userTemp.setAddress(user.getAddress());
                            return userRepository.save(userTemp);
                        })
                .orElseGet(() -> {
                            return  userRepository.save(user);
                        }
                );
    }
}