package com.codesnip.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

		// transfer customer data
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

	@Override
	public CustomerDto readByUsername(String username) {
		CustomerDto customerDto;
		List<Customer> customers = customerRepository.findByUsername(username);

		if (customers.size() > 0) {
			// convert and return customer to customerDto type
			customerDto = new CustomerDto(customers.get(0));
			// log
			return customerDto;
		}

		// return null if no customer is found!
		return null;
	}

}
