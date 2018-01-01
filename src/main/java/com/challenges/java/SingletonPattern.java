package com.challenges.java;

public class SingletonPattern
{
    public String str;

    private static SingletonPattern instance;

    private SingletonPattern()
    {

    }

    public static SingletonPattern getSingleInstance()
    {
        if ( instance == null )
        {
            instance = new SingletonPattern();
        }
        return instance;
    }
}
