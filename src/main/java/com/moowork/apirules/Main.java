package com.moowork.apirules;

public class Main
{
    public static void main( final String... args )
        throws Exception
    {
        final Checker checker = Checker.newChecker();
        checker.classPath( Main.class.getClassLoader() );
        checker.includePackages( "com.moowork.apirules.sample" );


        /*
        for ( final Violation violation : checker.check() )
        {
            System.out.println( violation );
        }
        */
    }
}
