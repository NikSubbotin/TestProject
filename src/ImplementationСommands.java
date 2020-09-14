import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class ImplementationСommands implements OperationOnNumbers {

    protected List<Integer> arrayX = new ArrayList<>(); //An array that stores the values of numbers that can be evenly divided by 3
    protected List<Integer> arrayS = new ArrayList<>(); //An array that stores the values of numbers that can be evenly divided by 7
    protected List<Integer> arrayM = new ArrayList<>(); //An array that stores the values of numbers that can be evenly divided by 21
    protected List<Integer> allLists = new ArrayList<>(); //General list

    boolean excludedNumbers = false; //A variable indicating the presence / absence of numbers that are not included in any of the lists

    public void help() throws IOException {
        Stream<String> streamHelpData = Files.lines(Paths.get("resources/help"));
        streamHelpData.forEach(System.out::println);
        streamHelpData.close();
    }

    public void init_array(int[] dataIn) {

        Arrays.sort(dataIn);

        arrayX = stream(dataIn).filter(x -> x % 3 == 0).boxed().collect(Collectors.toList());
        arrayS = stream(dataIn).filter(s -> s % 7 == 0).boxed().collect(Collectors.toList());
        arrayM = stream(dataIn).filter(m -> m % 21 == 0).boxed().collect(Collectors.toList());
        excludedNumbers = stream(dataIn).anyMatch(z -> (z % 3 != 0) && (z % 7 != 0) && (z % 21 != 0));

        if (excludedNumbers) {
            System.out.println("Инициализция списков выполнена. Имеются пременные(я) не вошедшие ни в один список");
        } else {
            System.out.println("Инициализция списков выполнена. Использованы все импортированные переменные");
        }
    }

    public void print(String typeList) {
        switch (typeList) {
            case ("X"):
                print_type("X", arrayX);
                break;
            case ("S"):
                print_type("S", arrayS);
                break;
            case ("M"):
                print_type("M", arrayM);
                break;
            case ("All"):
                print_type("X", arrayX);
                print_type("S", arrayS);
                print_type("M", arrayM);
                break;
            default:
                System.out.println("Нет такого списка");
        }
    }


    public void print_type(String typeList, List<Integer> arrayNum) {

        if (arrayNum.isEmpty()) {
            System.out.println("Список " + typeList + " пуст");
        } else {
            System.out.println("Список " + typeList + " содержит следующие элементы");
            System.out.println(arrayNum.toString());
        }
    }

    public void clear(String typeList) {
        switch (typeList) {
            case ("X"):
                clear_type("X", arrayX);
                break;
            case ("S"):
                clear_type("S", arrayS);
                break;
            case ("M"):
                clear_type("M", arrayM);
                break;
            case ("All"):
                clear_type("X", arrayX);
                clear_type("S", arrayS);
                clear_type("M", arrayM);
                break;
            default:
                System.out.println("Нет такого списка");
        }
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
