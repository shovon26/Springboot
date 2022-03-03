package com.example.relational.Controller;

import com.example.relational.Model.Address;
import com.example.relational.Service.AddressServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/address")
public class AddressController {
    @Autowired
    AddressServiceImplementation addressServiceImplementation;

    @GetMapping("/getAllAddress")
    public List<Address> getAll(){
        return addressServiceImplementation.getAllAddress();
    }

    @GetMapping("/getAddressById/{id}")
    public Address getById(@PathVariable("id") int id){
        return addressServiceImplementation.getAddressById(id);
    }

    @DeleteMapping("/deleteAddressById/{id}")
    public void deleteById(@PathVariable("id") int id){
        addressServiceImplementation.deleteAddressById(id);
    }

    @PutMapping("/updateAddressById/{id}")
    public Address updateById(@RequestBody Address address, @PathVariable int id){
        return addressServiceImplementation.updateAddressById(address, id);
    }
}