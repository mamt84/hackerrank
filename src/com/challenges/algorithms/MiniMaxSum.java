package com.challenges.algorithms;

import java.util.Scanner;

public class MiniMaxSum
{

    public static void main( String[] args )
    {
        Scanner in = new Scanner( System.in );
        int[] arr = new int[5];
        long sum = 0;
        for ( int arr_i = 0; arr_i < 5; arr_i++ )
        {
            arr[arr_i] = in.nextInt();
            sum += arr[arr_i];
        }

        long min = Long.MAX_VALUE;
        long max = 0;
        for ( int i = 0; i < arr.length; i++ )
        {
            long partial = sum - arr[i];
            if ( partial > max )
                max = partial;
            if ( partial < min )
                min = partial;
        }

        System.out.printf( "%d %d", min, max );

        in.close();
    }

}
