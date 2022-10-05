package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import connection.httpmodel.ProjectObjectMapper;
import entity.User;
import exсeption.FileSaveException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOServiceNew {
    private BufferedReader terminal;
    private FileWritterProcessor<User> processor;
    private ObjectMapper objectMapper;
    private UserReader reader;

    public IOServiceNew() {
        this.terminal = new BufferedReader(new InputStreamReader(System.in));
        this.processor = new UserWriter();
        this.objectMapper = new ProjectObjectMapper();
    }

    public String readInput() throws IOException {
        return this.terminal.readLine();
    }

    public void save(User user) throws IOException, FileSaveException {
        try {
            String json = objectMapper.writeValueAsString(user);
            BufferedWriter writer = processor.getWritter(user);
            writer.write(json);
            writer.flush();
        } catch (IOException e) {
            throw new FileSaveException(e.getMessage());
        }
    }
    public void write (String msg){
        System.out.println(msg);
    }
    public boolean chkUserExist(String login){return reader.chkUserExist(login);}
}
