package Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Guard {
    int[] minute = new int[59];
    int id;
    int sleep;

    public Guard(int id) {
        this.id = id;
    }

    public void sleep(int minute) {
        this.sleep = minute;
    }

    public void awake(int minute) {
        for (int i = this.sleep; i < minute; i++) {
            this.minute[i]++;
        }
    }

    public int minutesAsleep() {
        int result = 0;
        for (int i = 0; i < 59; i++) {
            result += this.minute[i];
        }
        return result;
    }

    public int mostMinute() {
        int mostMinute = 0;
        int highValue = 0;
        for(int i = 0; i < 59; i++) {
            if(highValue < this.minute[i]) {
                mostMinute = i;
                highValue = this.minute[i];
            }
        }
        return mostMinute;
    }
}

class Note {
    Calendar date = Calendar.getInstance();
    int action; //0 awake; 1 asleep; other = id

    public Note(String s) {
        try {
            SimpleDateFormat ft = new SimpleDateFormat("y-M-d k:m");
            this.date.setTime(ft.parse(s.substring(1, 18)));

            switch (s.substring(19, 24)) {
                case "Guard":
                    this.action = Integer.parseInt(s.substring(26).split("\\s")[0]);
                    break;
                case "falls":
                    this.action = 1;
                    break;
                case "wakes":
                    this.action = 0;
                    break;
            }
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }
}

public class Day4 {
    public static void main(String[] args) {
        try {
            Scanner reader = new Scanner(new File("./src/Day4/input.txt"));
            ArrayList<Note> notes = new ArrayList<>();

            while (reader.hasNext()) {
                notes.add(new Note(reader.nextLine()));
            }

            //sort by date
            notes.sort(Comparator.comparing(x -> x.date));

            HashMap<Integer,Guard> guards = new HashMap();
            Guard curGuard = null;

            for(Note note: notes) {
                //New guard
                if(note.action > 1) {
                    if(guards.containsKey(note.action)) {
                        curGuard = guards.get(note.action);
                    } else {
                        curGuard = new Guard(note.action);
                        guards.put(note.action, curGuard);
                    }
                }

                //falls asleep
                if(note.action == 1) {
                    curGuard.sleep(note.date.get(Calendar.MINUTE));
                }
                //wakes up
                if(note.action == 0) {
                    curGuard.awake(note.date.get(Calendar.MINUTE));
                }
            }

            Guard mostAsleep = null;
            for(Guard guard: guards.values()) {
                if(mostAsleep == null || mostAsleep.minutesAsleep() < guard.minutesAsleep()) {
                    mostAsleep = guard;
                }
            }

            System.out.println(mostAsleep.id * mostAsleep.mostMinute());

        } catch (FileNotFoundException e) {

        }
    }
}
