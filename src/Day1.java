import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Day1 {
    public static void main(String[] args) {
        try {
            List<Integer> results = new ArrayList<Integer>();
            boolean stop = false;
            int result = 0;
            Scanner reader;

            while(stop == false) {
                reader = new Scanner(new File("./src/Day1/input.txt"));

                while (reader.hasNext()) {
                    result += Integer.parseInt(reader.nextLine());
                    if (!results.contains(result)) {
                        System.out.println(result);
                        stop = true;
                        break;
                    }
                    results.add(result);
                }
                reader.close();
                reader = null;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }
}
