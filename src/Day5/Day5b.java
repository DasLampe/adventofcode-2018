package Day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Polymer {
    public String fullReact(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (i + 2 < input.length() && input.substring(i, i + 1).toLowerCase().equals(input.substring(i + 1, i + 2).toLowerCase()) &&
                    !input.substring(i, i + 1).equals(input.substring(i + 1, i + 2))) {

                input = input.substring(0, i) + input.substring(i + 2); //Remove char from input

                if (i - 2 < -1) {
                    i = -1; // Go to char at 0
                } else {
                    i = i - 2;
                }
            }
        }
        return input;
    }

    public String removeChar(String c, String input) {
        for(int i = 0; i < input.length(); i++) {
            if (input.substring(i, i + 1).toLowerCase().equals(c.toLowerCase())) {
                if(input.length() < i +2) {
                    input = input.substring(0, i);
                }
                else {
                    input = input.substring(0, i) + input.substring(i + 1);
                }

                if (i - 2 < -1) {
                    i = -1; // Go to char at 0
                } else {
                    i = i - 2;
                }
            }
        }

        return input;
    }
}

public class Day5b {
    public static void main(String[] args) {
        try {
            Scanner reader = new Scanner(new File("./src/Day5/input.txt"));

            while (reader.hasNext()) {
                String line = reader.nextLine();
                Polymer p = new Polymer();
                int shortLength = line.length();


                for(int i = 65; i <= 90; i++) {
                    String output = p.fullReact(p.removeChar(String.valueOf((char) i), line));
                    if(output.length() < shortLength) {
                        shortLength = output.length();
                    }
                }

                System.out.println(shortLength);
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
