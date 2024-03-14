package org.projects.projectsMs.web;

import org.projects.projectsMs.entities.Customer;
import org.projects.projectsMs.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private CustomerService customerService;


    @GetMapping("/Customers")
    public List<Customer> AllCustomers(){
        return customerService.GetCustomers();
    }


    @GetMapping("/Customers/{id}")
    public Customer CustomerByID(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }


    @PostMapping("/CreateCustomer")
    public Customer CreateCustomer(@RequestBody Customer customer){
        return customerService.CreateCustomer(customer);
    }
}
