package com.organization.account.repository;

import com.organization.account.entity.TcareAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TcareAccountRepository extends MongoRepository<TcareAccount, Long> {

    @Query("SELECT COUNT(a) FROM TcareAccount a WHERE a.budgetCentreId IN :budgetCenters " +
            "AND a.createdDate BETWEEN :fromDate AND :toDate")
    Long countRegisteredUsers(@Param("budgetCenters") List<Long> budgetCenters,
                              @Param("fromDate") Date fromDate,
                              @Param("toDate") Date toDate);
}
