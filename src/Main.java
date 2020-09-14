import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        SelectCommand selectCommand = new SelectCommand();

        int[] dataIn = Files.lines(Paths.get("resources/TestData")).mapToInt(Integer::parseInt).toArray(); //Import data from file

        System.out.println("Данные получены. Введите код команды. \n" +
                "Для получения списка доступных команд введите help \n" +
                "Для выхода из программы введите end.");

        Scanner scanner = new Scanner(System.in);
        OperationOnNumbers operationOnNumbers = new ImplementationСommands();

        String codeCommand;

        do {
            codeCommand = scanner.nextLine();
            selectCommand.selectCommand(codeCommand, dataIn, operationOnNumbers);
        } while (!codeCommand.equals("end"));

        scanner.close();

    }
}
