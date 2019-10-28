/**
 * Created by aksha on 12/25/2017.
 */

import java.util.*;
import java.io.*;

public class AddAll10954 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        // Greedy Algorithm with Priority Queue
        int n;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        ArrayList<Integer> answers = new ArrayList<>();
        while(!((n = in.nextInt()) == 0)){
            for(int i = 0; i < n; i++){
                queue.add(in.nextInt());
            }
            int total = 0;
            while(!queue.isEmpty()){
                // Starting out ==> removing 1
                int cost = queue.remove();
                if(!queue.isEmpty()){
                    cost += queue.remove();
                    total += cost;
                    queue.add(cost);

                }
                answers.add(total);
            }
        }


        in.close();


        int result = 0;

        PrintWriter out = new PrintWriter(System.out);
        System.out.println(result);
        out.println(result);
        out.close();
    }
}
/*  ANALYSIS





*/