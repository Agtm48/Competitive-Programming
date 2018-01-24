/*
    PROB: transform
    LANG: JAVA


 */
import java.util.*;
import java.io.*;

public class transform {
    static char[][] grid;
    static int n;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("transform.in"));
        n = in.nextInt();
        // Normal Grid
        grid = new char[n][n];
        for(int i = 0; i < n; i++){
            grid[i] = in.next().toCharArray();
        }

        // Modified Grid
        char[][] mod = new char[n][n];
        for(int i = 0; i < n; i++){
            mod[i] = in.next().toCharArray();
        }
        in.close();

        int result = 0;
        if(equalArr(rotate(grid), mod)){
            result = 1;
        }
        else if(equalArr(rotate(rotate(grid)), mod)){
            result = 2;
        }
        else if(equalArr(rotate(rotate(rotate(grid))), mod)){
            result = 3;
        }
        else if(equalArr(reflect(grid), mod)){
            result = 4;
        }
        else if(equalArr(rotate(reflect(grid)), mod) || equalArr(rotate(rotate(reflect(grid))), mod) || equalArr(rotate(rotate(rotate(reflect(grid)))), mod)){
            result = 5;
        }
        else if(equalArr(grid, mod)){
            result = 6;
        }
        else{
            result = 7;
        }


        PrintWriter out = new PrintWriter(new File("transform.out"));
        System.out.println(result);
        out.println(result);
        out.close();
    }
    static char[][] rotate(char[][] arr){
        char[][] temp = new char[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                temp[j][n-i-1] = arr[i][j];
            }
        }
        return temp;

    }
    static char[][] reflect(char[][] arr){
        char[][] temp = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                temp[i][j] = arr[i][n-j-1];
            }
        }
        return temp;
    }
    static boolean equalArr(char[][] a, char[][] b){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(a[i][j] != b[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
/*  ANALYSIS





*/