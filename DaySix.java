import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DaySix {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("DayTwoInput.txt");
        System.out.println(fileData);
        int guardX = 0;
        int guardY = 0;
        String guardSym = "^";
        for (int i = 0; i < fileData.size(); i++) {
            if (fileData.get(i).indexOf("^") != -1) {
                guardX = fileData.get(i).indexOf("^");
                guardY = i;
            }
        }
        while ((guardX != 0 && guardSym.equals("<")) || (guardX != fileData.get(0).length() - 1 && guardSym.equals(">")) || (guardY != 0 && guardSym.equals("^")) || (guardY != fileData.size() - 1 && guardSym.equals("v"))) {
            if (guardSym.equals("^")) {
                for (int i = fileData.size(); i > 0; i++) {
                    if (fileData.get(i).substring(guardX, guardX + 1).equals(".")) {
                        String temp = fileData.get(i).substring()
                    }
                }
                guardSym = ">";
            } else if (guardSym.equals(">")) {
                guardSym = "v";
            } else if (guardSym.equals("v")) {
                guardSym = "<";
            } else if (guardSym.equals("<")) {
                guardSym = "^";
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
