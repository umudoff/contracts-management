package com.digital.lab.contractsmanagement.repository;

import com.digital.lab.contractsmanagement.model.Company;
import com.digital.lab.contractsmanagement.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository  extends JpaRepository<Contract,Long> {

    @Query( value =  "WITH parent(PROVIDER_COMPANY) AS ( " +
            " SELECT PROVIDER_COMPANY FROM CONTRACT " +
            " WHERE RECIPIENT_COMPANY= :recipient OR PROVIDER_COMPANY= :provider), " +
            " tree(PROVIDER_COMPANY,RECIPIENT_COMPANY) AS ( " +
            " SELECT x.PROVIDER_COMPANY, x.RECIPIENT_COMPANY "+
            " FROM CONTRACT x INNER JOIN parent ON x.RECIPIENT_COMPANY= parent.PROVIDER_COMPANY "+
            " UNION ALL "+
            " SELECT y.PROVIDER_COMPANY, y.RECIPIENT_COMPANY "+
            " FROM CONTRACT y INNER JOIN tree t ON t.PROVIDER_COMPANY= y.RECIPIENT_COMPANY ) "+
            " SELECT PROVIDER_COMPANY, RECIPIENT_COMPANY FROM tree "+
            " UNION "+
            " SELECT PROVIDER_COMPANY, RECIPIENT_COMPANY FROM CONTRACT  "+
            " WHERE RECIPIENT_COMPANY= :recipient OR PROVIDER_COMPANY= :provider ",
            nativeQuery = true)
    List<List<Long>> findAllSleeves(@Param("recipient") Long recipient, @Param("provider") Long provider);



}
