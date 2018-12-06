package Day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day5 {
    public static void main(String[] args) {
        try {
            Scanner reader = new Scanner(new File("./src/Day5/input.txt"));

            while(reader.hasNext()) {
                String line = reader.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    if(i + 2 < line.length() && line.substring(i,i+1).toLowerCase().equals(line.substring(i+1,i+2).toLowerCase()) &&
                        !line.substring(i,i+1).equals(line.substring(i+1,i+2))) {

                        line = line.substring(0, i) + line.substring(i + 2); //Remove char from line

                        if(i-2 < -1) {
                            i = -1; // Go to char at 0
                        }
                        else {
                            i = i - 2;
                        }
                    }
                }

                System.out.println(line.length());
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
