package com.challenges.test;

public class CodingQuestion1
{

    public static void main( String[] args )
    {
        String c = "scissors-paper-rock";
        String[] elements =
                ( c.substring( 15 ) + c.substring( 8, 15 ) + c.substring( 0, 8 ) ).toUpperCase().split( "-" );

        for ( int i = 0; i < elements.length; i++ )
        {
            System.out.print( elements[i] + "," );
        }
    }

}
