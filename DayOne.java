//starter code
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DayOne {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/DayOneInput.txt");
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
        int total = 0;
        for (int i = 0; i < firstList.size(); i++) {
            int least1 = firstList.get(0);
            int ind1 = 0;
            int least2 = secondList.get(0);
            int ind2 = 0;
            for (int a = 0; a < firstList.size(); a++) {
                if (firstList.get(a) < least1) {
                    least1 = firstList.get(a);
                    ind1 = a;
                }
            }
            firstList.remove(ind1);
            for (int b = 0; b < secondList.size(); b++) {
                if (secondList.get(b) < least2) {
                    least2 = secondList.get(b);
                    ind2 = b;
                }
            }
            secondList.remove(ind2);
            total += Math.abs(least1 - least2);
        }
        System.out.println(total);
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
