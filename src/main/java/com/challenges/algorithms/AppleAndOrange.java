package com.challenges.algorithms;

import java.util.Scanner;

public class AppleAndOrange
{
    static int[] appleAndOrange( int s, int t, int a, int b, int[] apple, int[] orange )
    {
        int[] fruitCounts = new int[2];
        for ( int d : apple )
        {
            if ( a + d >= s && a + d <= t )
                fruitCounts[0]++;
        }

        for ( int d : orange )
        {
            if ( b + d >= s && b + d <= t )
                fruitCounts[1]++;
        }
        return fruitCounts;
    }

    public static void main( String[] args )
    {
        Scanner in = new Scanner( System.in );
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int[] apple = new int[m];
        for ( int apple_i = 0; apple_i < m; apple_i++ )
        {
            apple[apple_i] = in.nextInt();
        }
        int[] orange = new int[n];
        for ( int orange_i = 0; orange_i < n; orange_i++ )
        {
            orange[orange_i] = in.nextInt();
        }
        int[] result = appleAndOrange( s, t, a, b, apple, orange );
        for ( int i = 0; i < result.length; i++ )
        {
            System.out.print( result[i] + ( i != result.length - 1 ? "\n" : "" ) );
        }
        System.out.println( "" );

        in.close();
    }

}
