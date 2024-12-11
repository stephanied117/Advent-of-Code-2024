import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DayThree {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("DayThreeInput.txt");
        System.out.println(fileData);
        ArrayList<String> report = new ArrayList<>();
        ArrayList<ArrayList> newFileData = new ArrayList<>();
        String temp = "";
        for (int i = 0; i < fileData.size(); i++) {
            for (int j = 0; j < fileData.get(i).length() - 3; j++) {
                if (fileData.get(i).substring(j, j + 4).equals("mul(")) {
                    String temp2 = fileData.get(i).substring(j + 4);

                    temp += fileData.get(i).substring(j, j + 4);
                }
            }
            report.add(temp);
            newFileData.add(report);
            report = new ArrayList<>();
            temp = "";
        }
        System.out.println(newFileData);
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
