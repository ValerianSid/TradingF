package services;

import exсeption.NoEnoughMoneyException;
import objects.AccountHistory;

public class AccountServiceImpl implements AccountService {
    private final AccountHistory accountHistory;
    private final IOService ioService;

    public AccountServiceImpl() {
        this.accountHistory = new AccountHistory();
        this.ioService = new IOServiceImpl();
    }

    @Override
    public String viewBalance() {
        if (accountHistory.getBalance() == 0) {
            ioService.write("На счету 0! Желаете пополнить?");
            accountHistory.setBalance(ioService.readFloat());
            ioService.write("your balance"+accountHistory.getBalance());
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
    public float exchange(float amount, float curr) {
        return amount*curr;
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
