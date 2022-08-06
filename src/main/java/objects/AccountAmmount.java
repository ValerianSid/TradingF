package objects;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class AccountAmmount {
    private float ammount;
    private AccountHistory accountHistory;
    private Map<Float, AccountHistory> accountAmmount;
    private List<AccountHistory> list

    public AccountAmmount() {
        this.accountAmmount.put(this.ammount, this.accountHistory);
    }

}
