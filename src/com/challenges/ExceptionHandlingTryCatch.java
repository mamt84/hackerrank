package com.challenges;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandlingTryCatch
{

    public static void main( String[] args )
    {
        Scanner in = new Scanner( System.in );

        try
        {
            int op1 = in.nextInt();
            int op2 = in.nextInt();

            System.out.println( op1 / op2 );
        }
        catch ( ArithmeticException e )
        {
            System.out.println( e );
        }
        catch ( InputMismatchException e )
        {
            System.out.println( e.getClass().getName() );
        }

        in.close();
    }

}
