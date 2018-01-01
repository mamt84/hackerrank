package com.challenges.test;

import java.util.Scanner;

public class CodingQuestion2
{
    public static String CountAs( String toCount )
    {
        // I could have done toCount.toLowerCase() or toCount.toUpperCase() for simplicity and
        // just compare with lower case 'a' or upper case 'respectively', but that would add
        // extra computation for no good reason.
        int count = 0;
        for ( int i = 0; i < toCount.length(); i++ )
        {
            if ( 'a' == toCount.charAt( i ) || 'A' == toCount.charAt( i ) )
            {
                count++;
            }
        }
        return Integer.toString( count );
    }

    public static void main( String[] args ) throws Exception
    {
        Scanner sc = new Scanner( System.in );
        System.out.println( CountAs( sc.nextLine() ) );
    }

}
