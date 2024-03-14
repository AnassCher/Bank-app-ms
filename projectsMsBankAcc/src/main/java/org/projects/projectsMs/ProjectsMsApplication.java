package org.projects.projectsMs;

import org.projects.projectsMs.Clients.CustomerRestClient;
import org.projects.projectsMs.entities.Account;
import org.projects.projectsMs.enumerators.AccountType;
import org.projects.projectsMs.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;
import java.util.random.RandomGenerator;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ProjectsMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectsMsApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountRepository accountRepository, CustomerRestClient customerRestClient){
		return args -> {
			customerRestClient.allCustomers().forEach(customer -> {
				Account account = Account.builder()
						.AccountId(UUID.randomUUID().toString())
						.Type(AccountType.CURRENT_ACCOUNT)
						.Currency("MAD")
						.CustomerId(customer.getId())
						.CreateAt(LocalDate.now())
						.Balance(Math.random()*10000)
						.build();
				Account account2 = Account.builder()
						.AccountId(UUID.randomUUID().toString())
						.Type(AccountType.SAVING_ACCOUNT)
						.Currency("MAD")
						.CustomerId(customer.getId())
						.CreateAt(LocalDate.now())
						.Balance(Math.random()*10000)
						.build();
				accountRepository.save(account); accountRepository.save(account2);
			});
		};
	}
}
