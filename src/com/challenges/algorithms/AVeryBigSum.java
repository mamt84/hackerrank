package com.challenges.algorithms;

import java.util.Scanner;

public class AVeryBigSum
{
    static long aVeryBigSum( int n, long[] ar )
    {
        long sum = 0L;
        for ( long num : ar )
        {
            sum += num;
        }
        return sum;
    }

    public static void main( String[] args )
    {
        Scanner in = new Scanner( System.in );
        int n = in.nextInt();
        long[] ar = new long[n];
        for ( int ar_i = 0; ar_i < n; ar_i++ )
        {
            ar[ar_i] = in.nextLong();
        }
        in.close();
        long result = aVeryBigSum( n, ar );
        System.out.println( result );
    }

}
