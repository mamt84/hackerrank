package com.challenges.java;

import java.util.Arrays;
import java.util.Scanner;

public class Anagrams
{
    static boolean isAnagram( String a, String b )
    {
        char[] arrayA = a.toLowerCase().toCharArray();
        char[] arrayB = b.toLowerCase().toCharArray();
        Arrays.sort( arrayA );
        Arrays.sort( arrayB );

        return String.valueOf( arrayA ).equals( String.valueOf( arrayB ) );
    }

    public static void main( String[] args )
    {
        Scanner scan = new Scanner( System.in );
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram( a, b );
        System.out.println( ( ret ) ? "Anagrams" : "Not Anagrams" );
    }

}
