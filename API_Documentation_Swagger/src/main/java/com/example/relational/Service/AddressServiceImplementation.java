package com.example.relational.Service;

import com.example.relational.Model.Address;
import com.example.relational.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImplementation implements AddressService{

    @Autowired
    AddressRepository addressRepository;

    @Override
    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddressById(int id) {
        return addressRepository.findById(id).get();
    }

    @Override
    public void deleteAddressById(int id) {
        addressRepository.deleteById(id);
    }

    @Override
    public Address updateAddressById(Address address, int id) {
        return addressRepository.findById(id).map(
                address1 -> {
                    address1.setStreet(address.getStreet());
                    address1.setCity(address.getCity());
                    return addressRepository.save(address1);
                })
                .orElseGet(() ->{
                    return addressRepository.save(address);
                });
    }
}
