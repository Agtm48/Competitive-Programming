/**
 * Created by aksha on 1/1/2018.
 */

import java.util.*;
import java.io.*;

public class Desert11935 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("Desert11935.in"));
        double errorMargin = 1 * Math.pow(10, -9);
        double low = 0;
        double high = 10000;
        double mid = 0;
        double ans = 0;
        while(Math.abs(high - low) > errorMargin){
            mid = (low + high) / 2;
            if(can(mid)){
                ans = mid;
                high = mid;
            }
            else{
                low = mid;
            }
        }
        System.out.println(ans);
        in.close();


        int result = 0;

        PrintWriter out = new PrintWriter(new File("Desert11935.out"));
        System.out.println(result);
        out.println(result);
        out.close();
    }
    // This is the simulation method that will see whether or not the jeep can reach goal state with fuel
    //  tank capacity f.
    static boolean can(double f){
        return false;
    }
}
/*  ANALYSIS
The abridged version of UVa 11935 - Through the Desert is as follows: Imagine that you are
an explorer trying to cross a desert. You use a jeep with a ‘large enough’ fuel tank – initially
full. You encounter a series of events throughout your journey such as ‘drive (that consumes
fuel)’, ‘experience gas leak (further reduces the amount of fuel left)’, ‘encounter gas station
(allowing you to refuel to the original capacity of your jeep’s fuel tank)’, ‘encounter mechanic
(fixes all leaks)’, or ‘reach goal (done)’. You need to determine the smallest possible fuel
tank capacity for your jeep to be able to reach the goal. The answer must be precise to three
digits after decimal point.
Setting your jeep fuel tank volume to any value between [X..10000.000] will bring your jeep safely to the goal
event, usually with some fuel left. This property allows us to binary search the answer X!
We can use the following code to obtain the solution for this problem.


*/