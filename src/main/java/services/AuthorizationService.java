package services;

import exсeption.FileSaveException;
import exсeption.NoEnoughMoneyException;
import exсeption.WrongLoginException;
import manager.ForexApp;

import java.io.IOException;


public interface AuthorizationService {
    void logReg(String login, String Password, String repPassword) throws WrongLoginException, IOException, FileSaveException;

    void logIn(String login, String password);

    void logOut(ForexApp menu) throws NoEnoughMoneyException, IOException;
}
