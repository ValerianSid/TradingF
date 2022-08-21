package objects;

import java.time.LocalDateTime;

public class AccountHistory {
    private float balance;
    private LocalDateTime time;

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    private String operationType;
    private float sumChanging;

    public AccountHistory() {
        this.balance = balance;
        this.time = time;
        this.operationType = operationType;
        this.sumChanging = sumChanging;
    }

}
