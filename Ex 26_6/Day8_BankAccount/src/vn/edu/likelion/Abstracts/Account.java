package vn.edu.likelion.Abstracts;

import java.math.BigDecimal;

public abstract class Account {
    int id;
    private BigDecimal initialDeposit;

    public Account(int id, BigDecimal initialDeposit) {
        this.id = id;
        this.initialDeposit = initialDeposit;
    }

    public BigDecimal getInitialDeposit() {
        return initialDeposit;
    }

    public void setInitialDeposit(BigDecimal initialDeposit) {
        this.initialDeposit = initialDeposit;
    }

    public void saveMoney(BigDecimal money){
        setInitialDeposit(getInitialDeposit().add(money));
    };
    public void withdrawMoney(BigDecimal money){
        setInitialDeposit(getInitialDeposit().subtract(money));
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract void interest(double year);

    public void viewMoneyBalance(){
        System.out.println("Account balance: " + getInitialDeposit());
    };
}
