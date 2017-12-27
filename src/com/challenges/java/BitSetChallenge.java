package com.challenges.java;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;

public class BitSetChallenge
{

    public static void main( String[] args )
    {
        Scanner in = new Scanner( System.in );
        int N = in.nextInt();
        int M = in.nextInt();

        List<BitSet> sets = new ArrayList<>( 2 );
        sets.add( new BitSet( N ) );
        sets.add( new BitSet( N ) );

        while ( M-- > 0 )
        {
            String operation = in.next();
            int left = in.nextInt();
            int right = in.nextInt();

            if ( "AND".equals( operation ) )
            {
                sets.get( left - 1 ).and( sets.get( right - 1 ) );
            }
            else if ( "OR".equals( operation ) )
            {
                sets.get( left - 1 ).or( sets.get( right - 1 ) );
            }
            else if ( "XOR".equals( operation ) )
            {
                sets.get( left - 1 ).xor( sets.get( right - 1 ) );
            }
            else if ( "FLIP".equals( operation ) )
            {
                sets.get( left - 1 ).flip( right );
            }
            else if ( "SET".equals( operation ) )
            {
                sets.get( left - 1 ).set( right );
            }

            System.out.printf( "%d %d\n", sets.get( 0 ).cardinality(), sets.get( 1 ).cardinality() );
        }

        in.close();
    }

}
