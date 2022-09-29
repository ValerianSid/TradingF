package services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public interface FileWritterProcessor<T> {
    BufferedWriter getWritter(T obj)throws IOException;
}
