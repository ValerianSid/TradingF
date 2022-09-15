package services;

public interface FinanceService {

    void createNewAccount();
    float viewBalance();
    void exchange();
    void addMoney(float sum);
    void withdrawMoney(float sum);
}
