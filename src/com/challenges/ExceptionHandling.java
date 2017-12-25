package com.challenges;

import java.util.Scanner;

class MyOtherCalculator
{
    public int power( int n, int p ) throws Exception
    {
        if ( n < 0 || p < 0 )
        {
            throw new Exception( "n or p should not be negative." );
        }

        if ( n == 0 && p == 0 )
        {
            throw new Exception( "n and p should not be zero." );
        }

        return new Double( Math.pow( n, p ) ).intValue();
    }
}

public class ExceptionHandling
{
    public static final MyOtherCalculator my_calculator = new MyOtherCalculator();
    public static final Scanner      in            = new Scanner( System.in );

    public static void main( String[] args )
    {
        while ( in.hasNextInt() )
        {
            int n = in.nextInt();
            int p = in.nextInt();

            try
            {
                System.out.println( my_calculator.power( n, p ) );
            }
            catch ( Exception e )
            {
                System.out.println( e );
            }
        }
    }
}
