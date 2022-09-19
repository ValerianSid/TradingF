package services;

import entity.Wallet;

public interface FinanceService {

    void createNewAccount();
    float viewBalance(String currency, Wallet wallet);
    void exchange();
    void addMoney(float sum, String currency, Wallet wallet);
    void withdrawMoney(float sum, String currency, Wallet wallet);
}
