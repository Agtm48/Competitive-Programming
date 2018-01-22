/**
 * Created by aksha on 1/2/2018.
 */

import java.util.*;
import java.io.*;

public class BusDriver11389 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("BusDriver11389.in"));
        in.close();


        int result = 0;

        PrintWriter out = new PrintWriter(new File("BusDriver11389.out"));
        System.out.println(result);
        out.println(result);
        out.close();
    }
}
/*  ANALYSIS

In a city there are n bus drivers. Also there are n morning bus routes and n afternoon bus routes with
various lengths. Each driver is assigned one morning route and one evening route. For any driver, if
his total route length for a day exceeds d, he has to be paid overtime for every hour after the first d
hours at a flat r taka / hour. Your task is to assign one morning route and one evening route to each
bus driver so that the total overtime amount that the authority has to pay is minimized.

Algorithm: Greedy (load balancing)


*/