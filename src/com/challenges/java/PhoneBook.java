package com.challenges.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook
{

    public static void main( String[] args )
    {
        Scanner in = new Scanner( System.in );
        int n = in.nextInt();
        Map<String, Integer> phoneBook = new HashMap<>( n );

        in.nextLine();
        for ( int i = 0; i < n; i++ )
        {
            String name = in.nextLine();
            int phone = in.nextInt();
            phoneBook.put( name, phone );
            in.nextLine();
        }
        while ( in.hasNext() )
        {
            String s = in.nextLine();
            System.out.println( phoneBook.containsKey( s ) ? s + "=" + phoneBook.get( s ) : "Not found" );
        }
        in.close();
    }

}
