import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DayTwo {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/DayOneInput.txt");
        System.out.println(fileData);
        for (int i = 0; i < fileData.size(); i++) {
            for (int j = 0; j < fileData.get(i).length(); j++) {
                ArrayList<Integer> report = new ArrayList<Integer>();
                int prior = 0;
                if (fileData.get(i).indexOf(" ") != -1) {
                   int space = fileData.get(i).indexOf(" ");
                   report.add(Integer.parseInt(fileData.get(i).substring(prior,space)));

                }
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
