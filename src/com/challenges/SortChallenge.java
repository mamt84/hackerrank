package com.challenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortChallenge
{

    public static void main( String[] args )
    {
        Scanner in = new Scanner( System.in );
        int testCases = Integer.parseInt( in.nextLine() );

        List<Student> studentList = new ArrayList<Student>();
        while ( testCases > 0 )
        {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student( id, fname, cgpa );
            studentList.add( st );

            testCases--;
        }

        in.close();

        Collections.sort( studentList );

        for ( Student st : studentList )
        {
            System.out.println( st.getFname() );
        }

    }

    static class Student implements Comparable<Student>
    {
        private int    id;
        private String fname;
        private double cgpa;

        public Student( int id, String fname, double cgpa )
        {
            super();
            this.id = id;
            this.fname = fname;
            this.cgpa = cgpa;
        }

        public int getId()
        {
            return id;
        }

        public String getFname()
        {
            return fname;
        }

        public double getCgpa()
        {
            return cgpa;
        }

        @Override
        public int compareTo( Student o )
        {
            int result = Double.compare( o.cgpa, cgpa );
            result = result == 0 ? fname.compareTo( o.fname ) : result;
            result = result == 0 ? Integer.compare( id, o.id ) : result;
            return result;
        }
    }
}
