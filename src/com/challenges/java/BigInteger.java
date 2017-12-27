package com.challenges.java;

import java.util.Scanner;

public class BigInteger
{

    public static void main( String[] args )
    {
        Scanner in = new Scanner( System.in );
        java.math.BigInteger left = in.nextBigInteger();
        java.math.BigInteger right = in.nextBigInteger();
        in.close();

        System.out.println( left.add( right ) );
        System.out.println( left.multiply( right ) );
    }

}
