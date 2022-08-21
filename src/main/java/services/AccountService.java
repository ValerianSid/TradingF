package services;

import exсeption.NoEnoughMoneyException;

public interface AccountService {
    String viewBalance();//просмотр баланса

    String moneyTransfer(int ammount, String account) throws NoEnoughMoneyException;//денежный перевод

    String addAccount(int ammount);//пополнение счета

    void cashWithDrawal(int ammount) throws NoEnoughMoneyException;//снятие наличных
    void newAccount(String name,String password);
}
