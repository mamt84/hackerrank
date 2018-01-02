package com.challenges.algorithms;

import java.util.Scanner;

public class BetweenTwoSetsOptimized
{
    private static int gcd( int a, int b )
    {
        while ( b > 0 )
        {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    private static int gcd( int[] input )
    {
        int result = input[0];
        for ( int element : input )
        {
            result = gcd( result, element );
        }
        return result;
    }

    private static int lcm( int a, int b )
    {
        return a * ( b / gcd( a, b ) );
    }

    private static int lcm( int[] input )
    {
        int result = input[0];
        for ( int element : input )
        {
            result = lcm( result, element );
        }
        return result;
    }

    static int getTotalX( int[] a, int[] b )
    {
        int count = 0;

        int lcm = lcm( a );
        int gcd = gcd( b );

        for ( int i = lcm; i <= gcd; i += lcm )
        {
            if ( gcd % i == 0 )
                count++;
        }

        return count;
    }

    public static void main( String[] args )
    {
        Scanner in = new Scanner( System.in );
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for ( int a_i = 0; a_i < n; a_i++ )
        {
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for ( int b_i = 0; b_i < m; b_i++ )
        {
            b[b_i] = in.nextInt();
        }
        int total = getTotalX( a, b );
        System.out.println( total );
        in.close();
    }

}
