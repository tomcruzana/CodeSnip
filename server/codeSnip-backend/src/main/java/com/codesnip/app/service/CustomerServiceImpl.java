package com.codesnip.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codesnip.app.dto.CustomerDto;
import com.codesnip.app.entity.Customer;
import com.codesnip.app.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// init vars to null
		String userName, password = null;
		List<GrantedAuthority> authorities = null;

		// find customer via username
		List<Customer> customer = customerRepository.findByUsername(username);

		if (customer.size() == 0) {
			// throw exception if user is not found
			throw new UsernameNotFoundException("User details not found for the user : " + username);
		} else {
			// get first occurrence of the user from the list
			userName = customer.get(0).getUsername();
			password = customer.get(0).getPassword();
			authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(customer.get(0).getRole()));
		}

		// return new user w/ details from the db
		return new User(username, password, authorities);
	}

	@Override
	public CustomerDto createCustomer(CustomerDto customerDto) {
		// persist new customer data
		Customer newCustomer = new Customer();
		newCustomer.setUsername(customerDto.getUsername());
		newCustomer.setEmail(customerDto.getEmail());
		newCustomer.setPassword(customerDto.getPassword());
		// todo: make enum roles
		newCustomer.setRole("user");
		newCustomer.setEnabled(true);
		customerRepository.save(newCustomer);
		return customerDto;
	}

}
