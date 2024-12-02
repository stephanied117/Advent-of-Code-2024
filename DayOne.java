//starter code
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DayOne {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Day1Input.txt");
        System.out.println(fileData);
        ArrayList<Integer> firstList = new ArrayList<Integer>();
        ArrayList<Integer> secondList = new ArrayList<Integer>();
        for (int i = 0; i < fileData.size(); i++) {
            int ind = fileData.get(i).indexOf("   ");
            int firstNum = Integer.parseInt(fileData.get(i).substring(0,ind));
            int secondNum = Integer.parseInt(fileData.get(i).substring(ind + 3));
            firstList.add(i, firstNum);
            secondList.add(i, secondNum);
        }
        int count = 0;
        int tally = 0;
        int ind2 = 0;
        for (int i = 0; i < firstList.size(); i++) {
            for (int j = 0; j < firstList.size() - 1; j++) {
                ind2 = j;
                if (firstList.get(j) < firstList.get(j + 1)) {
                    tally++;
                }
            }
            if (tally == firstList.size()) {
                int temp = firstList.get(ind2);
                firstList.remove(ind2);
                firstList.add(count, temp);
                count++;
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
