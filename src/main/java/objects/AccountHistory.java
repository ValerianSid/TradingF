package objects;

import java.time.LocalDateTime;

public class AccountHistory {
    private float balance;
    private LocalDateTime time;
    private String operationType;
    private float sumChanging;

    public AccountHistory(long balance, LocalDateTime time, String operationType, long sumChanging) {
        this.balance = balance;
        this.time = time;
        this.operationType = operationType;
        this.sumChanging = sumChanging;
    }
}
