package com.challenges.algorithms;

import java.util.Scanner;

public class BreakingBestAndWorstRecords
{
    static int[] breakingRecords( int[] score )
    {
        int[] result = new int[2];

        int min = score[0];
        int max = score[0];
        for ( int element : score )
        {
            if ( element > max )
            {
                max = element;
                result[0]++;
            }
            if ( element < min )
            {
                min = element;
                result[1]++;
            }
        }
        return result;
    }

    public static void main( String[] args )
    {
        Scanner in = new Scanner( System.in );
        int n = in.nextInt();
        int[] score = new int[n];
        for ( int score_i = 0; score_i < n; score_i++ )
        {
            score[score_i] = in.nextInt();
        }
        int[] result = breakingRecords( score );
        for ( int i = 0; i < result.length; i++ )
        {
            System.out.print( result[i] + ( i != result.length - 1 ? " " : "" ) );
        }
        System.out.println( "" );

        in.close();
    }

}
