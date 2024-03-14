package org.projects.projectsMs.repository;

import org.projects.projectsMs.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
