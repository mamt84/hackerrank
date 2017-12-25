package com.challenges;

import java.util.Scanner;

public class StringCompare
{
    public static String getSmallestAndLargest( String s, int k )
    {
        String smallest = "";
        String largest = "";

        smallest = s.substring( 0, k );
        largest = s.substring( 0, k );
        String current;
        for ( int i = 0; i <= s.length() - k; i++ )
        {
            current = s.substring( i, i + k );
            if ( current.compareTo( smallest ) < 0 )
            {
                smallest = current;
            }
            if ( current.compareTo( largest ) > 0 )
            {
                largest = current;
            }
        }
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'

        return smallest + "\n" + largest;
    }

    public static void main( String[] args )
    {
        Scanner scan = new Scanner( System.in );
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println( getSmallestAndLargest( s, k ) );
    }

}
