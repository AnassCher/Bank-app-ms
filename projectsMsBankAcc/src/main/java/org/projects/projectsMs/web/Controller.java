package org.projects.projectsMs.web;

import org.projects.projectsMs.Clients.CustomerRestClient;
import org.projects.projectsMs.entities.Account;
import org.projects.projectsMs.model.Customer;
import org.projects.projectsMs.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class Controller {

    @Autowired
    private CustomerRestClient customerRestClient;
    @Autowired
    private AccountRepository accountRepository;


    @GetMapping("/accounts/{id}")
    public Account GetAccount(@PathVariable String id){
        Account account = accountRepository.findById(id).get();
        Customer customer = customerRestClient.findCustomerById(account.getCustomerId());
        account.setCustomer(customer);
        return account;
    }

    @GetMapping("/accounts")
    public List<Account> GetAllAccounts(){
        List<Account> accountList = accountRepository.findAll();
        accountList.forEach(account -> {
                System.err.print(account.getCustomerId());
                Customer customer = customerRestClient.findCustomerById(account.getCustomerId());
                account.setCustomer(customer);
        });
        return accountList;
    }

    @PostMapping("/createAccount")
    public Account CreateAccount(@RequestBody Account account){
        if(customerRestClient.findCustomerById(account.getCustomerId()) != null){
            return accountRepository.save(account);
        }
        throw new RuntimeException();
    }
}
