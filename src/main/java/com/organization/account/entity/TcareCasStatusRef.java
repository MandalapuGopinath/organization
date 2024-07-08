package com.organization.account.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tcare_cas_status_ref")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TcareCasStatusRef implements Serializable {

    @Id
    @Column(name = "CAS_STATUS_ID", unique = true, nullable = false)
    private Short casStatusId;

    @Column(name = "CAS_STATUS_DESC", nullable = false,length = 40)
    private String casStatusDesc;

    @Column(name = "CREATED_ON",length = 7)
    @Temporal(TemporalType.DATE)
    private Date createdOn;

    @Column(name = "CREATE_BY",length = 40)
    private String createdBy;

    @Column(name = "UPDATE_ON", length = 7)
    @Temporal(TemporalType.DATE)
    private Date updatedOn;

    @Column(name = "UPDATED_BY",length = 40)
    private String updatedBy;

    @Column(name = "BU_ID",length = 40)
    private String buId;

    @Column(name = "OPERATOR_ID",length = 40)
    private String operatorId;

    @Column(name = "CUSTOM_CREATED_ON",length = 40)
    private String customCreatedOn;

    @Column(name = "CUSTOM_UPDATED_ON",length = 40)
    private String customUpdatedOn;

    @Column(name = "CAS_ENTITY",length = 40)
    private String casEntity;

    @Column(name = "DATA_SET_ID",length = 40)
    private String dataSetId;
}
