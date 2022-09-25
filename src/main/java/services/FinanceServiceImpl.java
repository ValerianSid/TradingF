package services;

import data.DataSource;
import entity.Wallet;
import model.Symbol;

import java.util.List;

public class FinanceServiceImpl implements FinanceService{
    private IOService ioService;
    private DataSource dataSource;
    private List<Symbol> currencySymbolList;
    @Override
    public void createNewAccount() {

    }

    @Override
    public float viewBalance(String currency, Wallet wallet) {
        if (wallet.getAccountStateMap().containsKey(currency)){
            return wallet.getAccountStateMap().get(currency);
        }
        else ioService.write("Счет с данной валютой не существует");
        return 0;
    }

    @Override
    public void exchange() {

    }

    @Override
    public void addMoney(float sum, String currency, Wallet wallet) {
        if (wallet.getAccountStateMap().containsKey(currency)){
            wallet.getAccountStateMap().put(currency, wallet.getAccountStateMap().get(currency) + sum);
        }
        else ioService.write("Счет с данной валютой не существует. Вернитесь в главное меню и создайте его");

    }

    @Override
    public void withdrawMoney(float sum, String currency, Wallet wallet) {
        if (wallet.getAccountStateMap().containsKey(currency)){
            if (wallet.getAccountStateMap().get(currency) - sum >= 0){
                wallet.getAccountStateMap().put(currency, wallet.getAccountStateMap().get(currency) - sum);
                ioService.write("С вашего счета списано " + sum + ". Остаток на счете "
                        + wallet.getAccountStateMap().get(currency));
            }
            else ioService.write("Недостаточно средств на счет. Проверьте ваш баланс");
        }
        else ioService.write("Счет с данной валютой не существует.");

    }
}

