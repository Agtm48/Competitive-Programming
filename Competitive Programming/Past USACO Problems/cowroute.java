// USACO Bronze Contest, January 2015
// Cow Routing
import java.util.*;
import java.io.*;

public class cowroute {
    static int a,b;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("cowroute.in"));
        a = in.nextInt();   // City A (Starting point)
        b = in.nextInt();   // City B (Ending point)
        int n = in.nextInt();   // Number of routes
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        int minCost = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            // 1st route
            int cost = in.nextInt();
            int size = in.nextInt();
            int[] temp = new int[size];
            for(int j = 0; j < size; j++){
                temp[j] = in.nextInt();
            }
            if(doesWork(temp)){
                minCost = Math.min(cost, minCost);
            }

        }
        in.close();


        int result = 0;

        PrintWriter out = new PrintWriter(new File("cowroute.out"));
        if(minCost == Integer.MAX_VALUE) {
            out.println(-1);
        }
        else{
            out.println(minCost);
        }
        out.close();
    }
    static boolean doesWork(int[] array){
        boolean aFound = false;
        for(int i : array){
            if(i == a){
                aFound = true;
            }
            if(i == b && aFound){
                return true;
            }
        }
        return false;
    }
}
/*  ANALYSIS
Possible Graph Theory implementation, maybe a different algorithm can be used here.




*/