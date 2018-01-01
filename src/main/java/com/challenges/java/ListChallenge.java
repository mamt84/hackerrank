package com.challenges.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListChallenge
{

    public static void main( String[] args )
    {
        Scanner in = new Scanner( System.in );

        int n = in.nextInt();
        List<Integer> list = new ArrayList<>( n );
        while ( n-- > 0 )
        {
            list.add( in.nextInt() );
        }

        int operations = in.nextInt();
        while ( operations-- > 0 )
        {
            String operation = in.next();
            if ( "Insert".equals( operation ) )
            {
                int index = in.nextInt();
                int element = in.nextInt();
                list.add( index, element );
            }
            else
            {
                list.remove( (int) in.nextInt() );
            }
        }
        System.out.println( list.stream().map( i -> i.toString() ).collect( Collectors.joining( " " ) ) );

        in.close();
    }

}
