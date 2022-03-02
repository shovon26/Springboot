package com.example.manyToMany.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String name;
    private int age;

    @ManyToMany(targetEntity = Address.class, cascade = CascadeType.ALL)
    @JoinTable(
            name = "followed_addresses",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    @JsonIgnoreProperties("users")
    @ToString.Exclude
    private List<Address> addresses = new ArrayList<>();

//    public User(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }

    public void followedAddress(Address address){
        addresses.add(address);
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
//        User user = (User) o;
//        return false;
//    }
//
//    @Override
//    public int hashCode() {
//        return getClass().hashCode();
//    }
}
