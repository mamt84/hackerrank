package com.challenges.algorithms;

import java.util.Scanner;

public class TheBirthdayBar
{
    static int solve( int n, int[] s, int d, int m )
    {
        int count = 0;
        int sum = 0;
        for ( int i = 0, j = 0; i < n; i++ )
        {
            sum += s[i];
            if ( i - j + 1 == m )
            {
                if ( sum == d )
                    count++;
                sum -= s[j];
                j++;
            }
        }
        return count;
    }

    public static void main( String[] args )
    {
        Scanner in = new Scanner( System.in );
        int n = in.nextInt();
        int[] s = new int[n];
        for ( int s_i = 0; s_i < n; s_i++ )
        {
            s[s_i] = in.nextInt();
        }
        int d = in.nextInt();
        int m = in.nextInt();
        in.close();
        int result = solve( n, s, d, m );
        System.out.println( result );
    }

}
