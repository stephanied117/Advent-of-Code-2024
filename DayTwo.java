import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DayTwo {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("DayTwoInput.txt");
        System.out.println(fileData);
        int tally = 0;
        for (int i = 0; i < fileData.size(); i++) {
            ArrayList<Integer> newFileData = new ArrayList<>();
            for (int j = 0; j < fileData.get(i).length() + 2; j++) {
                int ind = fileData.get(i).indexOf(" ");
                newFileData.add(Integer.parseInt(fileData.get(i).substring(0, ind)));
                fileData.set(i, fileData.get(i).substring(ind + 1));
                fileData.remove(i + 1);
            }
            newFileData.add(Integer.parseInt(fileData.get(i).substring(0)));
            System.out.println(fileData);
            System.out.println(newFileData);
            int inc = 0;
            int dec = 0;
            for (int k = 0; k < newFileData.size() - 1; k++) {
                int first = newFileData.get(k);
                int second = newFileData.get(k + 1);
                if (first % second == 1 || first % second == 2 || first % second == 3) {
                    inc++;
                } else if (second % first == 1 || second % first == 2 || second % first == 3) {
                    dec++;
                }
            }
            if (inc == newFileData.size() || dec == newFileData.size()) {
                tally++;
                System.out.println(tally);
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
