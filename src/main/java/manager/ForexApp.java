package manager;

import data.DataSource;
import exсeption.FileSaveException;
import exсeption.NoEnoughMoneyException;
import model.CurrencyPair;
import model.Symbol;
import model.history.History;
import model.history.Period;
import services.*;

import javax.swing.*;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class ForexApp {
    private AuthorizationServiceImpl authorizationService;
    private final DataSource dataSource;
    private final IOService ioService;
    private final WalletService walletService;

    public ForexApp() {
        this.dataSource = new DataSource();
        this.ioService = new IOService();
        this.walletService = new WalletServiceImpl();
        this.authorizationService = new AuthorizationServiceImpl();
    }


    public void run() throws NoEnoughMoneyException, IOException {
        startMenu();
        startChoose();
    }

    private void startMenu() {
        ioService.write("Наберите 1 чтобы войти в аккаунт");
        ioService.write("Наберите 2 чтобы создать аккаунт");
        ioService.write("Наберите 3 для просмотра инфо-меню");
        ioService.write("Введите 'exit' для выхода");
    }

    private void infoMenu() {
        ioService.write("Выберите операцию:");
        ioService.write("Наберите 1 чтобы получить текущий курс пары валют по числовому id");
        ioService.write("Наберите 2 чтобы получить текущий курс пары валют по символьному выражению пары");
        ioService.write("Наберите 3 чтобы получить список символьных выражений, содержащих в т.ч. числовые id, всех пар валют");
        ioService.write("Наберите 4 чтобы войти в аккаунт");
        ioService.write("Наберите 5 чтобы создать аккаунт");
        ioService.write("Введите 'exit' для выхода");
    }

    private void operationMenu() {
        ioService.write("Выберите операцию:");
        ioService.write("Наберите 1 для просмотра баланса");
        ioService.write("Наберите 2 для обмена");
        ioService.write("Наберите 3 для перевода");
        ioService.write("Наберите 4 для снятия наличных");
        ioService.write("Наберите 5 для создания нового аккаунта(счета)");
        ioService.write("Введите 'exit' для выхода");
    }

    private void startChoose() throws NoEnoughMoneyException, IOException {
        int oper = readOperation();
        switch (oper) {
            case 1:
                logIn();
                ifExit();
                break;
            case 2:
                logReg();
                ifExit();
                break;
            case 3:
                infoMenu();
                infoChoose();
                ifExit();
                break;
            default:
                startMenu();
        }
    }

    private void infoChoose() throws IOException, NoEnoughMoneyException {
        int operation = readOperation();
        switch (operation) {
            case 1:
                getPairById();
                operationMenu();
                ifExit();
                break;
            case 2:
                getPairBySymbol();
                ifExit();
                break;
            case 3:
                getSymbolsList();
                ifExit();
                break;
            case 4:
                logIn();
                ifExit();
                break;
            case 5:
                logReg();
                startMenu();
                infoChoose();
                ifExit();
                break;
            default:
                infoChoose();
        }
    }

    private void operationChoose() throws IOException, NoEnoughMoneyException {
        Operations operation = Operations.valueOf(ioService.read());
        switch (operation) {
            case EXIT:
                break;
            case WIEWBALANCE:
                ioService.write(walletService.viewBalance());
                break;
            case EXCHANGE:

                ioService.write(walletService.exchange(200, 2.5f));
                break;
            case MANYTRANSFER:

                break;
            case CASHWITHDRAWAL:

                break;
            case ADDACCOUNT:

                break;
            default:
                operationChoose();
        }
    }

    private void logIn() throws RuntimeException, IOException, NoEnoughMoneyException {

        ioService.write("Введите логин");
        String log = ioService.read();
        ioService.write("Введите пароль");
        String pass = ioService.read();

        authorizationService.logIn(log, pass);
        operationMenu();
        operationChoose();


    }


    private void logReg() {
        try {
            ioService.write("Введите логин");
            String log = ioService.read();
            ioService.write("Введите пароль");
            String pas = ioService.read();
            ioService.write("Повторите пароль");
            String pasT = ioService.read();

            authorizationService.logReg(log, pas, pasT);
            authorizationService.logIn(log, pas);

        } catch (IOException | FileSaveException e) {
            e.printStackTrace();
        }
    }

    private void getPairById() {
        JFrame frame = new JFrame("Get Pair ID");
        JTextField field = new JTextField();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.add(field);
        // считать id с консоли
        // вызвать dataSource.getPairById
        // распечатать результат
        String strInp = JOptionPane.showInputDialog(frame, "Введите id пары валют, н-р 1815", null);

        List<CurrencyPair> currencyPairs = dataSource.getPairById(Integer.valueOf(strInp));
        //JOptionPane.showMessageDialog(frame,currencyPairs);
        field.setText(String.valueOf(currencyPairs));
    }

    private void getPairBySymbol() throws IOException {
        ioService.write("Введите символьное выражение пары валют, н-р USD/EUR");
        String input = ioService.read();
        Symbol symbol = new Symbol();
        symbol.setSymbol(input);
        List<CurrencyPair> currencyPairs = dataSource.getPairBySymbol(symbol);
        ioService.write(currencyPairs.toString());
    }

    private void getSymbolsList() {
        List<Symbol> symbols = dataSource.getSymbolsList();
        ioService.write(symbols.toString());
    }

    private void getHistory() throws IOException {
        ioService.write("Введите символьное выражение пары валют, н-р USD/EUR");
        String input = ioService.read();
        Symbol symbol = new Symbol();
        symbol.setSymbol(input);

        ioService.write("Введите длину периода, н-р 1, 2, или 10");
        int length = Integer.parseInt(ioService.read());

        ioService.write("Введите единицу измерения периода: минута - m, час - h, день - d, неделя - w, месяц - month");
        String periodString = ioService.read();
        Period period = Period.fromString(periodString);

        Collection<History> histories = dataSource.getHistory(symbol, length, period);
        ioService.write(histories.toString());
    }


    private void ifExit() {
        ioService.write("Желаете ли продолжить? y/n");
        try {
            if (ioService.read().equalsIgnoreCase("y")) {
                startMenu();
                infoChoose();
            } else {
                System.exit(0);
            }
        } catch (IOException e) {
            ioService.write("Не известная ошибка");
            ifExit();
        } catch (NoEnoughMoneyException e) {
            e.printStackTrace();
        }
    }


    private int readOperation() {
        String operation;
        try {
            if (!(operation = ioService.read()).equals("exit")) {
                return Integer.parseInt(operation);
            }
        } catch (IOException e) {
            ioService.write("Не известная ошибка");
            readOperation();
        }
        return 0;
    }

}
