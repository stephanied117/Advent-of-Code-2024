import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DayFive {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("DayFiveInput.txt");
        System.out.println(fileData);
        ArrayList<Integer> report = new ArrayList<>();
        ArrayList<ArrayList> newFileData = new ArrayList<>();
        String temp = "";
        int safe = 0;
        for (int i = 1178; i < fileData.size(); i++) {
            for (int j = 0; j < fileData.get(i).length(); j++) {
                if (!fileData.get(i).substring(j, j + 1).equals(",")) {
                    temp += fileData.get(i).substring(j, j + 1);
                } else {
                    report.add(Integer.parseInt(temp));
                    temp = "";
                }
            }
            report.add(Integer.parseInt(temp));
            temp = "";
            newFileData.add(report);
            report = new ArrayList<>();
        }
        System.out.println(newFileData);
        ArrayList<Integer> numbers = new ArrayList<>();
        int tally = 0;
        for (int i = 0; i < newFileData.size(); i++) {
            for (int j = 0; j < newFileData.get(i).size(); j++) {
                if (newFileData.get(i).get(j).equals(Integer.parseInt(fileData.get(i).substring(0, fileData.get(i).indexOf("|"))))) {
                    tally++;
                } else if (newFileData.get(i).get(j).equals(Integer.parseInt(fileData.get(i).substring(fileData.get(i).indexOf("|") + 1)))) {
                    tally--;
                }
            }
            System.out.println(tally);
            numbers.add(tally);
            tally = 0;
        }
        System.out.println(numbers);
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
