/**
 * Created by aksha on 12/23/2017.
 */

import java.util.*;
import java.io.*;

public class Bricks00591 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int setNo;
        ArrayList<Integer> listOfTotals = new ArrayList<>();
        int setCount = 1;
        while((setNo = in.nextInt()) != 0 && in.hasNextLine()){
            int[] nums = new int[setNo];
            int total = 0;
            for(int i = 0; i < setNo; i++){
                nums[i] = in.nextInt();
                total += nums[i];
            }
            int avg = total/nums.length;
            int runningTotal = 0;
            for(int i = 0; i < setNo; i++){
                runningTotal += Math.abs(avg - nums[i]);
            }
            runningTotal /= 2;
            listOfTotals.add(runningTotal);
        }
        in.close();




        PrintWriter out = new PrintWriter(System.out);
        for(int total : listOfTotals){
            System.out.println("Set #" + setCount);
            System.out.println("The minimum number of moves is " + total);
            out.println("Set #" + setCount);
            out.println("The minimum number of moves is " + total);
            setCount++;
        }
        out.close();
    }
}
/*  ANALYSIS





*/