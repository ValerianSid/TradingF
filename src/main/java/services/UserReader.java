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

    public User getUserFromFile(String login) throws IOException {
        File file = new File("classpath:/users/" + login + ".json");
        if (file.exists()) {
            return objectMapper.readValue(file, User.class);
        }
        throw new IOException("Пользователь " + login + "не найден");
    }

    public boolean chkUserExist(String login) {
        File file = new File("classpath:/users");
        return Arrays.stream(
                        file.listFiles((dir, name) -> name.substring(0, name.lastIndexOf(".json")).equals(login)))
                .findFirst()
                .isPresent();

    }
}