package services;

import exсeption.NoEnoughMoneyException;
import objects.AccountHistory;

public class AccountServiceImpl implements AccountService{
    private AccountHistory accountHistory;

    public AccountServiceImpl(AccountHistory accountHistory) {
        this.accountHistory = accountHistory;
    }

    @Override
    public String viewBalance() {
        return ("У Вас на счету "+(String.valueOf(accountHistory.getBalance())));
    }

    @Override
    public String moneyTransfer(int ammount, String account) throws NoEnoughMoneyException {
        if(accountHistory.getBalance()<ammount) {
            throw new NoEnoughMoneyException();
        }
        accountHistory.setBalance(accountHistory.getBalance()-ammount);
        return "Сумма "+ammount+" успешно переведена пользователю "+ account;
    }

    @Override
    public String addAccount(int ammount) {
        accountHistory.setBalance(accountHistory.getBalance()+ammount);
        return "Баланс пополнен на сумму: "+ ammount;
    }

    @Override
    public void cashWithDrawal(int ammount) throws NoEnoughMoneyException {
        if(accountHistory.getBalance()<ammount) {
            throw new NoEnoughMoneyException();
        }
        accountHistory.setBalance(accountHistory.getBalance()-ammount);
    }

    @Override
    public void newAccount(String name, String password) {

    }
}
