//starter code
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DayFour {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("DayFourInput.txt");
        System.out.println(fileData);
        int tally = 0;
        for (int i = 0; i < fileData.size(); i++) {
            for (int j = 0; j < fileData.get(i).length() - 3; j++) {
                if (fileData.get(i).substring(j, j + 4).equals("XMAS") || fileData.get(i).substring(j, j + 4).equals("SAMX")) {
                    tally++;
                }
            }
        }
        System.out.println(tally);
        for (int i = 0; i < fileData.size() - 3; i++) {
            for (int j = 0; j < fileData.get(i).length(); j++) {
                if (fileData.get(i).substring(j, j + 1).equals("X") && fileData.get(i + 1).substring(j, j + 1).equals("M") && fileData.get(i + 2).substring(j, j + 1).equals("A") && fileData.get(i + 3).substring(j, j + 1).equals("S")) {
                    tally++;
                } else if (fileData.get(i).substring(j, j + 1).equals("S") && fileData.get(i + 1).substring(j, j + 1).equals("A") && fileData.get(i + 2).substring(j, j + 1).equals("M") && fileData.get(i + 3).substring(j, j + 1).equals("X")) {
                    tally++;
                }
            }
        }
        System.out.println(tally);
        for (int i = 0; i < fileData.size() - 3; i++) {
            for (int j = 0; j < fileData.get(i).length() - 3; j++) {
                if (fileData.get(i).substring(j, j + 1).equals("X") && fileData.get(i + 1).substring(j + 1, j + 2).equals("M") && fileData.get(i + 2).substring(j + 2, j + 3).equals("A") && fileData.get(i + 3).substring(j + 3, j + 4).equals("S")) {
                    tally++;
                } else if (fileData.get(i).substring(j, j + 1).equals("S") && fileData.get(i + 1).substring(j + 1, j + 2).equals("A") && fileData.get(i + 2).substring(j + 2, j + 3).equals("M") && fileData.get(i + 3).substring(j + 3, j + 4).equals("X")) {
                    tally++;
                }
            }
        }
        System.out.println(tally);
        for (int i = 3; i < fileData.size(); i++) {
            for (int j = 4; j < fileData.get(i).length(); j++) {
                if (fileData.get(i).substring(j - 1, j).equals("X") && fileData.get(i - 1).substring(j - 2, j - 1).equals("M") && fileData.get(i - 2).substring(j - 3, j - 2).equals("A") && fileData.get(i - 3).substring(j - 4, j - 3).equals("S")) {
                    tally++;
                } else if (fileData.get(i).substring(j - 1, j).equals("S") && fileData.get(i - 1).substring(j - 2, j - 1).equals("A") && fileData.get(i - 2).substring(j - 3, j - 2).equals("M") && fileData.get(i - 3).substring(j - 4, j - 3).equals("X")){
                    tally++;
                }
            }
        }
        System.out.println(tally);
        // part 2
        tally = 0;
        for (int i = 0; i < fileData.size() - 2; i++) {
            for (int j = 0; j < fileData.get(i).length() - 2; j++) {
                if ((fileData.get(i).substring(j, j + 1).equals("M") && fileData.get(i + 2).substring(j + 2, j + 3).equals("S")) ||  (fileData.get(i).substring(j, j + 1).equals("S") && fileData.get(i + 2).substring(j + 2, j + 3).equals("M"))) {
                    if ((fileData.get(i).substring(j + 2, j + 3).equals("M") && fileData.get(i + 2).substring(j, j + 1).equals("S")) ||  (fileData.get(i).substring(j + 2, j + 3).equals("S") && fileData.get(i + 2).substring(j, j + 1).equals("M"))) {
                        if (fileData.get(i + 1).substring(j + 1, j + 2).equals("A")) {
                            tally++;
                        }
                    }
                }
            }
        }
        System.out.println(tally);
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
