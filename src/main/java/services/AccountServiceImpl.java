package services;

import exсeption.NoEnoughMoneyException;
import objects.AccountHistory;

import java.io.IOException;

public class AccountServiceImpl implements AccountService {
    private final AccountHistory accountHistory;
    private final IOService ioService;

    public AccountServiceImpl() {
        this.accountHistory = new AccountHistory();
        this.ioService = new IOServiceImpl();
    }

    @Override
    public String viewBalance() throws IOException {
        if (accountHistory.getBalance() == 0) {
            ioService.write("На счету "+accountHistory.getBalance()+ " Желаете пополнить? y/n");
            if(ioService.read().equalsIgnoreCase("y")){
                ioService.write("Сумма :");
            }
            accountHistory.setBalance(ioService.readFloat());
            viewBalance();

        }
        return ("У Вас на счету " + (accountHistory.getBalance()));
    }

    @Override
    public String moneyTransfer(int amount, String account) throws NoEnoughMoneyException {
        if (accountHistory.getBalance() < amount) {
            throw new NoEnoughMoneyException();
        }
        accountHistory.setBalance(accountHistory.getBalance() - amount);
        return "Сумма " + amount + " успешно переведена пользователю " + account;
    }

    @Override
    public String addAccount(int amount) {
        accountHistory.setBalance(accountHistory.getBalance() + amount);
        return "Баланс пополнен на сумму: " + amount;
    }

    @Override
    public String exchange(float amount, float curr) {
        return "Итого" + (amount*curr);
    }

    @Override
    public void cashWithDrawal(int amount) throws NoEnoughMoneyException {
        if (accountHistory.getBalance() < amount) {
            throw new NoEnoughMoneyException();
        }
        accountHistory.setBalance(accountHistory.getBalance() - amount);
    }

    @Override
    public void newAccount(String name, String password) {

    }
}
