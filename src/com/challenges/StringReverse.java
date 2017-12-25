package com.challenges;

import java.util.Scanner;

public class StringReverse
{

    public static void main( String[] args )
    {
        Scanner sc = new Scanner( System.in );
        String A = sc.next();
        sc.close();

        int stringLength = A.length();
        boolean palindrome = true;
        for ( int i = 0; i < stringLength / 2; i++ )
        {
            if ( A.charAt( i ) != A.charAt( stringLength - 1 - i ) )
            {
                palindrome = false;
                break;
            }
        }

        System.out.println( palindrome ? "Yes" : "No" );
    }

}
