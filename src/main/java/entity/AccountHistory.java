package entity;

import enums.OperationType;
import javafx.util.Builder;

import java.time.LocalDateTime;

public class AccountHistory {
    private float balance;
    private float balanceChanging;
    private OperationType operationType;
    private LocalDateTime localDateTime;
    private String currency;

    public AccountHistory(float balance, float balanceChanging, OperationType operationType,
                          LocalDateTime localDateTime, String currency) {
        this.balance = balance;
        this.balanceChanging = balanceChanging;
        this.operationType = operationType;
        this.localDateTime = localDateTime;
        this.currency = currency;
    }

    public float getBalance() {
        return balance;
    }

    public float getBalanceChanging() {
        return balanceChanging;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public String getCurrency() {
        return currency;
    }

    public static class Builder{

        private float balance;
        private float balanceChanging;
        private OperationType operationType;
        private LocalDateTime localDateTime;
        private String currency;

        public Builder balance(float balance){
            this.balance = balance;
            return this;
        }

        public Builder balanceChanging(float balanceChanging){
            this.balanceChanging = balanceChanging;
            return this;
        }

        public Builder operationType(OperationType operationType){
            this.operationType = operationType;
            return this;
        }

        public Builder localDateTime(LocalDateTime localDateTime){
            this.localDateTime = localDateTime;
            return this;
        }

        public  Builder currency(String currency){
            this.currency = currency;
            return this;
        }
    }
}
