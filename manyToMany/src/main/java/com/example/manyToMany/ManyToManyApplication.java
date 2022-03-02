package com.example.manyToMany;

import com.example.manyToMany.Model.Address;
import com.example.manyToMany.Model.User;
import com.example.manyToMany.Repository.AddressRepository;
import com.example.manyToMany.Repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ManyToManyApplication {

	public static void main(String[] args) {
//		ConfigurableApplicationContext configurableApplicationContext =
		SpringApplication.run(ManyToManyApplication.class, args);

//		UserRepository userRepository = configurableApplicationContext.getBean(UserRepository.class);
//		AddressRepository addressRepository = configurableApplicationContext.getBean(AddressRepository.class);
//
//		User Shovon = new User("Shovon", 23);
//		User Shakib = new User("Shakib", 18);
//		User Murad = new User("Murad", 24);
//		List<User> users = Arrays.asList(Shovon, Shakib, Murad);
//
//		Address ShovonAddress = new Address("14/1", "Uttara");
//		Address ShakibAddress = new Address("13/7", "Uttara, Dhaka");
//		Address MuradAddress = new Address("Mh-1342", "Savar");
//
//		List<Address> addresses = Arrays.asList(ShovonAddress, ShakibAddress, MuradAddress);
//
//		addressRepository.saveAll(addresses);
//		Shovon.followedAddress(ShovonAddress);
//		Shakib.followedAddress(ShakibAddress);
//		Murad.followedAddress(MuradAddress);
//		Murad.followedAddress(ShovonAddress);
//		userRepository.saveAll(users);
	}
}