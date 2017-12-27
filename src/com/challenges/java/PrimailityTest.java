package com.challenges.java;

import java.util.Scanner;

public class PrimailityTest
{

    public static void main( String[] args )
    {
        Scanner in = new Scanner( System.in );
        java.math.BigInteger n = in.nextBigInteger();
        in.close();

        System.out.println( n.isProbablePrime( 10 ) ? "prime" : "not prime" );
    }

}
