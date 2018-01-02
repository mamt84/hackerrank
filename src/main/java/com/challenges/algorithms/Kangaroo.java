package com.challenges.algorithms;

import java.util.Scanner;

public class Kangaroo
{
    static String kangaroo( int x1, int v1, int x2, int v2 )
    {
        // First, address simple cases
        if ( x1 == x2 && v1 == v2 )
            return "YES";
        if ( x1 < x2 && v1 <= v2 )
            return "NO";
        if ( x1 > x2 && v1 >= v2 )
            return "NO";

        int steps = ( x1 - x2 ) / ( v2 - v1 );
        // No way is going to be negative at this point, but such extra check wont hurt
        if ( steps <= 0 )
            return "NO";
        if ( x1 + v1 * steps == x2 + v2 * steps )
            return "YES";
        return "NO";
    }

    public static void main( String[] args )
    {
        Scanner in = new Scanner( System.in );
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        in.close();
        String result = kangaroo( x1, v1, x2, v2 );
        System.out.println( result );
    }

}
