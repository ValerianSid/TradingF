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
    private UserReader reader;

    public AuthorizationServiceImpl() {
        this.ioService = new IOService();
        this.data = new DataSource();
        this.session = new Session();

    }

@Override
    public void logReg(String login, String password, String repPassword) throws WrongLoginException, IOException, FileSaveException {
        String log = Optional.ofNullable(login)
                .orElseThrow(() -> new WrongLoginException("Не заполнен логин"));
        String pasw = Optional.ofNullable(password)
                .orElseThrow(() -> new WrongLoginException("Не заполнен пароль"));
        String repPasw = Optional.ofNullable(repPassword)
                .orElseThrow(() -> new WrongLoginException("Повторите пароль"));
        if (!pasw.equals(repPasw)) throw new WrongLoginException("Пароли не совпадают");
        if (ioService.chkUserExist(log)) throw new WrongLoginException("Пользователь " + login + " уже существует");
        String byScriptHash = BCrypt
                .withDefaults()
                .hashToString(12,pasw.toCharArray());
        UUID uuid=UUID.randomUUID();
        User user=new User(uuid,log,byScriptHash);
        ioService.write(String.valueOf(user));
        ioService.save(user);

    }

    @Override
    public void logIn(String login, String password) {
String pass=Optional.ofNullable(password)
        .orElseThrow(()->new WrongLoginException("Не заполнен пароль"));
User usr=Optional.ofNullable(login)
        .map(log->ioService.getUserFromFile(log) )
        .filter(user -> BCrypt
                .verifyer()
                .verify(pass.toCharArray(),user.getPasswordHash())
                .verified)
        .orElseThrow(()->new WrongLoginException ("Не правильный логин или пароль"));
session.setCurrentUser(usr);
ioService.write("Открыта ссесия для "+String.valueOf(usr));

    }

    @Override
    public void logOut(ForexApp menu) throws NoEnoughMoneyException, IOException {
        menu.run();

    }


}
