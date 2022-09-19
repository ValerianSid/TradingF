package services;

import exсeption.NoEnoughMoneyException;

public interface AccountService {
    String viewBalance() throws NoEnoughMoneyException;//просмотр баланса

    String moneyTransfer(int amount, String account) throws NoEnoughMoneyException;//денежный перевод

    String addAccount(int amount);//пополнение счета
    float exchange(float amount, float curr);// обмен

    void cashWithDrawal(int amount) throws NoEnoughMoneyException;//снятие наличных
    void newAccount(String name,String password);
}
