package com.challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueueChallenge
{
    private final static Scanner    scan       = new Scanner( System.in );
    private final static Priorities priorities = new Priorities();

    public static void main( String[] args )
    {
        int totalEvents = Integer.parseInt( scan.nextLine() );
        List<String> events = new ArrayList<>();

        while ( totalEvents-- != 0 )
        {
            String event = scan.nextLine();
            events.add( event );
        }

        List<Student> students = priorities.getStudents( events );

        if ( students.isEmpty() )
        {
            System.out.println( "EMPTY" );
        }
        else
        {
            for ( Student st : students )
            {
                System.out.println( st.getName() );
            }
        }
    }

    public static class Student implements Comparable<Student>
    {
        private int    id;

        private String name;

        private double CGPA;

        public Student( int id, String name, double cGPA )
        {
            super();
            this.id = id;
            this.name = name;
            CGPA = cGPA;
        }

        public int getId()
        {
            return id;
        }

        public String getName()
        {
            return name;
        }

        public double getCGPA()
        {
            return CGPA;
        }

        @Override
        public int compareTo( Student o )
        {
            int result = Double.compare( o.CGPA, CGPA );
            result = result == 0 ? name.compareTo( o.name ) : result;
            result = result == 0 ? Integer.compare( id, o.id ) : result;
            return result;
        }
    }

    public static class Priorities
    {
        private PriorityQueue<Student> queue = new PriorityQueue<>();

        public List<Student> getStudents( List<String> events )
        {
            for ( String event : events )
            {
                String[] components = event.split( " " );
                if ( "ENTER".equals( components[0] ) )
                {
                    queue.add( new Student( Integer.parseInt( components[3] ), components[1],
                            Double.parseDouble( components[2] ) ) );
                }
                else
                {
                    queue.poll();
                }
            }

            List<Student> result = new ArrayList<>();
            while ( !queue.isEmpty() )
            {
                result.add( queue.poll() );
            }
            return result;
        }
    }

}
