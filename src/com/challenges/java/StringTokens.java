package com.challenges.java;

import java.util.Scanner;

public class StringTokens
{

    public static void main( String[] args )
    {
        Scanner scan = new Scanner( System.in );
        String s = scan.nextLine();
        // Write your code here.
        scan.close();

        if ( s.matches( " +" ) )
        {
            System.out.println( 0 );
        }
        else
        {
            String[] strings = s.trim().split( "[ !,?._'@]+" );
            System.out.println( strings.length );
            for ( int i = 0; i < strings.length; i++ )
            {
                System.out.println( strings[i] );
            }
        }
    }

}
