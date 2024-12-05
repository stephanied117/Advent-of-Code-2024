import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DayTwo {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("DayTwoInput.txt");
        System.out.println(fileData);
        int num = 0;
        for (int i = 0; i < fileData.size(); i++) {
            ArrayList<Integer> report = new ArrayList<>();
            for (int j = 0; j < fileData.get(i).length(); j++) {
                int ind = fileData.get(i).indexOf(" ");
                String temp = fileData.get(i).substring(0, ind) + fileData.get(i).substring(ind + 1);
                if (j == 0) {
                    num = Integer.parseInt(fileData.get(i).substring(0, ind));
                } else if (j == fileData.get(i).length() - 1) {
                    num = Integer.parseInt(fileData.get(i).substring(ind));
                } else {
                    int ind2 = temp.indexOf(" ");
                    num = Integer.parseInt(fileData.get(i).substring(ind + 1, ind2 + 1));
                }
                System.out.println(temp);
                fileData.add(i, temp);
                fileData.remove(i + 1);
                System.out.println(fileData);
                System.out.println(num);
                report.add(num);
                System.out.println(report);
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
