package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOServiceImpl implements IOService {

    BufferedReader reader;
    @Override
    public String read() throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = new String();
        inputString = reader.readLine();
        return inputString;
    }

    @Override
    public void write(String message) {
        System.out.println(message);
    }
}
