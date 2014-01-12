package com.moowork.apirules.rule;

import java.util.regex.Pattern;

import com.moowork.apirules.Signature;
import com.moowork.apirules.Violation;

public final class Rule
{
    private final String message;

    private final String pattern;

    private final Pattern compiled;

    public Rule( final String message, final String pattern )
    {
        this.message = message;
        this.pattern = pattern;
        this.compiled = compile( this.pattern );
    }

    public String getMessage()
    {
        return this.message;
    }

    public String getPattern()
    {
        return this.pattern;
    }

    private boolean isViolation( final String signature )
    {
        return this.compiled.matcher( signature ).matches();
    }

    public Violation check( final Signature signature )
    {
        if ( isViolation( signature.getSignature() ) )
        {
            return new Violation( this.message, signature );
        }

        return null;
    }

    private static Pattern compile( final String pattern )
    {
        final String regExp = pattern.replace( "*", ".+" ).replace( ".", "\\." );
        return Pattern.compile( regExp );
    }
}
