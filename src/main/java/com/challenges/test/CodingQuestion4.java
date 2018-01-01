package com.challenges.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CodingQuestion4
{
    public static String WordCount( String toCount )
    {
        if ( toCount == null || toCount.length() == 0 )
        {
            return "";
        }

        String[] tokens = toCount.toLowerCase().split( " " );
        Map<String, Integer> countMap = new HashMap<>();

        for ( String token : tokens )
        {
            if ( countMap.containsKey( token ) )
            {
                countMap.put( token, countMap.get( token ) + 1 );
            }
            else
            {
                countMap.put( token, 1 );
            }
        }

        List<String> uniqueWords = new ArrayList<>( countMap.size() );
        uniqueWords.addAll( countMap.keySet() );
        Collections.sort( uniqueWords );

        StringBuilder result = new StringBuilder();
        for ( String word : uniqueWords )
        {
            result.append( word ).append( " - " ).append( countMap.get( word ) ).append( "; " );
        }
        return result.toString();
    }

    public static void main( String[] args )
    {
        Scanner sc = new Scanner( System.in );
        System.out.println( WordCount( sc.nextLine() ) );
    }

}
