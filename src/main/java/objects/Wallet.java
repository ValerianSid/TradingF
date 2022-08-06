package objects;

import java.util.Map;

public class Wallet {
    private String currency;
    private long accountAmmount;
    private AccountHistory accountHistory;
    private Map<String, AccountHistory> walletHistory;
    private Map<String, Long> walletAmmount;


}
