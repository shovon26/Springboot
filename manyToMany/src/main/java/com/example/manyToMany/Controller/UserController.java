package com.example.manyToMany.Controller;

import com.example.manyToMany.Model.Address;
import com.example.manyToMany.Model.User;
import com.example.manyToMany.Repository.UserRepository;
import com.example.manyToMany.Service.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public User getbyId(@PathVariable("id") int id){
        return userServiceImplementation.getUserbyId(id);
    }

    @PostMapping("/postOne")
    public List<User> addMultipleUser(@RequestBody List<User> user) {
        for(int i=0; i<user.size(); i++){
            User currentUser = user.get(i);
            for(Address address : currentUser.getAddresses()){
                address.setUsers(user);
            }
        }
        return userServiceImplementation.addMultipleUser(user);
    }
    @RequestMapping("/hello")  //Check LocalHost
    public String print(){
        return "Hello Users";
    }

    @DeleteMapping("/deleteId/{id}")
    public void deleteById(@PathVariable("id") int id){
        userServiceImplementation.deleteUserbyId(id);
    }

    @PutMapping("/updateId/{id}")
    public User updateById(@RequestBody User user, @PathVariable("id") int id){
        return userServiceImplementation.updateUserbyId(user, id);
    }
}
