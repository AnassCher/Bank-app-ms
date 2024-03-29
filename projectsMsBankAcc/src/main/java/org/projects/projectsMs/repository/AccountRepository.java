package org.projects.projectsMs.repository;

import org.projects.projectsMs.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, String> {
}
