package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {
        int twoTimes = 0;
        int threeTimes = 0;

        try {
            Scanner reader = new Scanner(new File("./src/Day2/input.txt"));

            while (reader.hasNext()) {
                String line = reader.nextLine();
                int[] charCount = new int[26];
                boolean hasTwo = false;
                boolean hasThree = false;

                for(int i = 0; i < line.length(); i++) {
                    charCount[line.charAt(i)-97]++;
                }
                for(int count: charCount) {
                    if(count == 2) {
                        hasTwo = true;
                    }
                    if(count == 3) {
                        hasThree = true;
                    }
                }

                if(hasTwo) {
                    twoTimes++;
                }
                if(hasThree) {
                    threeTimes++;
                }
            }

            System.out.println(twoTimes * threeTimes);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
