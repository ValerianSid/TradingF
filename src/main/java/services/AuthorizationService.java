package services;

import exсeption.NoEnoughMoneyException;
import exсeption.WrongLoginException;
import manager.ForexApp;

import java.io.IOException;


public interface AuthorizationService {
    void logIn(String login, String Password) throws WrongLoginException;

    void logOut(ForexApp menu) throws NoEnoughMoneyException, IOException;
}
