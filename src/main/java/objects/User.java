package objects;

import java.util.List;
import java.util.Map;

public class User {
    private String clientName;
    private Map<String, Wallet> wallets;

    public User(String clientName) {
        this.clientName = clientName;
    }
}
