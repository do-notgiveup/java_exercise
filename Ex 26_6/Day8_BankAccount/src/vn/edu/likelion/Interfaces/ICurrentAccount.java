package vn.edu.likelion.Interfaces;

import vn.edu.likelion.Entities.CurrentAccount;

public interface ICurrentAccount {
    void addAccount(CurrentAccount account);
    void updateAccount(CurrentAccount account);
    void removeAccount(CurrentAccount account);
    CurrentAccount getAccount(int id);
    void getAllAccount();
}
