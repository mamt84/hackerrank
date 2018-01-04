package com.challenges.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Vertex
{
    int          id;
    int          color     = 0;
    Set<Integer> adjacents = new HashSet<>();

    public Vertex( int id )
    {
        this.id = id;
    }
}

public class RoadsAndLibraries
{

    static int roadsAndLibraries( int n, int c_lib, int c_road, int[][] cities )
    {
        if ( c_lib < c_road )
            return n * c_lib;
        Map<Integer, Vertex> graph = new HashMap<>( n );
        for ( int i = 0; i < cities.length; i++ )
        {
            if ( graph.containsKey( cities[i][0] ) )
                graph.get( cities[i][0] ).adjacents.add( cities[i][1] );
            else
                graph.put( cities[i][0], new Vertex( cities[i][0] ) );
        }
        return 0;
    }

    public static void main( String[] args )
    {
        Scanner in = new Scanner( System.in );
        int q = in.nextInt();
        for ( int a0 = 0; a0 < q; a0++ )
        {
            int n = in.nextInt();
            int m = in.nextInt();
            int c_lib = in.nextInt();
            int c_road = in.nextInt();
            int[][] cities = new int[m][2];
            for ( int cities_i = 0; cities_i < m; cities_i++ )
            {
                for ( int cities_j = 0; cities_j < 2; cities_j++ )
                {
                    cities[cities_i][cities_j] = in.nextInt();
                }
            }
            int result = roadsAndLibraries( n, c_lib, c_road, cities );
            System.out.println( result );
        }
        in.close();
    }

}
