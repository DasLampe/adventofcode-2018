package Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Day4b {
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
                if(mostAsleep == null ||  mostAsleep.minute[mostAsleep.mostMinute()] < guard.minute[guard.mostMinute()]) {
                    mostAsleep = guard;
                }
            }

            System.out.println(mostAsleep.id * mostAsleep.mostMinute());

        } catch (FileNotFoundException e) {

        }
    }
}
