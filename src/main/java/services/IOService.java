package services;

import java.io.IOException;

public interface IOService {
    String read() throws IOException;
    int readInt();
    float readFloat();
    void write(String message);
    void writeUnknownError();


}