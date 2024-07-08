package com.organization.account.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Table(name = "tcare_account", uniqueConstraints = @UniqueConstraint(columnNames = "account_id"), schema = "tibtcare")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TcareAccount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountNumber;
    private TcareCollectionTyperef tcareCollectionTyperef;
    private String accountId;
    private String taxCode;
    private Long accountPin;
    private String paperHold;
    private String internalFlag;
    private Date accActiveDt;
    private String accSegmentId;
    private String vipCode;
    private String parentAcctId;
    private String rootAcctId;
    private Long defCreditLimit;
    private String disConnectionReason;
    private Date postToErpDate;
    private Date migratedDate;
    private String buId;
    private String opId;
    private String customAcctActiveDt;
    private String customAcctCloseDate;
    private String customPostToErpDate;
    private String customMigratedDate;
    private String externalAccountId1;
    private String externalAccountId2;
    private String acctArStatusId;
    private String acctArSubStatusId;
    private Date createdDate;
    private String createdBy;
    private Date updatedDate;
    private String updatedBy;
    private String customCreatedDate;
    private String customUpdatedDate;
    private String dcaid;
    private String acctTypeId;
    private String costCentreId;
    private String budgetCentreId;
    private String billableIndicator;
    private String secondaryCurrency;
    private String salesCode;
    private String timeZone;
    private String payableIndicator;
    private String accountName;

}
