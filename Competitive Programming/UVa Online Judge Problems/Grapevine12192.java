/**
 * Created by aksha on 1/1/2018.
 */

import java.util.*;
import java.io.*;

public class Grapevine12192 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("Grapevine12192.in"));
        int N;
        int M;
        while(true){
            N = in.nextInt();
            M = in.nextInt();
            if(N == 0 && M == 0){
                break;
            }
            int[][] grid = new int[N][M];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    grid[i][j] = in.nextInt();
                }
            }
            int Q = in.nextInt();
            int[] minQueries = new int[Q];
            int[] maxQueries = new int[Q];
            for(int i = 0; i < Q; i++){
                minQueries[i] = in.nextInt();
                maxQueries[i] = in.nextInt();
            }
            int currIndex = 0;
            for(int[] row : grid){
                int col = binarySearchGE(row, minQueries[currIndex]);
                if(col < 0){
                    currIndex++;
                    continue;
                }
                //for(int size = 0; size < )
            }

        }
        in.close();


        int result = 0;

        PrintWriter out = new PrintWriter(new File("Grapevine12192.out"));
        System.out.println(result);
        out.println(result);
        out.close();
    }
    static int binarySearchGE(int[] arr, int key){
        int low = 0;
        int high = arr.length - 1;
        if(arr[high] < key){
            return -1;
        }
        if(arr[low] >= key){
            return low;
        }
        int mid = 0;
        while(low <= high){
            mid = (low + high) / 2;
            if(arr[mid] >= key && arr[mid - 1] < key){
                return mid;
            }

            if(arr[mid] >= key){
                high = mid - 1;
            }
            if(arr[mid] < key){
                low = mid + 1;
            }
        }
        return mid;

    }
}
/*  ANALYSIS

Solve:
    - using a short, but tricky algorithm
    - using a nested for loop structure along with binary search is actually faster than binary searching
        for every single answer possibility.
    - Outer loop: Iterating over the rows of the grid:
        inner Loop: checking increasingly larger square regions, looking for the largest one that meets
        the problem criteria.

    When both loops exit, the result is the size of the largest square region.


Hint: The input array has special sorted properties;
    Use Lower_bound to speed up the search.

The grid can go up to 500 * 500 --> efficient way to search it for the values making up the given
    square region.

Each row is sorted in ascending order from left to right, and each column is sorted in ascending order from
top to bottom.

This makes it optimal for binary search using the Greater than or equal to algorithm.


binarySearchGE(int[] a, int L){
    int lo = 0;
    int hi = n;
    if a[hi] < L return -1
    if a[lo] >= L return lo

    while(lo <= hi){
        mid = lo + (hi - lo) / 2;
        if a[mid] >= L AND a[mid-1] < L:
            return mid;


        if(a[mid] >= L) hi = mid - 1;
        else if(a[mid] < L) lo = mid + 1;

    }









}

*/