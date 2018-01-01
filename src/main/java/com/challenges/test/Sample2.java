package com.challenges.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sample2
{
    static int[] oddNumbers( int l, int r )
    {
        List<Integer> partialResult = new ArrayList<>();
        for ( int i = l; i <= r; i++ )
        {
            if ( i % 2 == 1 )
            {
                partialResult.add( i );
            }
        }
        int[] result = new int[partialResult.size()];
        for ( int i = 0; i < result.length; i++ )
        {
            result[i] = partialResult.get( i );
        }
        return result;
    }

    public static void main( String[] args ) throws IOException
    {
        Scanner in = new Scanner( System.in );
        int[] res;
        int _l;
        _l = Integer.parseInt( in.nextLine().trim() );

        int _r;
        _r = Integer.parseInt( in.nextLine().trim() );

        in.close();

        res = oddNumbers( _l, _r );
        for ( int res_i = 0; res_i < res.length; res_i++ )
        {
            System.out.println( String.valueOf( res[res_i] ) );
        }
    }

}
