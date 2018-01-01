package com.challenges.algorithms;

import java.util.Scanner;

public class TimeConversionRaw
{
    static String timeConversion( String s )
    {
        String rawTime = s.substring( 0, 8 );
        String meridian = s.substring( 8 );

        StringBuilder builder = new StringBuilder();
        String[] timeComponents = rawTime.split( ":" );
        if ( "AM".equals( meridian ) )
        {
            if ( "12".equals( timeComponents[0] ) )
                builder.append( "00" );
            else
                builder.append( timeComponents[0] );
        }
        else
        {
            if ( "12".equals( timeComponents[0] ) )
                builder.append( timeComponents[0] );
            else
                builder.append( 12 + Integer.parseInt( timeComponents[0] ) );
        }
        builder.append( ":" ).append( timeComponents[1] ).append( ":" ).append( timeComponents[2] );
        return builder.toString();
    }

    public static void main( String[] args )
    {
        Scanner in = new Scanner( System.in );
        String s = in.next();
        in.close();
        String result = timeConversion( s );
        System.out.println( result );
    }

}
