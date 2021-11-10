package com.digital.lab.contractsmanagement.repository;

import com.digital.lab.contractsmanagement.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository  extends JpaRepository<Company,Long> {
    @Override
    List<Company> findAll();

    Optional<Company> findById(Long id);


    @Query("SELECT a FROM Company a WHERE a.name=:name")
    Company findByName(@Param("name")String name);
}
