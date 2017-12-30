package com.challenges.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Sample1
{
    static String findNumber( int[] arr, int k )
    {
        for ( int i : arr )
        {
            if ( i == k )
            {
                return "YES";
            }
        }
        return "NO";
    }

    public static void main( String[] args ) throws IOException
    {
        Scanner in = new Scanner( System.in );
        final String fileName = System.getenv( "OUTPUT_PATH" );
        BufferedWriter bw = new BufferedWriter( new FileWriter( fileName ) );
        String res;

        int _arr_size = 0;
        _arr_size = Integer.parseInt( in.nextLine().trim() );
        int[] _arr = new int[_arr_size];
        int _arr_item;
        for ( int _arr_i = 0; _arr_i < _arr_size; _arr_i++ )
        {
            _arr_item = Integer.parseInt( in.nextLine().trim() );
            _arr[_arr_i] = _arr_item;
        }

        int _k;
        _k = Integer.parseInt( in.nextLine().trim() );

        res = findNumber( _arr, _k );
        bw.write( res );
        bw.newLine();

        bw.close();
    }

}
