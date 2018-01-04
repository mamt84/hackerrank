package com.challenges.algorithms;

import java.util.Scanner;

public class MigratoryBirds
{
    static int migratoryBirds( int n, int[] ar )
    {
        // Could be done through sorting and then counting, but since types are only 1, 2, 3,
        // 4, 5 it is better to keep 5 counts
        int[] counts = new int[5];
        for ( int i = 0; i < n; i++ )
        {
            counts[ar[i] - 1]++;
        }
        int max = 0;
        int maxElement = 1;
        for ( int i = 0; i < 5; i++ )
        {
            if ( counts[i] > max )
            {
                max = counts[i];
                maxElement = i + 1;
            }
        }
        return maxElement;
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
        int result = migratoryBirds( n, ar );
        System.out.println( result );
    }

}
