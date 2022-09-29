package services;

import entity.User;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UserWriter implements FileWritterProcessor<User> {
    @Override
    public BufferedWriter getWritter(User obj) throws IOException {
        File file =new File("classpath:/users/"+obj.getName()+".json");
        return new BufferedWriter(new FileWriter(file));
    }
}
