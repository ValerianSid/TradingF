package services;

import services.IOService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOServiceImpl implements IOService {

    private final BufferedReader reader;

    public IOServiceImpl() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String read() throws IOException {
        return reader.readLine();
    }
    public Operations readOp() {
        try {
            return Operations.values()[Integer.parseInt(read())];
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            write("Произошла Ошибка. Повторите ввод");
            return readOp();
        }
    }
    public int readInt() {
        try {
            return Integer.parseInt(read());
        } catch (IOException e) {
            writeUnknownError();
            return readInt();
        }
    }
    public float readFloat() {
        try {
            return Float.parseFloat(read());
        } catch (IOException e) {
            writeUnknownError();
            return readInt();
        }
    }

    public void write(String message) {
        System.out.println(message);
    }

    public void writeUnknownError() {
        write("Неизвестная ошибка. Попробуйте еще раз");
    }
}
