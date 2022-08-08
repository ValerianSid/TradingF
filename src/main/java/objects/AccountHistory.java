package objects;

import java.time.LocalDateTime;

public class AccountHistory {
    private float balance;
    private LocalDateTime time;
    private String operationType;
    private float sumChanging;

    public AccountHistory(float balance, LocalDateTime time, String operationType, float sumChanging) {
        this.balance = balance;
        this.time = time;
        this.operationType = operationType;
        this.sumChanging = sumChanging;
    }
}
