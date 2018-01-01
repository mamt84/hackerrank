package com.challenges.test;

public class CodingQuestion3
{

    public static void main( String[] args )
    {
        int[] values =
        {
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        };

        for ( int x = 0; x < values.length; x++ )
        {
            switch ( values[x] % 2 )
            {
                case 0:
                    System.out.println( x );
                    break;
                case 2:
                    System.out.println( x );
                    break;
            }
        }
    }

}
