package vn.edu.likelion.Applications;

import vn.edu.likelion.Entities.CurrentAccount;
import vn.edu.likelion.Interfaces.ICurrentAccount;

import java.util.ArrayList;

public class CurrentAccountApplication implements ICurrentAccount{
    ArrayList<CurrentAccount> listAccount = new ArrayList<>();

    @Override
    public void getAllAccount(){
        for (CurrentAccount currentAccount : listAccount) {
            System.out.println(currentAccount);
        }
    }

    @Override
    public void addAccount(CurrentAccount account) {
        listAccount.add(account);
    }

    @Override
    public void updateAccount(CurrentAccount account) {
        CurrentAccount CurrentAccount = getAccount(account.getId());
        if (CurrentAccount != null)
            CurrentAccount.setOverDraftLimit(account.getOverDraftLimit());
        else System.out.println("Savings account not found!");
    }

    @Override
    public void removeAccount(CurrentAccount account) {
        CurrentAccount CurrentAccount = getAccount(account.getId());
        if (CurrentAccount != null)
            listAccount.remove(CurrentAccount);
        else System.out.println("not found");
    }

    @Override
    public CurrentAccount getAccount(int id) {
        for (CurrentAccount account : listAccount) {
            if (account.getId() == id) {
                return account;
            }
        }
        return null;
    }
}
