package services;

import entity.Wallet;
import exсeption.NoEnoughMoneyException;
import exсeption.WrongLoginException;
import manager.ForexApp;

import java.io.IOException;

public class AuthorizationServiceImpl implements AuthorizationService{
    private Wallet walletList;
    @Override
    public void logIn(String login, String Password) throws WrongLoginException {

    }

    @Override
    public void logOut(ForexApp menu) throws NoEnoughMoneyException, IOException {
        menu.run();

    }
}
