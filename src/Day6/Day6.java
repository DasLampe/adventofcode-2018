package Day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Coordinates  {
    int id;
    int x;
    int y;

    public Coordinates(int id, String coordinates) {
        this.id = id;
        this.x = Integer.parseInt(coordinates.split(", ")[0]);
        this.y = Integer.parseInt(coordinates.split(", ")[1]);
    }
}

public class Day6 {
    public static void main(String[] args)  {
        try {
            Scanner reader = new Scanner(new File("./src/Day6/input.txt"));
            ArrayList<Coordinates> allCoordinates = new ArrayList();



            int number = 0;
            while(reader.hasNext()) {
                allCoordinates.add(new Coordinates(number, reader.nextLine()));
                number++;
            }

            int[][] field = new int[1000][1000];

            for(int i = 0; i < 1000; i++) {
                for(int j = 0; j < 1000; j++) {
                    int closet = Integer.MAX_VALUE;

                    for(Coordinates coordinates: allCoordinates) {
                        int distance = Math.abs(coordinates.x - i) + Math.abs(coordinates.y - j);

                        if(distance == closet) {
                            field[i][j] = -1;
                        }
                        if(distance < closet) {
                            closet = distance;
                            field[i][j] = coordinates.id;
                        }
                    }
                }
            }

            ArrayList<Integer> edges = new ArrayList();
            for(int i = 0; i < 999; i++) {
                edges.add(field[999][i]);

                edges.add(field[i][999]);

                edges.add(field[0][i]);

                edges.add(field[i][0]);
            }

            int[] count = new int[allCoordinates.size()];
            for(int[] area: field) {
                for(int id: area) {
                    if(!edges.contains(id)) {
                        count[id]++;
                    }
                }
            }

            int maxSpace = 0;
            for(int c: count) {
                if(c > maxSpace) {
                    maxSpace = c;
                }
            }

            System.out.println(maxSpace);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
