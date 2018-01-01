package com.challenges.algorithms;

import java.time.LocalTime;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.Scanner;

public class TimeConversion
{
    static String timeConversion( String s )
    {
        LocalTime time = LocalTime
                .parse( s, new DateTimeFormatterBuilder()
                .appendPattern( "hh:mm:ssa" ).toFormatter( Locale.US ) );
        String convertedTime = time.format( new DateTimeFormatterBuilder().appendValue( ChronoField.HOUR_OF_DAY, 2 )
                .appendLiteral( ':' ).appendValue( ChronoField.MINUTE_OF_HOUR, 2 ).appendLiteral( ':' )
                .appendValue( ChronoField.SECOND_OF_MINUTE, 2 ).toFormatter( Locale.US ) );
        return convertedTime.toString();
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
