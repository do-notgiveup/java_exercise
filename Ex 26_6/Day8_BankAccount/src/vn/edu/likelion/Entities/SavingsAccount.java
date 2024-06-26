package vn.edu.likelion.Entities;

import vn.edu.likelion.Abstracts.Account;

import java.math.BigDecimal;

public class SavingsAccount extends Account {
    private String interestRate;

    public SavingsAccount(int id, BigDecimal initialDeposit, String interestRate) {
        super(id, initialDeposit);
        this.interestRate = interestRate;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public void interest(double year) {
        System.out.println("Account balance: 961.875 test");
        System.out.println("Account balance: " + getInitialDeposit().add(getInitialDeposit().multiply(new BigDecimal(interestRate))));
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "id=" + getId() +
                "moneyBalance=" + getInitialDeposit() +
                "interestRate='" + interestRate + '\'' +
                '}';
    }
}
