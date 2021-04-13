import java.util.*;
import java.lang.Math.*;

// A program to calculate the great-circle distance between two GPS locations on Earth using the Haversine formula.
// The output is rounded to the nearest 100 km

public class Solution {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        double lat1 = sc.nextDouble();
        double long1 = sc.nextDouble();
        double lat2 = sc.nextDouble();
        double long2 = sc.nextDouble();

        int shortestDist = calculateGreatCircDist(lat1, long1, lat2, long2);

        System.out.println(shortestDist);
    }

    public static int calculateGreatCircDist(double lat1, double long1, double lat2, double long2) {

        int dist = 0;
        final int earthRad = 6371;
        double lat1Radian = Math.toRadians(lat1);
        double long1Radian = Math.toRadians(long1);
        double lat2Radian = Math.toRadians(lat2);
        double long2Radian = Math.toRadians(long2);

        double x1 = Math.sin(lat1Radian);
        double z1 = Math.cos(lat1Radian);
        double x2 = Math.sin(lat2Radian);
        double z2 = Math.cos(lat2Radian);

        double x3 = Math.cos(long2Radian - long1Radian);

        double a = (x1 * x2) + (z1 * z2 * x3);

        dist = (int) ((earthRad * Math.acos(a)) + 0.5);

        return (int) (Math.round(dist/100.0)*100);
    }
}
