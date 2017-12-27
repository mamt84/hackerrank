package com.challenges;

class Flower
{
    public String whatsYourName()
    {
        return "I have many names and types";
    }
}

class Jasmine extends Flower
{
    @Override
    public String whatsYourName()
    {
        return "Jasmine";
    }
}

class Lily extends Flower
{
    @Override
    public String whatsYourName()
    {
        return "Lily";
    }
}

class Lotus extends Flower
{
    @Override
    public String whatsYourName()
    {
        return "Lotus";
    }
}

class State
{
    public Flower yourNationalFlower()
    {
        return new Flower();
    }
}

class WestBengal extends State
{
    @Override
    public Jasmine yourNationalFlower()
    {
        return new Jasmine();
    }
}

class Karnataka extends State
{
    @Override
    public Lotus yourNationalFlower()
    {
        return new Lotus();
    }
}

class AndhraPradesh extends State
{
    @Override
    public Lily yourNationalFlower()
    {
        return new Lily();
    }
}

public class Covariance
{

    public static void main( String[] args )
    {
        // TODO Auto-generated method stub

    }

}
