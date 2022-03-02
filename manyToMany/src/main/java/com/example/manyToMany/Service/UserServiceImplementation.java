package com.example.manyToMany.Service;

import com.example.manyToMany.Model.Address;
import com.example.manyToMany.Model.User;
import com.example.manyToMany.Repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImplementation implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> allUser() {
        List<User> users = new ArrayList<>();
        List<User> mUsers = new ArrayList<>(); // Temporary Users

        try {
            users =  userRepository.findAll();
//            for (User u:users
//                 ) {
//                User user = new User();
//                BeanUtils.copyProperties(u,user,"addresses");
//                List<Address> addresses = new ArrayList<>();
//                for (Address a:u.getAddresses()
//                ) {
//                    Address address = new Address();
//                    BeanUtils.copyProperties(a,address,"users");
//                    addresses.add(address);
//                }
//                user.setAddresses(addresses);
//                mUsers.add(user);
//            }

        }catch (Exception e){ e.getMessage();}
        return users;
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

    @Override
    public User updateUserbyId(User user, int id) {
//        User userTemp = userRepository.findById(id);
//        userTemp.setName(user.getName());
//        userTemp.setAge(user.getAge());
//        userTemp.setAddresses(user.getAddresses());
//        return userRepository.save(userTemp);
         return userRepository.findById(id).map(
                        usertemp -> {
                            usertemp.setName(user.getName());
                            usertemp.setAge(user.getAge());
                            usertemp.setAddresses(user.getAddresses());
                            return userRepository.save(usertemp);
                        })
                .orElseGet(() ->{
                    return userRepository.save(user);
                });
    }
}
