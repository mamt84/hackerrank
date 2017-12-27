package com.challenges.algorithms;

import java.util.Scanner;

public class BirthdayCakeCandles
{
    static int birthdayCakeCandles( int n, int[] ar )
    {
        long max = 0;
        int count = 0;

        // Getting the max and count in just 1 pass
        for ( int height : ar )
        {
            if ( height == max )
            {
                count++;
            }

            if ( height > max )
            {
                max = height;
                count = 1;
            }
        }
        return count;
    }

    public static void main( String[] args )
    {
        Scanner in = new Scanner( System.in );
        int n = in.nextInt();
        int[] ar = new int[n];
        for ( int ar_i = 0; ar_i < n; ar_i++ )
        {
            ar[ar_i] = in.nextInt();
        }
        in.close();
        int result = birthdayCakeCandles( n, ar );
        System.out.println( result );
    }

}
