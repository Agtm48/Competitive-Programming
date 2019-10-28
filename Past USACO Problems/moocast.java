// USACO Silver Contest, December 2016
// Moocast

import java.util.*;
import java.io.*;

public class moocast {
    static Cow[] cows;
    static int n;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("moocast.in"));
        n = in.nextInt();
        cows = new Cow[n];
        for(int i = 0; i < n; i++){
            cows[i] = new Cow(in);
        }
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            int val = find(cows[i], i);
            result = Math.max(result, val);
        }
        in.close();



        PrintWriter out = new PrintWriter(new File("moocast.out"));
//        System.out.println(result);
        out.println(result);
        out.close();
    }
    static int find(Cow c, int index){
        boolean[] used = new boolean[n];
        // Checking which cows are available in the radius of transmission of the passed in cow.
        dfs(index, used);
        int result = 0;
        for(boolean b : used){
            if(b){
                result++;
            }
        }
        return result;
    }
    static void dfs(int index, boolean[] used){
        used[index] = true;
        ArrayList<Integer> within = new ArrayList<>();
        Cow base = cows[index];
        for(int i = 0; i < n; i++){
            Cow curr = cows[i];
            if(used[i]){
                continue;
            }
            if(i != index && Math.pow(base.x - curr.x, 2) + Math.pow(base.y - curr.y, 2) <= Math.pow(base.power, 2)){
                within.add(i);
            }
        }
        for(Integer nearbyIndex : within){
            dfs(nearbyIndex, used);
        }
    }


    static class Cow{
        int x, y, power;
        Cow(Scanner in){
            x = in.nextInt();
            y = in.nextInt();
            power = in.nextInt();
        }
    }
}
/*  ANALYSIS





*/