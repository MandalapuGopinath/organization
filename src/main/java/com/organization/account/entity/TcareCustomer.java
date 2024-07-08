package com.organization.account.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Table(name = "tcare_customer", schema = "tibtcare")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class
TcareCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerSeqId;
    private TcareCasStatusRef tcareCasStatusRef;
    private String customerId;
    private String customerType;
    private String customerSubType;
    private String opId;
    private String buId;
    private Date createdDate;
    private String createdBy;
    private Date updatedDate;
    private String updatedBy;
    private String dealerCode;
    private String customCreatedOn;
    private String customUpdatedOn;
    private String externalAccountId1;
    private String externalAccountId2;
    private String careLevel;
    private String loyalityAccountId;
    private String custSegmentId;
    private String custMktId;
    private Integer partyNbr;
    private String reasonCode;
    private String resellerId;
    private String partnerId;


}
