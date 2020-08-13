import java.io.FileNotFoundException;

public class SelectCommand {
    public void selectCommand(String codeCommand, int[] dataIn, Сommands commands) throws FileNotFoundException {

        switch (codeCommand){
            case ("help") : commands.help(); break;
            case ("init array"): commands.init_array(dataIn); break;
            case ("print"): commands.print("All"); break;
            case ("print X"): commands.print_type("X", commands.arrayX); break;
            case ("print S"): commands.print_type("S", commands.arrayS); break;
            case ("print M"): commands.print_type("M", commands.arrayM); break;

            case ("clear"): commands.clear("All"); break;
            case ("clear X"): commands.clear_type("X", commands.arrayX); break;
            case ("clear S"): commands.clear_type("S", commands.arrayS); break;
            case ("clear M"): commands.clear_type("M", commands.arrayM); break;

            case ("merge"): commands.merge(); break;

            case ("anymore"): commands.anyMore(); break;

            case ("end"): System.out.println("Закрытие программы"); break;
            default : System.out.println("Нет такой команды");
        }
    }
}
