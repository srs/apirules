package com.moowork.apirules;

import java.net.URL;
import java.net.URLClassLoader;

import com.moowork.apirules.internal.CheckerImpl;
import com.moowork.apirules.rule.Rules;
import com.moowork.apirules.validator.RulesValidator;
import com.moowork.apirules.validator.SignatureValidator;

// http://code.google.com/p/forbidden-apis
public abstract class Checker
{
    public final Checker classPath( final URL... urls )
    {
        return classPath( null, urls );
    }

    public abstract Checker classPath( ClassLoader classLoader );

    public final Checker classPath( final ClassLoader classLoader, final URL... urls )
    {
        return classPath( new URLClassLoader( urls, classLoader ) );
    }

    public abstract Checker includePackages( String... packageNames );

    public abstract Checker excludePackages( String... packageNames );

    public final Checker rules( Rules rules )
    {
        return validator( new RulesValidator( rules ) );
    }

    public abstract Checker validator( SignatureValidator validator );

    public abstract Violations check();

    public static Checker newChecker()
    {
        return new CheckerImpl();
    }
}
