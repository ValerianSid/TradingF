package services;

import entity.Wallet;
import exсeption.NoEnoughMoneyException;

import java.io.IOException;

public class WalletServiceImpl implements WalletService {
    private Wallet wallet ;
    private final IOService ioService;

    public WalletServiceImpl() {
        this.wallet = wallet;
        this.ioService = new IOServiceImpl();
    }

    @Override
    public String viewBalance() throws IOException {

        if (wallet.getAmount() == 0) {

            ioService.write("На счету "+wallet.getAmount()+ " Желаете пополнить? y/n");
            if(ioService.read().equalsIgnoreCase("y")){
                ioService.write("Сумма :");
            }
            wallet.setAmount(ioService.readFloat());
            viewBalance();

        }
        return ("У Вас на счету " + (wallet.getAmount()));
    }

    @Override
    public String moneyTransfer(int amount, String wallet) throws NoEnoughMoneyException {
        if (this.wallet.getAmount() < amount) {
            throw new NoEnoughMoneyException();
        }
        this.wallet.setAmount(this.wallet.getAmount() - amount);
        return "Сумма " + amount + " успешно переведена пользователю " + wallet;
    }

    @Override
    public String addAccount(int amount) {
        wallet.setAmount(wallet.getAmount() + amount);
        return "Баланс пополнен на сумму: " + amount;
    }

    @Override
    public String exchange(float amount, float curr) {
        return "Итого" + (amount*curr);
    }

    @Override
    public void cashWithDrawal(int amount) throws NoEnoughMoneyException {
        if (wallet.getAmount() < amount) {
            throw new NoEnoughMoneyException();
        }
        wallet.setAmount(wallet.getAmount() - amount);
    }

    @Override
    public void newAccount(String name, String password) {

    }
}
