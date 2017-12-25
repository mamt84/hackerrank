package com.challenges;

import java.util.Scanner;

public class TwoDArray
{

    public static void main( String[] args )
    {
        Scanner in = new Scanner( System.in );
        int arr[][] = new int[6][6];

        int max = Integer.MIN_VALUE;
        for ( int i = 0; i < 6; i++ )
        {
            for ( int j = 0; j < 6; j++ )
            {
                arr[i][j] = in.nextInt();
                if ( i >= 2 && j >= 2 )
                {
                    int local = arr[i - 2][j - 2] + arr[i - 2][j - 1] + arr[i - 2][j] + arr[i - 1][j - 1]
                            + arr[i][j - 2] + arr[i][j - 1] + arr[i][j];
                    if ( local > max )
                    {
                        max = local;
                    }
                }
            }
        }
        in.close();

        System.out.println( max );
    }

}
