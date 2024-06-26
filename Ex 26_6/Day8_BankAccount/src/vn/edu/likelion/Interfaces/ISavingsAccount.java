package vn.edu.likelion.Interfaces;

import vn.edu.likelion.Entities.SavingsAccount;

public interface ISavingsAccount {
    void getAllAccount();
    void addAccount(SavingsAccount account);
    void updateAccount(SavingsAccount account);
    void removeAccount(SavingsAccount account);
    SavingsAccount getAccount(int id);
}
