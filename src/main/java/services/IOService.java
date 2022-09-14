package services;

import java.io.IOException;

public interface IOService <T>{
    T read() throws IOException;
    void write(String message);
    void writeUnknownError();
    //public T readInt();

}
