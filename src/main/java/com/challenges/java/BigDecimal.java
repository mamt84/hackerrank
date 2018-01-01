package com.challenges.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BigDecimal
{

    public static void main( String[] args )
    {
        Scanner sc = new Scanner( System.in );
        int n = sc.nextInt();
        String[] s = new String[n + 2];
        for ( int i = 0; i < n; i++ )
        {
            s[i] = sc.next();
        }
        sc.close();

        Arrays.sort( s, 0, n, new Comparator<String>()
        {
            @Override
            public int compare( String o1, String o2 )
            {
                java.math.BigDecimal left = new java.math.BigDecimal( o1 );
                java.math.BigDecimal right = new java.math.BigDecimal( o2 );
                return right.compareTo( left );
            }
        } );

        for ( int i = 0; i < n; i++ )
        {
            System.out.println( s[i] );
        }
    }

}
