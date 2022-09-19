package entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wallet {
    private String currency;
    private float accountState;
    private Map<String, Float> accountStateMap; // <название валюты, состояние счета>
    private List<AccountHistory> accountHistoryList;

    public Wallet() {
        this.currency = currency;
        this.accountState = accountState;
        this.accountStateMap = new HashMap<>();
        accountStateMap.put(currency, accountState);
    }

    public Map<String, Float> getAccountStateMap() {
        return accountStateMap;
    }
}
