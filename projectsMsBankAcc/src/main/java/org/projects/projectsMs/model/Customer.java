package org.projects.projectsMs.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private Long Id;
    private String FirstName;
    private String LastName;
    private String Email;
}
