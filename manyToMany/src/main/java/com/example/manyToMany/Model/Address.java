package com.example.manyToMany.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "address")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int addressId;
    private String street;
    private String city;

    @ManyToMany(mappedBy = "addresses")
//    @JsonBackReference
    private List<User> users = new ArrayList<>();

    public Address() {
    }

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public void addUser(User user){
        users.add(user);
    }

}
