import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DayFive {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("DayFiveInput.txt");
        System.out.println(fileData);
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 1177; i++) {
            if (fileData.get(i).contains(numbers.get())) {

            }
        }
    }
    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
