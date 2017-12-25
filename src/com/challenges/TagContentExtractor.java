package com.challenges;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContentExtractor
{

    public static void main( String[] args )
    {
        Scanner in = new Scanner( System.in );
        int testCases = Integer.parseInt( in.nextLine() );
        String regex = "<(.+)>([^<]+)</\\1>";
        Pattern pattern = Pattern.compile( regex );
        while ( testCases > 0 )
        {
            String line = in.nextLine();

            Matcher matcher = pattern.matcher( line );

            boolean flag = false;
            while ( matcher.find() )
            {
                System.out.println( matcher.group( 2 ) );
                flag = true;
            }

            if ( !flag )
            {
                System.out.println( "None" );
            }
            
            testCases--;
        }
        in.close();
    }

}
