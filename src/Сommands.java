
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Сommands {

    ArrayList<Integer> arrayX = new ArrayList<>(); //Массив хранящий значения чисел, которые можно поделить без остатка на 3
    ArrayList<Integer> arrayS = new ArrayList<>(); //Массив хранящий значения чисел, которые можно поделить без остатка на 7
    ArrayList<Integer> arrayM = new ArrayList<>(); //Массив хранящий значения чисел, которые можно поделить без остатка на 21

    ArrayList<Integer> allLists = new ArrayList<>(); //Общий список

    boolean excludedNumbers = false; //Переменная указывающая на наличие/отсутствие чисел не вошедших ни в один из списков

    public String help() {
        return  "При запуске метода main, вначале выполняется импорт данных из внешнего файла 'TestData'.\n" +
                "Перед инициализацией списков происходит сортировка полученных значений в порядке убывания.\n" +
                "При выполнении инициализации происходит запись в списки по следующим критериям:\n" +
                "Список X - числа, которые можно поделить без остатка на 3,\n" +
                "Список S - числа, которые можно поделить без остатка на 7,\n" +
                "Список M - числа, которые можно поделить без остатка на 21.\n" +
                "Список возможных команд:\n" +
                "\n" +
                "init array - инициализация списков набором значений array\n" +
                "print - печать всех списков \n" +
                "print type - печать конкретного списка, где type принимает значения X,S,M\n" +
                "anymore - вывести на экран, были ли значения не вошедшие ни в один список. Возможные значения true, false\n" +
                "clear type - чистка списка, где type принимает значения X,S,M\n" +
                "merge - слить все списки в один, вывести на экран, а затем очистить все списки\n" +
                "help - вывод справки по командам \n" +
                "end - закрыть программу";
    }

    public void init_array(int[] dataIn) {

        Arrays.sort(dataIn);

        for (int i : dataIn) {
            if ((dataIn[i] % 3) == 0) {
                arrayX.add(dataIn[i]);
            }
            if ((dataIn[i] % 7) == 0) {
                arrayS.add(dataIn[i]);
            }
            if ((dataIn[i] % 21) == 0) {
                arrayM.add(dataIn[i]);
            }
            if ( ((dataIn[i] % 3) != 0) && ((dataIn[i] % 7) != 0) && ((dataIn[i] % 21) != 0) ) {
                if (!excludedNumbers) {
                    excludedNumbers = true;
                }
            }

        }
        System.out.println("Инициализция массивов выполнена");
    }

    public void print(String typeList) {

        if (typeList.equals("X") | typeList.equals("All")) {
            if (this.arrayX.size() == 0) {
                System.out.println("Список X пуст");
            } else {
                System.out.println("Список X содержит следующие элементы");
                System.out.println(arrayX.toString());
            }
        }

        if (typeList.equals("S") | typeList.equals("All")) {
            if (this.arrayS.size() == 0) {
                System.out.println("Список S пуст");
            } else {
                System.out.println("Список S содержит следующие элементы");
                System.out.println(arrayS.toString());
            }
        }

        if (typeList.equals("M") | typeList.equals("All")) {
            if (this.arrayM.size() == 0) {
                System.out.println("Список M пуст");
            } else {
                System.out.println("Список M содержит следующие элементы");
                System.out.println(arrayM.toString());
            }
        }
    }

    public void clear_type(String typeList) {

        if (typeList.equals("All")){
            System.out.println("Все списки очищены");
        } else{
            System.out.println("Список " + typeList + " очищен");
        }

        if (typeList.equals("X") | typeList.equals("All")) {
            this.arrayX.clear();
            }

        if (typeList.equals("S") | typeList.equals("All")) {
            this.arrayS.clear();
        }

        if (typeList.equals("M") | typeList.equals("All")) {
            this.arrayM.clear();
        }
        }

        public void merge(){

            this.allLists.addAll(arrayX);
            this.allLists.addAll(arrayS);
            this.allLists.addAll(arrayM);

            System.out.println(allLists.toString());
            System.out.println("Данные списков X, S, M объединены");

            clear_type("All");
        }

    public void anyMore() {
        System.out.println(excludedNumbers);
    }

}
