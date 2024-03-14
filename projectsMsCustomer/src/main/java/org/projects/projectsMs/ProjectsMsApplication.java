package org.projects.projectsMs;

import org.projects.projectsMs.entities.Customer;
import org.projects.projectsMs.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ProjectsMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectsMsApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerService customerService){
		return args -> {
			Customer customer1 = Customer.builder()
					.FirstName("Anass")
					.LastName("Cherqaoui")
					.Email("Anass@gmail.com")
					.build();
			Customer customer2 = Customer.builder()
					.FirstName("Ayman")
					.LastName("Cherqi")
					.Email("Ayman@gmail.com")
					.build();

			customerService.CreateCustomer(customer1);
			customerService.CreateCustomer(customer2);
		};
	}
}
