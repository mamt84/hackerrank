package com.challenges;

import java.util.Calendar;
import java.util.Scanner;

public class DateAndTime
{

    public static void main( String[] args )
    {
        Scanner in = new Scanner( System.in );
        String month = in.next();
        String day = in.next();
        String year = in.next();
        in.close();

        System.out.println( getDay( day, month, year ) );

    }

    private static String getDay( String day, String month, String year )
    {
        String[] dayOfWeek =
        {
                "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"
        };

        Calendar calendar = Calendar.getInstance();
        calendar.set( Integer.parseInt( year ), Integer.parseInt( month ) - 1, Integer.parseInt( day ) );

        int result = calendar.get( Calendar.DAY_OF_WEEK );

        return dayOfWeek[result - 1];
    }

}
