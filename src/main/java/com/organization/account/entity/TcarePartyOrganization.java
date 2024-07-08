package com.organization.account.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
@Table(name = "tcare_party_organization", schema = "tibtcare")
public class TcarePartyOrganization implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "organization_seq_nbr")
    private Long organizationSeqNbr;
    private Integer partyNbr;
    private String organizationName;
    private String tin;
    private String customerShortCode;
    private String corpCode;
    private String corpType;
    private String opId;
    private String buId;
    private Date createdDate;
    private String createdBy;
    private Date updatedDate;
    private String updatedBy;
    private String organizationId;
    private String emailId;
    private String contactNo;
    private String identifierType;


}
