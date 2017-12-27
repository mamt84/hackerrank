package com.challenges.java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DequeueChallenge
{

    public static void main( String[] args )
    {
        Scanner in = new Scanner( System.in );

        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();

        int n = in.nextInt();
        int m = in.nextInt();
        int max = Integer.MIN_VALUE;

        for ( int i = 0; i < n; i++ )
        {
            int num = in.nextInt();
            deque.add( num );
            if ( map.containsKey( num ) )
            {
                map.put( num, map.get( num ) + 1 );
            }
            else
            {
                map.put( num, 1 );
            }

            if ( deque.size() == m )
            {
                if ( map.size() > max )
                {
                    max = map.size();
                }
                Integer removed = deque.remove();
                if ( map.containsKey( removed ) )
                {
                    Integer count = map.get( removed );

                    if ( count > 1 )
                    {
                        map.put( removed, count - 1 );
                    }
                    else
                    {
                        map.remove( removed );
                    }
                }
            }
        }
        in.close();

        System.out.println( max );
    }

}
