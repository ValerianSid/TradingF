package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import connection.httpmodel.ProjectObjectMapper;
import entity.User;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class UserReader {
    private ObjectMapper objectMapper;

    public UserReader() {
        this.objectMapper = new ProjectObjectMapper();
    }

    public  User getUserFromFile(String login) throws IOException {
        File file = new File("C:\\Users\\anton\\OneDrive\\JAVA\\TradingF\\Users\\" + login + ".json");
        if (file.exists()) {
            return objectMapper.readValue(file, User.class);
        }
        throw new IOException("Пользователь " + login + "не найден");
    }

    public static boolean chkUserExist(String login) {
        File file = new File("C:\\Users\\anton\\OneDrive\\JAVA\\TradingF\\Users\\");
               return Arrays.stream(
                      file.listFiles((dir, name) -> name.substring(0, name.lastIndexOf(".json")).equals(login)))
                .findFirst()
                .isPresent();

    }
}