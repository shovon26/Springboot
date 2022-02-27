package com.example.relational.Service;

import com.example.relational.Model.User;
import com.example.relational.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserServiceImplementation  implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> allUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserbyId(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User addOneUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> addMultipleUser(List<User> user) {
        return userRepository.saveAll(user);
    }

    @Override
    public void deleteUserbyId(int id) {
        userRepository.deleteById(id);
    }

}
