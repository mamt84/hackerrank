package com.challenges.java;

import java.util.Scanner;

public class EndOfFile
{

    public static void main( String[] args )
    {
        Scanner in = new Scanner( System.in );

        int lineNumber = 1;
        while ( in.hasNext() )
        {
            String line = in.nextLine();
            System.out.printf( "%d %s\n", lineNumber++, line );
        }
        in.close();
    }

}
