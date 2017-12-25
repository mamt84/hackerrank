package com.challenges;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class StackChallenge
{

    public static void main( String[] args )
    {
        Scanner sc = new Scanner( System.in );

        Map<Character, Character> match = new HashMap<>();
        match.put( '}', '{' );
        match.put( ']', '[' );
        match.put( ')', '(' );

        Stack<Character> stack = new Stack<>();

        while ( sc.hasNext() )
        {
            stack.clear();
            String input = sc.next();
            boolean result = true;

            for ( int i = 0; i < input.length(); i++ )
            {
                if ( isOpening( input.charAt( i ) ) )
                {
                    stack.push( input.charAt( i ) );
                }
                else
                {
                    if ( stack.isEmpty() || !stack.pop().equals( match.get( input.charAt( i ) ) ) )
                    {
                        result = false;
                        break;
                    }
                }
            }
            result = result && stack.isEmpty();

            System.out.println( result );
        }

        sc.close();
    }

    private static boolean isOpening( char character )
    {
        return '{' == character || '[' == character || '(' == character;
    }

}
