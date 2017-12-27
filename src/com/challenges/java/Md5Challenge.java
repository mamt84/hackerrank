package com.challenges.java;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.xml.bind.DatatypeConverter;

public class Md5Challenge
{
    public static void main( String[] args )
    {
        Scanner in = new Scanner( System.in );
        String password = in.nextLine();

        try
        {
            MessageDigest messageDigest = MessageDigest.getInstance( "MD5" );
            byte[] hash = messageDigest.digest( password.getBytes() );

            // System.out.println( new String( hash, Charset.forName( "UTF-8" ) ) );
            System.out.println( DatatypeConverter.printHexBinary( hash ).toLowerCase() );
        }
        catch ( NoSuchAlgorithmException e )
        {
            e.printStackTrace();
        }

        in.close();
    }

}
