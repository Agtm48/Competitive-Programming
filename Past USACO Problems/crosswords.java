// USACO Bronze Contest, December 2014
// Crosswords
import java.util.*;
import java.io.*;

public class crosswords {
    static String[][] grid;
    static int r;
    static int c;
    static int crossCount = 1;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("crosswords.in"));
        r = in.nextInt();
        c = in.nextInt();
        grid = new String[r][c];
        for(int i = 0; i < r; i++){
            String[] s = in.next().split("");
            for(int j = 0; j < s.length; j++){
                grid[i][j] = s[j];
            }
        }
        HashMap<Integer, Integer> answers = new HashMap<>();
        int totalRes = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(across(i, j) || down(i, j)){
                    grid[i][j] = Integer.toString(crossCount);
                    answers.put(i + 1, j + 1);
                    totalRes++;
                    crossCount++;
                }
            }
        }
        in.close();
        for(int i : answers.keySet()){
            System.out.println(i + " " + answers.get(i));
        }

        int result = 0;

        PrintWriter out = new PrintWriter(new File("crosswords.out"));
        System.out.println(totalRes);
        out.println(result);
        out.close();
    }
    static boolean down(int x, int y){
        int count = 0;
        if(!grid[x][y].equals(".") && !grid[x][y].equals(Integer.toString(crossCount))){
            return false;
        }
        for(int i = x; i < r; i++){
            if(!grid[i][y].equals(".") && count < 3){
                return false;
            }
            count++;
        }
        if(count < 3){
            return false;
        }
        return true;
    }
    static boolean across(int x, int y){
        int count = 0;
        if(!grid[x][y].equals(".") && !grid[x][y].equals(Integer.toString(crossCount))){
            return false;
        }
        for(int j = y; j < c; j++){
            if((!grid[x][j].equals(".") || grid[x][j].equals(Integer.toString(crossCount))) && count < 3){
                return false;
            }
            count++;
        }
        if(count < 3){
            return false;
        }
        return true;
    }
}
/*  ANALYSIS





*/