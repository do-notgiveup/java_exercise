package vn.edu.likelion.Entities;

import vn.edu.likelion.Abstracts.Account;

import java.math.BigDecimal;

public class CurrentAccount extends Account {
    private BigDecimal overDraftLimit;

    public CurrentAccount(int id, BigDecimal initialDeposit, BigDecimal overDraftLimit) {
        super(id, initialDeposit);
        this.overDraftLimit = overDraftLimit;
    }

    public BigDecimal getOverDraftLimit() {
        return overDraftLimit;
    }

    public void setOverDraftLimit(BigDecimal overDraftLimit) {
        this.overDraftLimit = overDraftLimit;
    }

    @Override
    public void interest(double year) {

    }

    @Override
    public String toString() {
        return "CurrentAccount{" +
                "id=" + getId() +
                "moneyBalance=" + getInitialDeposit() +
                "overDraftLimit=" + overDraftLimit +
                '}';
    }
}
