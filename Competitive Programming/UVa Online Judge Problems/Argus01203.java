/**
 * Created by aksha on 12/25/2017.
 */

import java.util.*;
import java.io.*;

public class Argus01203 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String s;
        //Checking for the terminating case of #
        PriorityQueue<Register> queue = new PriorityQueue<Register>();
        ArrayList<Register> init = new ArrayList<>();
        while(!(s = in.nextLine()).equals("#")){
            //Initializing each entry in the queue
            Register r = new Register(s);
            init.add(r);
        }
        // ArrayList structure:
            // R1, R2

        // Need to add n (5) different entries to the priorityqueue
        int n = in.nextInt();
        for(Register r : init){
            int orig = r.period;
            r.period = 0;
            for(int i = 0; i < n; i++) {
                Register curr = new Register(r);
                queue.add(curr);
                r.period += orig;
            }
        }
        // The priority queue should be in the correct order by here.

        in.close();
        for(Register r : init){
            System.out.println(r.id + " " + r.period);
        }

        int result = 0;

        PrintWriter out = new PrintWriter(System.out);
        System.out.println(result);
        out.println(result);
        out.close();
    }
    static class Register implements Comparator<Register>{
        int id, period;
        Register(String s){
            String[] tokens = s.split(" ");
            //EX:
            //ID: 2004, Period: 200
            //ID: 2005, Period: 300
            id = Integer.parseInt(tokens[1]);
            period = Integer.parseInt(tokens[2]);
            // now the id and the period have been read into the static class

        }
        Register(Register r){
            this.id = r.id;
            this.period = r.period;
        }
        public int compare(Register r1, Register r2){
            if(r1.period == r2.period){
                return r1.id - r2.id;
            }
            return r1.period - r2.period;
        }
    }
}
/*  ANALYSIS
"Greedy" Algorithm - requires the Java PriorityQueue data structure





*/