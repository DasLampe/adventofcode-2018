import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.stream.Stream;

public class Day1 {
    public static void main(String[] args) {
        try {
            Scanner reader = new Scanner(new File("./src/Day1/input.txt"));
            int result = 0;
            while(reader.hasNext()) {
                result += Integer.parseInt(reader.nextLine());
            }

            System.out.println(result);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }
}
