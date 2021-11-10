package com.digital.lab.contractsmanagement.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@ApiModel("Company Model")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value="Company Name", required = true)
    @Column(name="NAME")
    @NotNull(message = "Company name mustn't be empty")
    private String name;

}
