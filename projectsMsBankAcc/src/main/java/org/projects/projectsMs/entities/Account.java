package org.projects.projectsMs.entities;

import jakarta.persistence.*;
import lombok.*;
import org.projects.projectsMs.enumerators.AccountType;
import org.projects.projectsMs.model.Customer;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
    @Id
    private String AccountId;
    private double Balance;
    private LocalDate CreateAt;
    private String Currency;
    @Enumerated(EnumType.STRING)
    private AccountType Type;
    private Long CustomerId;
    @Transient
    private Customer customer;
}
