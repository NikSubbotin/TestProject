public class SelectCommand {
    public void selectCommand(String codeCommand, int[] dataIn, Сommands commands){

        switch (codeCommand){
            case ("help") : System.out.println(commands.help()); break;
            case ("init array"): commands.init_array(dataIn); break;
            case ("print"): commands.print("All"); break;
            case ("print X"): commands.print("X"); break;
            case ("print S"): commands.print("S"); break;
            case ("print M"): commands.print("M"); break;

            case ("clear"): commands.clear_type("All"); break;
            case ("clear X"): commands.clear_type("X"); break;
            case ("clear S"): commands.clear_type("S"); break;
            case ("clear M"): commands.clear_type("M"); break;
            case ("merge"): commands.merge(); break;

            case ("anymore"): commands.anyMore(); break;

            case ("end"): System.out.println("Закрытие программы"); break;
            default : System.out.println("Нет такой команды");
        }
    }
}
