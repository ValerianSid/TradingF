package services;

import exсeption.NoEnoughMoneyException;

public class AccountServiceImpl implements AccountService{

    @Override
    public String viewBalance() {
        return ("У Вас на счету "+(String.valueof(User.getBalance()));
    }

    @Override
    public String moneyTransfer(int ammount, String account) throws NoEnoughMoneyException {
        if(User.getBalance<ammount) {
            throw new NoEnoughMoneyException();
        }
        User.setBalance(getBalance()-ammount);
        return "Сумма "+ammount+" успешно переведена пользователю "+ account;
    }

    @Override
    public String addAccount(int ammount) {
        User.setBalance(getBalance()+ammount);
        return "Баланс пополнен на сумму: "+ ammount;
    }

    @Override
    public void cashWithDrawal(int ammount) throws NoEnoughMoneyException {

    }
}
