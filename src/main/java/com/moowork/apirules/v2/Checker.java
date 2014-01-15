package com.moowork.apirules.v2;

import java.net.URL;

import com.moowork.apirules.v2.rule.Rules;

public abstract class Checker
{
    public abstract Checker classPath( final URL... urls );

    public abstract Checker classPath( ClassLoader classLoader );

    public abstract Checker classPath( final ClassLoader classLoader, final URL... urls );

    public abstract Checker includePackages( String... packageNames );

    public abstract Checker excludePackages( String... packageNames );

    public abstract Checker rules( Rules rules );

    public abstract Result check();

    public static Checker create()
    {
        return null;
    }
}
