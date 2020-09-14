import java.io.IOException;

public class SelectCommand {
    public void selectCommand(String codeCommand, int[] dataIn, OperationOnNumbers operationOnNumbers) throws IOException {

        switch (codeCommand){
                case ("help") : operationOnNumbers.help(); break;
                case ("init array"): operationOnNumbers.init_array(dataIn); break;
                case ("print"): operationOnNumbers.print("All"); break;
                case ("print X"): operationOnNumbers.print("X"); break;
                case ("print S"): operationOnNumbers.print("S"); break;
                case ("print M"): operationOnNumbers.print("M"); break;

                case ("clear"): operationOnNumbers.clear("All"); break;
                case ("clear X"): operationOnNumbers.clear("X"); break;
                case ("clear S"): operationOnNumbers.clear("S"); break;
                case ("clear M"): operationOnNumbers.clear("M"); break;

                case ("merge"): operationOnNumbers.merge(); break;

                case ("anymore"): operationOnNumbers.anyMore(); break;

                case ("end"): System.out.println("Закрытие программы"); break;
                default : System.out.println("Нет такой команды");
        }
    }
}
