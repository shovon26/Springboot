package com.example.relational.Service;

import com.example.relational.Model.User;

import java.util.List;

public interface UserService {
    List<User> allUser();
    User getUserbyId(int id);
    User addOneUser(User user);
    List<User> addMultipleUser(List<User> user);
    void deleteUserbyId(int id);
}
