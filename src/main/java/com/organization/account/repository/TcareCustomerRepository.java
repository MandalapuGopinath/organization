package com.organization.account.repository;

import com.organization.account.entity.TcareCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TcareCustomerRepository extends MongoRepository<TcareCustomer, Long> {

    @Query("SELECT tcc FROM TcareCustomer tcc JOIN TcarePartyOrganization tpo ON tcc.partyNbr = tpo.partyNbr WHERE tcc.createdDate BETWEEN :fromDate AND :toDate AND tcc.casStatusId LIKE '2'")
    Long countActivatedCompanies(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
}
