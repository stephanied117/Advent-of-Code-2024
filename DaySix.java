import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DaySix {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("DaySixInput.txt");
        System.out.println(fileData);
        int xTally = 0;
        int guardX = 0;
        int guardY = 0;
        int tagInd = -1;
        String replaceA = "";
        String replaceB = "";
        String guardSym = "^";
        //find starter position
        for (int i = 0; i < fileData.size(); i++) {
            if (fileData.get(i).indexOf("^") != -1) {
                guardX = fileData.get(i).indexOf("^");
                guardY = i;
            }
        }
        while ((guardX >= 0 && guardSym.equals("<")) || (guardX <= fileData.get(0).length() - 1 && guardSym.equals(">")) || (guardY >= 0 && guardSym.equals("^")) || (guardY <= fileData.size() - 1 && guardSym.equals("v"))) {
            for (int i = 0; i < fileData.size(); i++) {
                if (fileData.get(i).indexOf(guardSym) != -1) {
                    guardX = fileData.get(i).indexOf(guardSym);
                    guardY = i;
                }
            }
            if (guardSym.equals("v")) {
                for (int j = guardY + 1; j < fileData.size(); j++) {
                    if (!fileData.get(j).substring(guardX, guardX + 1).equals("#")) {
                        replaceA = fileData.get(j - 1).substring(0, guardX) + "X" + fileData.get(guardY).substring(guardX + 1);
                        replaceB = fileData.get(j).substring(0, guardX) + "v" + fileData.get(guardY).substring(guardX + 1);
                        //System.out.println(replaceA);
                        //System.out.println(replaceB);
                        fileData.set(guardY,replaceA);
                        fileData.set(guardY + 1,replaceB);
                    } else {
                        guardSym = "<";
                        for (int i = 0; i < fileData.size(); i++) {
                            System.out.println(fileData.get(i));
                        }
                        System.out.println();
                    }
                }
            } else if (guardSym.equals("^")) {
                for (int j = guardY - 1; j > -1; j--) {
                    if (!fileData.get(j).substring(guardX, guardX + 1).equals("#")) {
                        replaceA = fileData.get(j + 1).substring(0, guardX) + "X" + fileData.get(guardY).substring(guardX + 1);
                        replaceB = fileData.get(j).substring(0, guardX) + "^" + fileData.get(guardY).substring(guardX + 1);
                        //System.out.println(replaceA);
                        //System.out.println(replaceB);
                        fileData.set(guardY,replaceA);
                        fileData.set(guardY + 1,replaceB);
                    } else {
                        guardSym = ">";
                        for (int i = 0; i < fileData.size(); i++) {
                            System.out.println(fileData.get(i));
                        }
                        System.out.println();
                    }
                }
            } else if (guardSym.equals(">")) {
                for (int j = guardX + 1; j < fileData.get(guardX).length(); j++) {
                    if (!fileData.get(guardY).substring(j, j + 1).equals("#")) {
                        replaceA = fileData.get(guardY).substring(0, j) + "X>" + fileData.get(guardY).substring(j + 2);
                        //System.out.println(replaceA);
                        fileData.set(guardY,replaceA);
                    } else {
                        guardSym = "v";
                        for (int i = 0; i < fileData.size(); i++) {
                            System.out.println(fileData.get(i));
                        }
                        System.out.println();
                    }
                }
            } else if (guardSym.equals("<")) {
                for (int j = guardX - 1; j > -1; j--) {
                    if (!fileData.get(guardY).substring(j, j + 1).equals("#")) {
                        replaceA = fileData.get(guardY).substring(0, j) + "<X" + fileData.get(guardY).substring(j + 2);
                        //System.out.println(replaceA);
                        fileData.set(guardY,replaceA);
                    } else {
                        guardSym = "^";
                        for (int i = 0; i < fileData.size(); i++) {
                            System.out.println(fileData.get(i));
                        }
                        System.out.println();
                    }
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
