package com.challenges.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/*
 * Problem Definition: Find the most busy period of time in a medical clinic. For this
 * problem the input will consist on an integer n describing the amount of patient that
 * visit the clinic during the day, then n lines with 2 strings separated by space
 * containing the arriving and leaving time of each patient, the time will be in military
 * time and will follow the format hh:mm As output print 1 line containing the amount of
 * patients in the most busy period of time followed by the initial time and final time of
 * such period, all of them separated by 1 space.
 */

class Patient
{
    int  id;
    Date initialTime;
    Date finalTime;

    public Patient( int id, Date initialTime, Date finalTime )
    {
        this.id = id;
        this.initialTime = initialTime;
        this.finalTime = finalTime;
    }
}

class Snapshot implements Comparable<Snapshot>
{
    Patient patient;
    Date    time;
    boolean arriving;
    
    public Snapshot( Patient patient, Date time, boolean arriving )
    {
        this.patient = patient;
        this.time = time;
        this.arriving = arriving;
    }

    @Override
    public int compareTo( Snapshot other )
    {
        int timeComparison = time.compareTo( other.time );
        return timeComparison != 0 ? timeComparison : arriving ? 1 : -1;
    }
}

public class ClinicPatients
{
    public static void main( String[] args ) throws Exception
    {
        Scanner in = new Scanner( System.in );

        int n = in.nextInt();
        in.nextLine();

        List<Snapshot> snapshots = new ArrayList<>( n );
        DateFormat dateFormat = new SimpleDateFormat( "HH:mm" );
        for ( int i = 0; i < n; i++ )
        {
            String[] components = in.nextLine().split( " " );
            Patient patient = new Patient( i, dateFormat.parse( components[0] ), dateFormat.parse( components[1] ) );
            snapshots.add( new Snapshot( patient, patient.initialTime, true ) );
            snapshots.add( new Snapshot( patient, patient.finalTime, false ) );
        }
        in.close();

        Collections.sort( snapshots );

        int patientCount = 0;
        int maxPatientCount = 0;
        Patient firstPatient = snapshots.iterator().next().patient;
        Date initialBusiestPeriod = firstPatient.initialTime;
        Date finalBusiestPeriod = firstPatient.finalTime;
        boolean busiest = false;
        for ( Snapshot snapshot : snapshots )
        {
            if ( snapshot.arriving )
            {
                patientCount++;
                if ( patientCount > maxPatientCount )
                {
                    maxPatientCount = patientCount;
                    initialBusiestPeriod = snapshot.time;
                    busiest = true;
                }
            }
            else
            {
                if ( busiest )
                {
                    finalBusiestPeriod = snapshot.time;
                    busiest = false;
                }
                patientCount--;
            }
        }

        System.out.println( maxPatientCount + " " + dateFormat.format( initialBusiestPeriod ) + " "
                + dateFormat.format( finalBusiestPeriod ) );
    }

}
