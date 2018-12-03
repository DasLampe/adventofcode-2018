package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2b {
    public static void main(String[] args) {
        try {
            Scanner reader = new Scanner(new File("./src/Day2/input.txt"));
            ArrayList<String> prevLines = new ArrayList<>();

            while (reader.hasNext()) {
                String line = reader.nextLine();

                //Check line against all prev lines
                for (String prevLine : prevLines) {
                    ArrayList<Character> sameChar = new ArrayList<>();

                    for (int i = 0; i < line.length(); i++) {
                        if(prevLine.charAt(i) == line.charAt(i)) {
                            sameChar.add(line.charAt(i));
                        }
                    }

                    //Only differs at one position
                    if(sameChar.size() == line.length()-1) {
                        //Create string to copy ;)
                        for(char found: sameChar) {
                            System.out.print(found);
                        }
                    }
                }

                //Add line to previous lines
                prevLines.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
