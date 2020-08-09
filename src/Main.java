import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        SelectCommand selectCommand = new SelectCommand();
        ImportDataFromFile importDataFromFile = new ImportDataFromFile();

        int[] dataIn = importDataFromFile.startDataImport();     //Получаем массив чисел из внешнего файла

        System.out.println("Данные получены. Введите код команды. \n" +
                           "Для получения списка доступных команд введите help \n"+
                           "Для выхода из программы введите end.");

        Scanner scanner = new Scanner(System.in);
        Сommands commands = new Сommands();

        String codeCommand;


        do {
            codeCommand = scanner.nextLine();
            selectCommand.selectCommand(codeCommand, dataIn, commands);
        } while(!codeCommand.equals("end"));

        scanner.close();

    }
}
