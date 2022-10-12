package entity;

import java.util.*;

public class User {
    private UUID id;
    private String name;
    private String passwordHash;
    private List<Wallet> wallet;

    public User(UUID id, String name, String passwordHash) {
        this.id = id;
        this.name = name;
        this.wallet = new ArrayList<>();
        this.passwordHash = passwordHash;
    }
    public User(){}

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    // Геттер для кошелька с проверкой на NUll, если кошелька нет создается новый
    public List<Wallet> getWallet() {
        if (this.wallet == null) {
            this.wallet = new ArrayList<>();
        }
        return wallet;
    }

    // добавление кошелька
    public void addWallet(Wallet wallet) {
        if (this.wallet == null) {
            new ArrayList<>();
        }
        Optional.ofNullable(wallet)
                .ifPresent(wal -> this.wallet.add(wal));
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof User) {
            return this.id.equals(((User) o).getId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, passwordHash, wallet);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", wallet=" + wallet +
                '}';
    }


}
