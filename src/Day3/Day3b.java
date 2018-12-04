package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3b {
    public static void main(String[] args) {
        int[][] fabric = new int[1000][1000];

        try {
            Scanner reader = new Scanner(new File("./src/Day3/input.txt"));

            while (reader.hasNext()) {
                String line = reader.nextLine();
                Rectangle rec = new Rectangle(line);

                for (int i = rec.top; i < rec.top + rec.height; i++) {
                    for (int j = rec.left; j < rec.left + rec.width; j++) {
                        fabric[i][j]++;
                    }
                }
            }
            reader = null;
            reader = new Scanner(new File("./src/Day3/input.txt"));

            while (reader.hasNext()) {
                boolean noOverlap = true;

                String line = reader.nextLine();
                Rectangle rec = new Rectangle(line);

                x: for (int i = rec.top; i < rec.top + rec.height; i++) {
                    for (int j = rec.left; j < rec.left + rec.width; j++) {
                        if (fabric[i][j] > 1) {
                            noOverlap = false;
                            break x;
                        }
                    }
                }

                if (noOverlap) {
                    System.out.println(rec.id);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
