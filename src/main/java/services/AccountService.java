package services;

import exсeption.NoEnoughMoneyException;

public interface AccountService {
    String viewBalance();//просмотр баланса

    String moneyTransfer(int ammount, String account) throws NoEnoughMoneyException;//денежный перевод

    String addAcount(int ammount);//пополнение счета

    void cashWithDrawal(int ammount) throws NoEnoughMoneyException;//снятие наличных
}
