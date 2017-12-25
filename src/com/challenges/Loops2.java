package com.challenges;

import java.util.Scanner;

public class Loops2
{

    public static void main( String[] args )
    {
        Scanner in = new Scanner( System.in );
        int q = in.nextInt();
        for ( int i = 0; i < q; i++ )
        {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            int result = 0;
            for ( int j = 0; j < n; j++ )
            {
                result = a;
                for ( int k = 0; k <= j; k++ )
                {
                    result += Double.valueOf( Math.pow( 2, k ) ).intValue() * b;
                }
                System.out.print( result );
                System.out.print( ' ' );
            }
            System.out.println();
        }
        in.close();
    }

}
