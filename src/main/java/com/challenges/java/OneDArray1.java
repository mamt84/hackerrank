package com.challenges.java;

import java.util.Scanner;

public class OneDArray1
{
    public static boolean canWin( int leap, int[] game )
    {
        return canWin( leap, game, 0, game.length );
    }

    public static boolean canWin( int leap, int[] game, int current, int end )
    {
        if ( current + leap >= end || current + 1 >= end )
        {
            return true;
        }

        game[current] = 1;
        boolean result = false;

        if ( game[current + leap] == 0 )
        {
            result = result || canWin( leap, game, current + leap, end );
        }
        if ( game[current + 1] == 0 )
        {
            result = result || canWin( leap, game, current + 1, end );
        }
        if ( current - 1 >= 0 && game[current - 1] == 0 )
        {
            result = result || canWin( leap, game, current - 1, end );
        }
        return result;
    }

    public static void main( String[] args )
    {
        Scanner scan = new Scanner( System.in );
        int q = scan.nextInt();
        while ( q-- > 0 )
        {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for ( int i = 0; i < n; i++ )
            {
                game[i] = scan.nextInt();
            }

            System.out.println( ( canWin( leap, game ) ) ? "YES" : "NO" );
        }
        scan.close();
    }
}
