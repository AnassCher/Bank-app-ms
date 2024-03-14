package org.projects.projectsMs.services;

import org.projects.projectsMs.entities.Customer;
import org.projects.projectsMs.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    public List<Customer> GetCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id){
        return customerRepository.findById(id).get();
    }

    public Customer CreateCustomer(Customer customer){
        return customerRepository.save(customer);
    }
}
