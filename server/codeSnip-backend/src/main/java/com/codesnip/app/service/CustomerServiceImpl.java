package com.codesnip.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.codesnip.app.dto.CustomerDto;
import com.codesnip.app.entity.Customer;
import com.codesnip.app.repository.CustomerRepository;
import com.codesnip.app.util.Role;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

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

		// hash the password using bcrypt!
		String hashedPassword = passwordEncoder.encode(customerDto.getPassword());
		customerDto.setPassword(hashedPassword);
		// log

		// register current date
		customerDto.setDateCreated(new Date(System.currentTimeMillis()));
		// log

		//transfer customer data
		newCustomer.setUsername(customerDto.getUsername());
		newCustomer.setEmail(customerDto.getEmail());
		newCustomer.setPassword(customerDto.getPassword());
		newCustomer.setDateCreated(customerDto.getDateCreated());
		newCustomer.setRole(Role.ROLE_FREE_USER.name());
		newCustomer.setEnabled(true);
		customerRepository.save(newCustomer);
		// log

		return customerDto;
	}

}
