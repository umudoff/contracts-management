package com.digital.lab.contractsmanagement.repository;

import com.digital.lab.contractsmanagement.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository  extends JpaRepository<Company,Long> {
}
