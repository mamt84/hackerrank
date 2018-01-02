package com.challenges.algorithms;

import java.util.Scanner;

public class BetweenTwoSets
{
    static int getTotalX( int[] a, int[] b )
    {
        // finding the max in a
        int max = a[0];
        for ( int e : a )
        {
            if ( e > max )
                max = e;
        }

        // finding the min in b
        int min = b[0];
        for ( int e : b )
        {
            if ( e < min )
                min = e;
        }

        int count = 0;
        for ( int i = max; i <= min; i++ )
        {
            boolean inBetween = true;
            for ( int e : a )
            {
                if ( i % e != 0 )
                {
                    inBetween = false;
                    break;
                }
            }

            if ( inBetween )
            {
                for ( int e : b )
                {
                    if ( e % i != 0 )
                    {
                        inBetween = false;
                        break;
                    }
                }
            }

            if ( inBetween )
            {
                count++;
            }
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
