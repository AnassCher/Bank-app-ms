package org.projects.projectsMs.Clients;

import org.projects.projectsMs.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {

    @GetMapping("/Customers/{id}")
    Customer findCustomerById(@PathVariable Long id);

    @GetMapping("/Customers")
    List<Customer> allCustomers();
}
