package exсeption;

public class FileSaveException extends Exception{
    public FileSaveException(String message){super("Запись в файл не произведена");}

}
