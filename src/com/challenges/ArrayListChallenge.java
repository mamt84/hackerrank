package com.challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListChallenge
{

    public static void main( String[] args )
    {
        Scanner in = new Scanner( System.in );
        
        int n = in.nextInt();
        List<List<Integer>> main = new ArrayList<>( n );
        while(n-- > 0){
            int d = in.nextInt();
            List<Integer> list = new ArrayList<>( d );
            while ( d-- > 0 )
            {
                list.add( in.nextInt() );
            }
            main.add( list );
        }
        
        int q = in.nextInt();
        while ( q-- > 0 )
        {
            int x = in.nextInt() - 1;
            int y = in.nextInt() - 1;
            if ( x < 0 || x >= main.size() || y < 0 || y >= main.get( x ).size() )
            {
                System.out.println( "ERROR!" );
            }
            else
            {
                System.out.println( main.get( x ).get( y ) );
            }
        }

        in.close();
    }

}
