import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ImportDataFromFile {
    public int[] startDataImport() throws FileNotFoundException {

        int[] arrayNumbers = new int[100];

        File file = new File("DataForImport/TestData");

        Scanner scanner = new Scanner(file);

        for (int i = 0; i < 100; i++){
            arrayNumbers[i] = scanner.nextInt();
        }

        scanner.close();

        return arrayNumbers;
    }
}
