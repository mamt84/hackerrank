package com.challenges;

import java.util.Scanner;

public class NegativeSubarray
{

    public static void main( String[] args )
    {
        Scanner in = new Scanner( System.in );
        int n = in.nextInt();
        int[] array = new int[n];
        for ( int i = 0; i < n; i++ )
        {
            array[i] = in.nextInt();
        }

        int sum = 0;
        int count = 0;
        for ( int i = 0; i < array.length; i++ )
        {
            sum = 0;
            for ( int j = i; j < array.length; j++ )
            {
                sum += array[j];
                if ( sum < 0 )
                {
                    count++;
                }
            }
        }

        in.close();

        System.out.println( count );
    }

}
