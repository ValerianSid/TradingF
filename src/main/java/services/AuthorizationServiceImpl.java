package services;

import at.favre.lib.crypto.bcrypt.BCrypt;
import data.DataSource;
import entity.User;
import exсeption.FileSaveException;
import exсeption.NoEnoughMoneyException;
import exсeption.WrongLoginException;
import manager.ForexApp;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

public class AuthorizationServiceImpl implements AuthorizationService{
    private IOService ioService;
    private DataSource data;
    private Session session;

    public AuthorizationServiceImpl() {
        this.ioService = new IOService();
        this.data = new DataSource();
        this.session = new Session();
    }

@Override
    public void logIn(String login, String password, String repPassword) throws WrongLoginException, IOException, FileSaveException {
        String log = Optional.ofNullable(login)
                .orElseThrow(() -> new WrongLoginException("Не заполнен логин"));
        String pasw = Optional.ofNullable(password)
                .orElseThrow(() -> new WrongLoginException("Не заполнен пароль"));
        String repPasw = Optional.ofNullable(repPassword)
                .orElseThrow(() -> new WrongLoginException("Повторите пароль"));
        if (!pasw.equals(repPasw)) throw new WrongLoginException("Пароли не совпадают");
        if (UserReader.chkUserExist(log)) throw new WrongLoginException("Пользователь " + login + " уже существует");
        String byScriptHash = BCrypt
                .withDefaults()
                .hashToString(12,pasw.toCharArray());
        UUID uuid=UUID.randomUUID();
        User user=new User(uuid,log,byScriptHash);
        ioService.write(String.valueOf(user));
        ioService.save(user);

    }

@Override
    public void logOut(ForexApp menu) throws NoEnoughMoneyException, IOException {
        menu.run();

    }
}
