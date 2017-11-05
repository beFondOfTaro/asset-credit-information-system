package com.iot.assetcreditinformationsystem.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * 银行支行
 */
@Entity
public class BankBranch extends BaseEntity{

    @NotNull
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "bank_id",referencedColumnName = "id",insertable = false,updatable = false)
    private Bank bank;//所属银行

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
