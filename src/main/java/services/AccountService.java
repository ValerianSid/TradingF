package services;

import exсeption.NoEnoughMoneyException;

import java.io.IOException;

public interface AccountService {
    String viewBalance() throws NoEnoughMoneyException, IOException;//просмотр баланса

    String moneyTransfer(int amount, String account) throws NoEnoughMoneyException;//денежный перевод

    String addAccount(int amount);//пополнение счета
    String exchange(float amount, float curr);// обмен

    void cashWithDrawal(int amount) throws NoEnoughMoneyException;//снятие наличных
    void newAccount(String name,String password);
}
