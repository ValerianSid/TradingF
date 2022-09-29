package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.User;

import java.io.BufferedReader;
import java.io.IOException;

public interface IOService {


    String read() throws IOException;

    int readInt();

    float readFloat();

    void write(String message);

    void writeUnknownError();

    Operations readOp();


}