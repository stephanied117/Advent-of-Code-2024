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
        int x = guardX;
        int y = guardY;
        String replaceA = "";
        String replaceB = "";
        String guardSym = "^";
        //find starter position
        for (int i = 0; i < fileData.size(); i++) {
            if (fileData.get(i).indexOf("^") != -1) {
                guardX = fileData.get(i).indexOf("^");
                guardY = i;
                x = guardX;
                y = guardY;
            }
        }
        //
        while ((guardX != -1 && guardSym.equals("<")) || (guardX != fileData.get(0).length() && guardSym.equals(">")) || (guardY != -1 && guardSym.equals("^")) || (guardY != fileData.size() && guardSym.equals("v"))) {
            if (guardSym.equals(">")) {
                while (tagInd == -1) {
                    if (!fileData.get(y).substring(x + 1, x + 2).equals("#")) {
                        replaceA = fileData.get(y).substring(0, x + 1) + "X>" + fileData.get(y).substring(x + 3);
                        //System.out.println(replaceA);
                        fileData.set(y,replaceA);
                    } else {
                        tagInd = -1;
                    }
                    x++;
                }
                guardSym = "v";
            } else if (guardSym.equals("<")) {
                while (tagInd == -1) {
                    if (!fileData.get(y).substring(x - 1, x).equals("#")) {
                        replaceA = fileData.get(y).substring(0, x - 1) + "<X" + fileData.get(y).substring(x + 2);
                        //System.out.println(replaceA);
                        fileData.set(y,replaceA);
                    } else {
                        tagInd = -1;
                    }
                    x--;
                }
                guardSym = "^";
            } else if (guardSym.equals("^")) {
                while (tagInd == -1) {
                    if (!fileData.get(y + 1).substring(x, x + 1).equals("#")) {
                        replaceA = fileData.get(y).substring(x - 1, x) + "X" + fileData.get(y).substring(x + 1);
                        replaceB = fileData.get(y - 1).substring(x - 1, x) + "^" + fileData.get(y).substring(x + 1);
                        //System.out.println(replaceA);
                        //System.out.println(replaceB);
                        fileData.set(y,replaceA);
                        fileData.set(y + 1,replaceB);
                    } else {
                        tagInd = -1;
                    }
                    y--;
                }
                guardSym = ">";
            } else if (guardSym.equals("v")) {
                while (tagInd == -1) {
                    if (!fileData.get(y + 1).substring(x, x + 1).equals("#")) {
                        replaceA = fileData.get(y).substring(x - 1, x) + "X" + fileData.get(y).substring(x + 1);
                        replaceB = fileData.get(y + 1).substring(x - 1, x) + "v" + fileData.get(y).substring(x + 1);
                        //System.out.println(replaceA);
                        //System.out.println(replaceB);
                        fileData.set(y,replaceA);
                        fileData.set(y + 1,replaceB);
                    } else {
                        tagInd = -1;
                    }
                    y++;
                }
                guardSym = "<";
            }
            for (int i = 0; i < fileData.size(); i++) {
                System.out.println(fileData.get(i));
            }
            for (int i = 0; i < fileData.size(); i++) {
                if (fileData.get(i).indexOf("^") != -1) {
                    guardX = fileData.get(i).indexOf("^");
                    guardY = i;
                    x = guardX;
                    y = guardY - 1;
                } else if (fileData.get(i).indexOf(">") != -1) {
                    guardX = fileData.get(i).indexOf(">");
                    guardY = i;
                    x = guardX + 1;
                    y = guardY;
                } else if (fileData.get(i).indexOf("v") != -1) {
                    guardX = fileData.get(i).indexOf("v");
                    guardY = i;
                    x = guardX;
                    y = guardY + 1;
                } else if (fileData.get(i).indexOf("<") != -1) {
                    guardX = fileData.get(i).indexOf("<");
                    guardY = i;
                    x = guardX - 1;
                    y = guardY;
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
