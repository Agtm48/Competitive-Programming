// USACO Silver Contest, 2017
// Secret Cow Code
import java.util.*;
import java.io.*;
//RECURSION
public class cowcode {
    static String code;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("cowcode.in"));
        code = in.next();
        int n = in.nextInt();
        in.close();


        System.out.println(findNext(code, n - 1));
        PrintWriter out = new PrintWriter(new File("cowcode.out"));
        out.close();
    }

    //creating a method to recursively find the next part of the sequence
    static char findNext(String str, long i){
        //Don't even need to do recursion - removing smaller string lengths
        if(i < str.length()){
            return (char) str.charAt((int)i);
        }
        long length = str.length();
        while(2*length <= i){
            length = length * 2;
        }
        if(length == i){
            //length == 6
            return findNext(str, i-1);
        }
        return findNext(str, i - length - 1);
    }

}
/*
*********************       *********************   *********************
C   O   W   W   C   O   O   C   O   W   W   C   C   C   O   W   W   C   O   O   C   O   W   W
1   2   3   4   5   6   7   8   9   10  11  12  13  14  15  16  17  18  19  20  21  22  23  24
-----------------           -----------------       -----------------           -------------


 */
