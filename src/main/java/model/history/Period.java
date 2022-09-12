package model.history;

import connection.ConnectionException;

public enum Period {

    MINUTE("m"),
    HOUR("h"),
    DAY("d"),
    WEEK("w"),
    MONTH("month");

    private final String suffix;

    Period(String suffix) {
        this.suffix = suffix;
    }

    public String toPattern(final Integer period) {
        if (period == null && this != MONTH) {
            throw new ConnectionException("Период не определен");
        }
        return String.format("%d%s", period, this.suffix);
    }

    public static Period fromString(String input) {
        switch (input) {
            case "m":
                return Period.MINUTE;
            case "h":
                return Period.HOUR;
            case "d":
                return Period.DAY;
            case "w":
                return Period.WEEK;
            case "month":
                return Period.MONTH;
            default: throw new ConnectionException("Период не определен");
        }
    }
}
