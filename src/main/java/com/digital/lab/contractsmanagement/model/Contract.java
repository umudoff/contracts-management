package com.digital.lab.contractsmanagement.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PROVIDER_COMPANY")//, referencedColumnName = "name"
    private Company provider;

    @ManyToOne
    @JoinColumn(name="RECIPIENT_COMPANY") //,referencedColumnName = "name"
    private Company recipient;
}

