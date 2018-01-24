// USACO Silver Contest, February 2016
// Load Balancing
import java.util.*;
import java.io.*;

public class balancing {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("balancing.in"));
        int n = in.nextInt();

        Cow[] xSorted = new Cow[n];
        Cow[] ySorted = new Cow[n];
        for(int i = 0; i < n; i++){
            Cow c = new Cow(in);
            xSorted[i] = c;
            ySorted[i] = c;
        }
        in.close();
//        Arrays.sort(xSorted, (Cow a, Cow b) -> a.x - b.x);
        Arrays.sort(xSorted, new Comparator<Cow>() {
            public int compare(Cow a, Cow b) {
                return a.x - b.x;
                // this result will be +, 0, or - depending on the
                //   sorted relationship of a and b
            }
        });
//        Arrays.sort(ySorted, (Cow a, Cow b) -> a.y - b.y);
        Arrays.sort(ySorted, new Comparator<Cow>() {
            public int compare(Cow a, Cow b) {
                return a.y - b.y;
                // this result will be +, 0, or - depending on the
                //   sorted relationship of a and b
            }
        });

        int result = n;
        int left = 0;
        int right = n;
        int up = 0;
        int down = n;
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> vals = new ArrayList<>();
        for(int i = 0; i < n-1; i++){
            Cow vertical = ySorted[i];
            if(vertical.y == ySorted[i+1].y){
                continue;
            }
            up--;
            down++;
            for(int j = 0; j < n-1; j++){
                Cow horizontal = xSorted[i];
                if(horizontal.x == xSorted[i+1].x){
                    continue;
                }
                right--;
                left++;
            }
            max = Math.max(right, left);
            max = Math.max(max, up);
            max = Math.max(max, down);
            vals.add(max);

        }
        PrintWriter out = new PrintWriter(new File("balancing.out"));
        System.out.println(result);
        out.println(result);
        out.close();
    }

    static class Cow {
        int x, y;

        Cow(Scanner in) {
            x = in.nextInt();
            y = in.nextInt();
        }
    }
}

/* ANALYSIS

brute force w/coord compression:
try every possible in-between fence position (1000)
  in both directions (1000)
    loop through all cows to see which quadrant they're in (1000)
    find max out of those quadrants (4)

estimate: ~1000^3 = 1 billion - too slow
O(n^3)

optimize this a bit:
sort the cows first, in 2 diff arrays sorted by 2 diff coordinates
then SLIDE the cows from one quadrant to another horizontally,
  keeping track of quadrant counts changing gradually (requires no inner
  loop of 1000 since only a few cows at a time are moving with each slide)
then, SLIDE the cows vertically, reset all the cows horizontally,
  and SLIDE horizontally again
repeat until you have SLIDED the fence all the way from top to bottom
  (and left to right every time)

estimate: 1000*1000 = 1 mil - no problem
O(n^2)

*/