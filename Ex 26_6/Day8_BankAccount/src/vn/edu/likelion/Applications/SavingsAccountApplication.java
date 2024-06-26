package vn.edu.likelion.Applications;

import vn.edu.likelion.Entities.SavingsAccount;
import vn.edu.likelion.Interfaces.ISavingsAccount;

import java.util.ArrayList;

public class SavingsAccountApplication implements ISavingsAccount {
    ArrayList<SavingsAccount> listAccount = new ArrayList<>();

    @Override
    public void getAllAccount() {
        for (SavingsAccount savingsAccount : listAccount) {
            System.out.println(savingsAccount);
        }
    }

    @Override
    public void addAccount(SavingsAccount account) {
        listAccount.add(account);
    }

    @Override
    public void updateAccount(SavingsAccount account) {
        SavingsAccount savingsAccount = getAccount(account.getId());
        if (savingsAccount != null)
            savingsAccount.setInterestRate(account.getInterestRate());
        else System.out.println("Savings account not found!");
    }

    @Override
    public void removeAccount(SavingsAccount account) {
        SavingsAccount savingsAccount = getAccount(account.getId());
        if (savingsAccount != null)
            listAccount.remove(savingsAccount);
        else System.out.println("not found");
    }

    @Override
    public SavingsAccount getAccount(int id) {
        for (SavingsAccount account : listAccount) {
            if (account.getId() == id) {
                return account;
            }
        }
        return null;
    }
}
