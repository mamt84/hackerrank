package com.challenges.algorithms;

import java.util.Scanner;

public class PlusMinus
{
    static void plusMinus( int[] arr )
    {
        float totalCount = arr.length;
        float positiveCount = 0;
        float negativeCount = 0;
        for ( int e : arr )
        {
            if ( e > 0 )
                positiveCount++;
            else if ( e < 0 )
                negativeCount++;
        }

        System.out.printf( "%.6f\n%.6f\n%.6f", positiveCount / totalCount, negativeCount / totalCount,
                           ( totalCount - positiveCount - negativeCount ) / totalCount );
    }

    public static void main( String[] args )
    {
        Scanner in = new Scanner( System.in );
        int n = in.nextInt();
        int[] arr = new int[n];
        for ( int arr_i = 0; arr_i < n; arr_i++ )
        {
            arr[arr_i] = in.nextInt();
        }
        plusMinus( arr );
        in.close();
    }

}
