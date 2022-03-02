package com.example.manyToMany.Service;

import com.example.manyToMany.Model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
    List<User> allUser();
    User getUserbyId(int id);
    User addOneUser(User user);
    List<User> addMultipleUser(List<User> user);
    void deleteUserbyId(int id);
    User updateUserbyId(User user, int id);
}
