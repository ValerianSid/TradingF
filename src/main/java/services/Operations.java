package services;

import objects.AccountHistory;

public enum Operations {
    EXIT,
    WIEWBALANCE{
        public String viewBalance() {
            AccountHistory accountHistory = new AccountHistory();
            return ("У Вас на счету " + (accountHistory.getBalance()));
        }
    },
    MANYTRANSFER,
    ADDACCOUNT,
    CASHWITHDRAWAL,
    EXCHANGE
}
