package services;

import exсeption.FileSaveException;
import exсeption.NoEnoughMoneyException;
import exсeption.WrongLoginException;
import manager.ForexApp;

import java.io.IOException;


public interface AuthorizationService {
    void logIn(String login, String Password, String repPassword) throws WrongLoginException, IOException, FileSaveException;

    void logOut(ForexApp menu) throws NoEnoughMoneyException, IOException;
}
