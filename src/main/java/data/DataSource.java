package data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import connection.Connection;
import connection.ConnectionException;
import connection.Method;
import connection.httpmodel.CurrencyPairResponseBody;
import connection.httpmodel.HistoryResponseBody;
import connection.httpmodel.ProjectObjectMapper;
import connection.httpmodel.SymbolResponseBody;
import model.CurrencyPair;
import model.Symbol;
import model.history.History;
import model.history.Period;

import java.util.Collection;
import java.util.List;

public class DataSource {

    private final Connection connection;

    private final ObjectMapper objectMapper;

    public DataSource() {
        this.connection = new Connection();
        this.objectMapper = new ProjectObjectMapper();
    }

    /**
     * Получить текущий курс пары валют по числовому id
     * @param id - числовой id пары валют
     * @return текущий курс пары валю
     */
    public List<CurrencyPair> getPairById(final Integer id) {
        try {
            return objectMapper.readValue(connection.get(Method.LATEST, List.of(id)).body(), CurrencyPairResponseBody.class)
                    .getResponse();
        } catch (JsonProcessingException e) {
            throw new ConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Получить текущий курс пары валют по символьному выражению пары,
     * обёрнутому в объект Symbol. (Пример объекта: Symbol s = new Symbol(); s.setSymbol("USD/EUR");)
     * @param symbol - симввольное выражение пары валют
     * @return текущий курс пары валю
     */
    public List<CurrencyPair> getPairBySymbol(final Symbol symbol) {
        try {
            return objectMapper.readValue(connection.get(Method.LATEST_SYMBOL, List.of(symbol.getSymbol())).body(), CurrencyPairResponseBody.class)
                    .getResponse();
        } catch (JsonProcessingException e) {
            throw new ConnectionException(e.getMessage(), e);
        }
    }

    /**
     * @return список символьных выражений, содержащих в т.ч. числовые id, всех пар валют
     */
    public List<Symbol> getSymbolsList() {
        try {
            return objectMapper.readValue(connection.get(Method.LIST, List.of()).body(), SymbolResponseBody.class)
                    .getResponse();
        } catch (JsonProcessingException e) {
            throw new ConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Получить историю изменений пары валют за последний #length период времени.
     * Период времени рассчитывается, как #length.concat(#period)
     * @param symbol - симввольное выражение пары валют
     * @param length - числовое выражения периода времени
     * @param period - указание размера временного отрезка, указанного в #length. От минуты до месяца (@see model.history.Period).
     *               Нельзя получить историю за более чем 1 месяц
     * @return история изменений пары валют
     */
    public Collection<History> getHistory(final Symbol symbol, final int length, final Period period) {
        try {
            return objectMapper.readValue(connection.get(Method.HISTORY, List.of(symbol.getSymbol(), period.toPattern(length))).body(), HistoryResponseBody.class)
                    .getResponse()
                    .values();
        } catch (JsonProcessingException e) {
            throw new ConnectionException(e.getMessage(), e);
        }
    }
}
