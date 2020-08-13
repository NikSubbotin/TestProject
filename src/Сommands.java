import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Сommands {

    protected List<Integer> arrayX = new ArrayList<>(); //Массив хранящий значения чисел, которые можно поделить без остатка на 3
    protected List<Integer> arrayS = new ArrayList<>(); //Массив хранящий значения чисел, которые можно поделить без остатка на 7
    protected List<Integer> arrayM = new ArrayList<>(); //Массив хранящий значения чисел, которые можно поделить без остатка на 21

    protected List<Integer> allLists = new ArrayList<>(); //Общий список

    boolean excludedNumbers = false; //Переменная указывающая на наличие/отсутствие чисел не вошедших ни в один из списков

    public void help() throws FileNotFoundException {

        File file = new File("resources/help");
        Scanner helpData = new Scanner(file);

        String informationLine;

        do {
            informationLine = helpData.nextLine();
            System.out.println(informationLine);
        } while (!informationLine.equals(""));

        helpData.close();

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
            if (((dataIn[i] % 3) != 0) && ((dataIn[i] % 7) != 0) && ((dataIn[i] % 21) != 0)) {
                if (!excludedNumbers) {
                    excludedNumbers = true;
                }
            }

        }
        System.out.println("Инициализция массивов выполнена");
    }

    public void print(String typeList) {
        if (typeList.equals("All")) {
            print_type("X", arrayX);
            print_type("S", arrayS);
            print_type("M", arrayM);
        }
    }

    public void print_type(String typeList, List<Integer> arrayNum) {

        if (arrayNum.size() == 0) {
            System.out.println("Список " + typeList + " пуст");
        } else {
            System.out.println("Список " + typeList + " содержит следующие элементы");
            System.out.println(arrayNum.toString());
        }
    }

    public void clear(String typeList) {
        if (typeList.equals("All")) {
            clear_type("X", arrayX);
            clear_type("S", arrayS);
            clear_type("M", arrayM);
        }
        System.out.println("Все списки очищены");
    }

    public void clear_type(String typeList, List<Integer> arrayNum) {

        arrayNum.clear();
        System.out.println("Список " + typeList + " очищен");
    }


    public void merge() {

        allLists.addAll(arrayX);
        allLists.addAll(arrayS);
        allLists.addAll(arrayM);

        System.out.println(allLists.toString());
        System.out.println("Данные списков X, S, M объединены");

        clear("All");
    }

    public void anyMore() {
        System.out.println(excludedNumbers);
    }

}
