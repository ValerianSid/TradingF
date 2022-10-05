package entity;

import java.util.*;

public class Wallet {
    private UUID id;
    private Currency currency;
    private Float amount;
    private User user;
    //private Map<String, Float> accountStateMap; // <название валюты, состояние счета>
    //private List<AccountHistory> accountHistoryList;

    public Wallet(UUID id, Currency currency, Float amount, User user) {
        this.id = id;
        this.currency = currency;
        this.amount = amount;
        this.user = user;
    }
    public Wallet(){};


    public UUID getId() {
        return id;
    }

    public Currency getCurreny() {
        return currency;
    }


    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public Float addAmount(Float amount) {
        this.amount += amount;
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Wallet) {
            return this.id.equals(((Wallet) o).getId());
        }
        return super.equals(o);
    }

}