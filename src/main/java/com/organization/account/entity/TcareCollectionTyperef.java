package com.organization.account.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tcare_collection_type_ref")
public class TcareCollectionTyperef implements Serializable {

    @Id
    @NotNull
    private String colTypeId;
    private String colTypeDesc;
    private Date createdDate;
    private String createdBy;
    private Date updatedDate;
    private String updatedBy;
    private String customCreatedDate;
    private String customUpdatedDate;

    private Set<TcareAccount> tcareAccounts = new HashSet<TcareAccount>(0);
}
