package entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wallet {
    String login;
    String password;
    private String currency;
    private float accountState;
    private Map<String, Float> accountStateMap; // <название валюты, состояние счета>
    private List<AccountHistory> accountHistoryList;

    public Wallet(String login, String password) {
        this.currency = currency;
        this.accountState = accountState;
        this.accountStateMap = new HashMap<>();
        accountStateMap.put(currency, accountState);
        this.login=login;
        this.password=password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<AccountHistory> getAccountHistoryList() {
        return accountHistoryList;
    }

    public void setAccountHistoryList(List<AccountHistory> accountHistoryList) {
        this.accountHistoryList = accountHistoryList;
    }

    public Map<String, Float> getAccountStateMap() {
        return accountStateMap;
    }
}
