package com.example.relational.Service;

import com.example.relational.Model.Address;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AddressService {
    List<Address> getAllAddress();
    Address getAddressById(int id);
    void deleteAddressById(int id);
    Address updateAddressById(Address address, int id);
}
