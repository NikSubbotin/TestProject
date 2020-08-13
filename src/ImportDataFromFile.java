import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ImportDataFromFile {
    public int[] startDataImport() throws FileNotFoundException {

        int quantityNumbers = 100;

        int[] arrayNumbers = new int[quantityNumbers];

        File file = new File("resources/TestData");

        Scanner dataFromFile = new Scanner(file);

        for (int i = 0; i < quantityNumbers; i++){
            arrayNumbers[i] = dataFromFile.nextInt();
        }

        dataFromFile.close();

        return arrayNumbers;
    }
}
