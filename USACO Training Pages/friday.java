/*
LANG: JAVA
TASK: friday
 */
import java.util.*;
import java.io.*;
public class friday {
    public static void main(String[] args) throws Exception{
        Scanner in = new Scanner(new File("friday.in"));
        int n = in.nextInt();
        int[] frequency = new int[7];
        for(int i = 0; i < 7; i++){
            frequency[i] = 0;
        }
        int[] normYear = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] leapYear = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30 ,31};
        int date = 0;
        int endDate = n + 1900;
        for(int i = 1900; i < endDate; i++){

            for(int month = 0; month < 12; month++){
                int day = (date + 12) % 7;
                frequency[day] = frequency[day] + 1;
                date += isLeap(i) ? leapYear[month] : normYear[month];
            }

        }

        in.close();

        PrintWriter out = new PrintWriter(new File("friday.out"));
        out.print(frequency[5] + " " + frequency[6] + " " + frequency[0] + " " + frequency[1] + " " + frequency[2] + " " + frequency[3] + " " + frequency[4] + "\n");
        System.out.print(frequency[5] + " " + frequency[6] + " " + frequency[0] + " " + frequency[1] + " " + frequency[2] + " " + frequency[3] + " " + frequency[4]);
        out.close();
    }
    public static boolean isLeap(int year) {
        if (year % 100 == 0) {
            return year % 400 == 0;
        } else {
            return year % 4 == 0;
        }
    }
}
