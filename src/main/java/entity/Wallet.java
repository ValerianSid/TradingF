package entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wallet {
    private String currency;
    AccountHistory accountHistory = new AccountHistory();
    private Map<String, List<AccountHistory>> historyMap;
}
