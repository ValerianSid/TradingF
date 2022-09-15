package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOServiceImpl implements IOService {

    BufferedReader reader;
    @Override
    public String read(){
        reader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = new String();
        try{
            inputString = reader.readLine();
        } catch (IOException e) {
            write("Произошла ошибка ввода информации. Попробуйте снова");
            read();
        }
        return inputString;
    }

    @Override
    public void write(String message) {
        System.out.println(message);
    }
}
