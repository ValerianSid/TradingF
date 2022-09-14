import data.DataSource;
import model.CurrencyPair;
import model.Symbol;
import model.history.History;
import model.history.Period;
import services.IOService;
import services.IOServiceImpl;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class ForexApp {

    private final DataSource dataSource;
    private IOService ioService;

    public ForexApp() {
        this.dataSource = new DataSource();
        this.ioService = new IOServiceImpl();
    }

    public static void main(String[] args) throws IOException {
        ForexApp forexApp = new ForexApp();
        forexApp.run();
    }

    public void run() throws IOException {
//        Symbol s = new Symbol();
//        s.setSymbol("EUR/USD");
//        System.out.println(dataSource.getSymbolsList());

        operationChoose();
    }

    private void operationChoose() throws IOException {
        ioService.write("Выберите операцию:");
        ioService.write("Наберите 1 чтобы получить текущий курс пары валют по числовому id");
        ioService.write("Наберите 2 чтобы получить текущий курс пары валют по символьному выражению пары");
        ioService.write("Наберите 3 чтобы получить список символьных выражений, содержащих в т.ч. числовые id, всех пар валют");
        ioService.write("Наберите 4 чтобы получить историю изменений пары валют за последний период времени");
        ioService.write("Введите 'exit' для выхода");
        Integer operation = readOperation();
        switch (operation) {
            case 1:
                getPairById();
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
                getHistory();
                ifExit();
                break;
            default:
                operationChoose();
        }
    }

    private void getPairById() throws IOException {
        // считать id с консоли
        // вызвать dataSource.getPairById
        // распечатать результат
        ioService.write("Введите id пары валют, н-р 1815");
        String id = (String) ioService.read();
        List<CurrencyPair> currencyPairs = dataSource.getPairById(Integer.valueOf(id));
        ioService.write(currencyPairs.toString());
    }

    private void getPairBySymbol() throws IOException {
        ioService.write("Введите символьное выражение пары валют, н-р USD/EUR");
        String input = (String) ioService.read();
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
        String input = (String) ioService.read();
        Symbol symbol = new Symbol();
        symbol.setSymbol(input);

        ioService.write("Введите длину периода, н-р 1, 2, или 10");
        Integer length = (Integer) ioService.read();

        ioService.write("Введите единицу измерения периода: минута - m, час - h, день - d, неделя - w, месяц - month");
        String periodString = (String) ioService.read();
        Period period = Period.fromString(periodString);

        Collection<History> histories = dataSource.getHistory(symbol, length, period);
        ioService.write(histories.toString());
    }


    private void ifExit() {
        ioService.write("Желаете ли продолжить? y/n");
        try {
            if (ioService.read().equals("y")) {
                operationChoose();
            }
        } catch (IOException e) {
            ioService.writeUnknownError();
            ifExit();
        }
    }

    private int readOperation() {
        String operation;
        try {
            if (!(operation = (String) ioService.read()).equals("exit")) {
                Integer operationNumber = Integer.parseInt(operation);
                return operationNumber;
            }
        } catch (IOException e) {
            ioService.writeUnknownError();
            readOperation();
        }
        return 0;
    }

}
