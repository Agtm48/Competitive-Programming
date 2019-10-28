// USACO Bronze Contest, December 2014
// Marathon

import java.util.*;
import java.io.*;

public class marathon {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("marathon.in"));
        int n = in.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for(int i = 0; i < n; i++){
            x[i] = in.nextInt();
            y[i] = in.nextInt();

        }
        int total = 0;
        //Now we have the total distance.
        for(int i = 1; i < n; i++){
            total += Math.abs(x[i] - x[i-1]) + Math.abs(y[i] - y[i-1]);
        }
        //Iterating from 1 to 2 (Index value)
        int totalMin = Integer.MAX_VALUE;
        int original = Integer.MIN_VALUE;
        for(int K = 1; K < n - 1; K++){
            int totalDistance = Math.abs(x[K+1] - x[K]) + Math.abs(x[K] - x[K-1]) + Math.abs(y[K+1] - y[K]) + Math.abs(y[K] - y[K-1]);
            int skip = Math.abs(x[K+1] - x[K-1]) + Math.abs(y[K+1] - y[K-1]);
            original = Math.max(original, totalDistance - skip);
        }

        in.close();


        int result = 0;

        PrintWriter out = new PrintWriter(new File("marathon.out"));
        System.out.println(total - original);
        out.println(total - original);
        out.close();
    }
}
/*  ANALYSIS
Given many checkpoints, find the smallest distance to go from one checkpoint to the next if one checkpoint
can be removed from the original order.
Brute Force is not possible, since O(n^2) with n = 100K will be too large for any answer.

4
0 0
8 3
11 -1
10 0

The array values for the input case are:
    0   1   2   3
x[] 0   8   11  10
y[] 0   3   -1  0


Start   End     Distance
0,0     8,3     11
0,0     11,-1   12
0,0     10,0    10
8,3     11,-1   7
8,3     10,0    5
11,-1   10,0    2


The total distance is 11 + 7 + 2 = 20 units.

If we were to loop through all the values of K for which K will be removed from the list of checkpoints,
then the runtime of the algorithm would be within a reasonable and passable range.


1, 2, K, ... N

Looping from 2 to N - 1 because 1 and N cannot be included within the range of deletable checkpoints
*/